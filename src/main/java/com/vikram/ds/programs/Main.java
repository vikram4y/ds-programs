package com.vikram.ds.programs;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String str = "abc";
        printAll(str);
    }

    private static void printAll(String str) {
        boolean[] flag = new boolean[str.length()];
        permute(str,"", flag);
    }

    private static void permute(String str, String cur, boolean[] flag) {
        if (cur.length() == str.length()) {
            System.out.println(cur);
            return;
        }
        for (int i=0;i<str.length();i++) {
            if (flag[i])
                continue;
            flag[i] = true;
            permute(str, cur+str.charAt(i), flag);
            flag[i] = false;
        }
    }

}