package com.feng.algorthm.link;

/**
 * @author
 * @time 2022/7/17 11:39
 * @Description- 单链表和双链表反转
 */
public class ReverseLink {

    /**
     * 单向链表
     */
    public static class Node {
        public int value;
        public Node next;

        public Node(int data){
            value = data;
        }
    }
    /**
     * 双向链表
     */
    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data){
            value = data;
        }
    }

    /**
     * 反转单链表
     * @param head
     * @return
     */
    public static Node reverseLinkedList(Node head){
        Node pre = null;
        Node next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }
    /**
     * 反转双链表
     * @param head
     * @return
     */
    public static DoubleNode reverseDoubleLinkedList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }

        return pre;
    }
}
