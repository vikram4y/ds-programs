package com.vikram.ds.programs.linkedlist.easy;

import com.vikram.ds.programs.linkedlist.utils.Node;

public class ReverseDoublyLL {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        Node head = n1;
        n1.prev = null;
        n1.next = n2;
        n2.prev = n1;
        n2.next = n3;
        n3.prev = n2;
        n3.next = null;

        head = reverseDoublyLL(head);
        printLinkedList(head);
    }

    private static Node reverseDoublyLL(Node head) {
        if (head == null)
            return head;
        if (head.next == null)
            return head;
        Node current = head;
        Node prev = null;
        while(current!=null){
            Node temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            prev = current;
            current = current.prev;
        }
        return prev;
    }

    private static void printLinkedList(Node head) {
        if (head == null)
            return;
        Node current = head;
        while (current != null) {
            System.out.print(current.data+"->");
            current = current.next;
        }
    }
}
