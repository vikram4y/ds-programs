package com.vikram.ds.programs.strings.easy;

import java.util.Stack;

public class ReverseWordsInSentence {
    public static void main(String[] args) {
        String s = "This is a sentence";
        System.out.println("Reversed = "+ reversed(s));
    }

    //Can use split if allowed
    private static String reversed(String s) {
        Stack<String> stack = new Stack<>();
        int left = 0;
        int right = 0;
        while (right<s.length()) {
            if (s.charAt(right) != ' ')
                right++;
            else {
                if (right == 0) {
                    left = 1;
                    right = 1;
                } else {
                    stack.push(s.substring(left, right));
                    right++;
                    left = right;
                }
            }
            if (right == s.length())
                stack.push(s.substring(left, right));
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
            if (!stack.isEmpty())
                sb.append(" ");
        }
        return sb.toString();
    }
}
