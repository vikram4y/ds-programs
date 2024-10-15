package com.vikram.ds.programs.linkedlist.medium;

import com.vikram.ds.programs.linkedlist.utils.Node;

public class MiddleOfLL {
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

        Node middle = middleOfLL(head);
        System.out.println("Middle = "+middle.data);
    }

    private static Node middleOfLL(Node head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        Node slow = head;
        Node fast = head;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
