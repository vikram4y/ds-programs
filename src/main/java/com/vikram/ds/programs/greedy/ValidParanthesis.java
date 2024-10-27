package com.vikram.ds.programs.greedy;

public class ValidParanthesis {
    public static void main(String[] args) {
        char[] exp = {'(', '(', '*', ')'};
        //boolean isValid = isValidExp(exp, 0, 0);
        boolean isValid = checkValidString(new String(exp));
        System.out.println("Is Valid: " + isValid);
    }

    public static boolean checkValidString(String s) {
        int minOpen = 0;  // Minimum possible open parentheses
        int maxOpen = 0;  // Maximum possible open parentheses

        for (char c : s.toCharArray()) {
            if (c == '(') {
                // Increment both counters if we see '('
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                // Decrement both counters if we see ')'
                minOpen--;
                maxOpen--;
            } else { // c == '*'
                // '*' can be '(', ')' or nothing
                minOpen--;   // Treat '*' as ')'
                maxOpen++;   // Treat '*' as '('
            }

            // minOpen can't go below 0 (because we can't have more closing parentheses than opening ones)
            if (minOpen < 0) {
                minOpen = 0;
            }

            // If maxOpen becomes negative, we have too many ')'
            if (maxOpen < 0) {
                return false;
            }
        }

        // After processing all characters, we should have exactly 0 minimum open parentheses
        return minOpen == 0;
    }

    //Recursive
    private static boolean isValidExp(char[] exp, int index, int count) {
        // If the count is negative, more ')' than '(' so far - invalid.
        if (count < 0)
            return false;

        // If we've reached the end, check if all '(' are matched.
        if (index == exp.length)
            return count == 0;

        // Check each character.
        if (exp[index] == '(') {
            // Increase count and move to the next character.
            return isValidExp(exp, index + 1, count + 1);
        } else if (exp[index] == ')') {
            // Decrease count (attempting to match a '(') and move to the next character.
            return isValidExp(exp, index + 1, count - 1);
        } else { // exp[index] == '*'
            // '*' can be considered as:
            // 1. Nothing (skip it), 2. '(', or 3. ')'
            return isValidExp(exp, index + 1, count) ||          // '*' as nothing
                    isValidExp(exp, index + 1, count + 1) ||      // '*' as '('
                    isValidExp(exp, index + 1, count - 1);        // '*' as ')'
        }
    }
}

