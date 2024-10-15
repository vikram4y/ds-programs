package com.vikram.ds.programs.linkedlist.easy;

import com.vikram.ds.programs.linkedlist.utils.Node;

public class DeleteLastNodeOfDoublyLL {
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

        head = deleteLastNode(head);
        printLinkedList(head);
    }

    private static Node deleteLastNode(Node head) {
        if (head == null || head.next == null)
            return null;
        Node current = head;
        while(current.next != null)
            current = current.next;
        current.prev.next = null;
        current.prev = null;
        return head;
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
