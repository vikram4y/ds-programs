package com.vikram.ds.programs.linkedlist.easy;

import com.vikram.ds.programs.linkedlist.utils.Node;

public class DeleteTailOfLinkedList {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        Node head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = null;

        head = deleteTail(head);
        printLinkedList(head);
    }

    private static Node deleteTail(Node head) {
        if (head == null)
            return null;
        if (head.next == null) {
            return null;
        }
        Node prev = head;
        Node current = head;
        while(current.next != null) {
            prev = current;
            current = current.next;
        }
        prev.next = null;
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
