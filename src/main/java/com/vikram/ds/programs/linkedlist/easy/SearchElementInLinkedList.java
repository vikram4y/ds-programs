package com.vikram.ds.programs.linkedlist.easy;

import com.vikram.ds.programs.linkedlist.utils.Node;

public class SearchElementInLinkedList {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        Node head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = null;

        boolean isFound = findElementInLL(head, 2);
        System.out.println("Element Found ? : "+isFound);
    }

    private static boolean findElementInLL(Node head, int x) {
        while (head!=null) {
            if (head.data == x)
                return true;
            head = head.next;
        }
        return false;
    }
}
