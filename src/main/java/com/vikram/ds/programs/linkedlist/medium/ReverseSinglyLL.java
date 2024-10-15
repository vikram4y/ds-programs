package com.vikram.ds.programs.linkedlist.medium;

import com.vikram.ds.programs.linkedlist.utils.Node;

public class ReverseSinglyLL {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        Node head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;

        head = reverse(head);
        printLinkedList(head);
    }

    private static Node reverse(Node head) {
        if (head == null || head.next == null)
            return head; // If the list is empty or has only one node, return it as is.

        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next; // Store the next node
            current.next = prev; // Reverse the current node's pointer
            prev = current; // Move prev one step forward
            current = next; // Move current one step forward
        }

        return prev; // prev now points to the new head of the reversed list
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
