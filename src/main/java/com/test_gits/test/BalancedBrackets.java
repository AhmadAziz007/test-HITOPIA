package com.test_gits.test;

import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args) {
        System.out.println(isBalanced("{ [ ( ) ] }"));     // Output: YES
        System.out.println(isBalanced("{ [ ( ] ) }"));     // Output: NO
        System.out.println(isBalanced("{ ( ( [ ] ) [ ] ) [ ] }")); // Output: YES
    }

    public static String isBalanced(String brackets) {
        Stack<Character> stack = new Stack<>();

        for (char ch : brackets.toCharArray()) {
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return "NO";
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return "NO";
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return "NO";
                    }
                    break;
                default:
                    // Ignore any non-bracket characters (e.g., whitespace)
                    break;
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }
}

