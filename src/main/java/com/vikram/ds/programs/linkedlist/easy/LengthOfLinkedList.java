package com.vikram.ds.programs.linkedlist.easy;

import com.vikram.ds.programs.linkedlist.utils.Node;

public class LengthOfLinkedList {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        Node head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = null;

        int length = lengthOfLinkedList(head);
        System.out.println("Length of linked list: "+length);
    }

    private static int lengthOfLinkedList(Node head) {
        int length = 0;
        while (head!=null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
