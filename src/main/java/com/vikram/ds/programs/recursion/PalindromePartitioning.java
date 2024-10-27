package com.vikram.ds.programs.recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String str = "aab";
        PalindromePartitioning p = new PalindromePartitioning();
        List<List<String>> list = p.partition(str);
        list.forEach(System.out::println);
    }

    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        part(0, s, new ArrayList<>(), list);
        return list;
    }

    private void part
            (int index, String s, List<String> curList, List<List<String>> list) {
        if (index == s.length()) {
            list.add(new ArrayList<>(curList));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i+1);
            if (isPalindrome(sub)) {
                curList.add(sub);
                part(i+1, s, curList, list);
                curList.remove(curList.size()-1);
            }
        }
    }

    private boolean isPalindrome(String sub) {
        for (int i = 0 , j = sub.length()-1; i < j; i++, j--) {
            if (sub.charAt(i) != sub.charAt(j))
                return false;
        }
        return true;
    }

}
