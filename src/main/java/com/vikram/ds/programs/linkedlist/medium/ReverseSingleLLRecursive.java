package com.vikram.ds.programs.linkedlist.medium;

import com.vikram.ds.programs.linkedlist.utils.Node;

public class ReverseSingleLLRecursive {
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

        head = reverse(head, null);
        printLinkedList(head);
    }

    private static Node reverse(Node current, Node prev) {
        if (current == null) {
            return prev; // When current is null, prev will be the new head
        }

        Node next = current.next; // Store the next node
        current.next = prev; // Reverse the link
        return reverse(next, current); // Recur with next and current
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
