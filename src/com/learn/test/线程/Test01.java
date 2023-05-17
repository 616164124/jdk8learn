package com.learn.test.线程;

import java.util.concurrent.*;

public class Test01 {
    public static void main(String[] args) {
        ThreadPoolExecutor pool1 = new ThreadPoolExecutor(12, 12, 100, TimeUnit.SECONDS, new LinkedBlockingQueue<>(12));
        ThreadPoolExecutor pool2 = new ThreadPoolExecutor(12, 12, 100, TimeUnit.SECONDS, new LinkedBlockingQueue<>(12));
//        pool2.execute(()->{
//            threadTest();
//        });

        //submit这里执行不会报错
        pool2.submit(() -> {
            int i = 1 / 0;
        });
        //execute这个会报错
        pool2.execute(() -> {
            int i = 2 / 0;
        });
        /**
         * sumbit 返回的是future 如果报错只能从future中获取，不会抛出异常
         * execute 直接抛出异常
         */


        //pool2.submit 不能获取线程中的异常，
        //   1、可以用future。get的形式获取
        //   2、就是用重写tThreadPoolExecutor 里的afterexecutor方法将异常捕获
        Future<?> submit = new ExtendedExecutorTest().submit(() -> {
            int i = 1 / 0;
        });
        try {
            submit.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Future<?> submit1 = pool1.submit(() -> {
            int i = 1 / 0;
        });
    }

    private static int threadTest() {
        int i = 1 / 0;
        return i;
    }
}

class ExtendedExecutorTest extends ThreadPoolExecutor {

    public ExtendedExecutorTest() {
        super(12, 12, 100, TimeUnit.SECONDS, new LinkedBlockingQueue<>(12));
    }

    // ...在线程run方法中
    public void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        if (t == null && r instanceof Future<?>) {
            try {
                Object result = ((Future<?>) r).get();
            } catch (CancellationException ce) {
                t = ce;
            } catch (ExecutionException ee) {
                t = ee.getCause();
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt(); // ignore/reset
            }
        }
        if (t != null)
            System.out.println(t);
    }


}


