package com.learn.test.链表;

import java.lang.management.ManagementFactory;

/**
 *
 */
public class Node {
    public Node next;
    public Object data;

    public Node() {

    }

    public Node(Object data) {
        this.data = data;
    }

    public static void main(String[] args) {
        Node node = new Node();
        node.next = new Node("赵");
        node.next.next = new Node("钱");
        node.next.next.next = new Node("孙");
        System.out.println(node.next.data);//赵
        System.out.println(node.next.next.data);//钱
        System.out.println(node.next.next.next.data);//孙

    }
}
