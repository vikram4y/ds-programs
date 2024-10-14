package com.vikram.ds.programs.linkedlist.easy;

import com.vikram.ds.programs.linkedlist.utils.Node;

public class InsertInLinkedList {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n2.next = n3;
        n1.next = n2;

        Node head = n1;

        head = insert(head, 10);

        printLinkedList(head);
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

    private static Node insert(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;
    }
}
