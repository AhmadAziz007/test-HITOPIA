package com.test_gits.test;

public class HighestPalindrome {

    public static String highestPalindrome(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        String result = makePalindrome(chars, k, 0, n - 1);
        return result == null ? "-1" : result;
    }

    private static String makePalindrome(char[] chars, int k, int left, int right) {
        if (left >= right) {
            // Base case: if pointers have crossed, return the palindrome
            return new String(chars);
        }

        if (chars[left] == chars[right]) {
            // Characters match, proceed without changes
            return makePalindrome(chars, k, left + 1, right - 1);
        } else if (k > 0) {
            // Characters don't match, we need to make a change
            char maxChar = (char) Math.max(chars[left], chars[right]);
            chars[left] = maxChar;
            chars[right] = maxChar;
            // Use one change, move inward
            return makePalindrome(chars, k - 1, left + 1, right - 1);
        } else {
            // Not enough changes to make it a palindrome
            return null;
        }
    }

    private static String maximizePalindrome(char[] chars, int k, int left, int right) {
        if (left >= right || k <= 0) {
            // Base case: no changes left or pointers have crossed
            return new String(chars);
        }

        // Try to maximize each pair to '9' if we have enough changes
        if (chars[left] == chars[right]) {
            if (chars[left] != '9' && k >= 2) {
                chars[left] = '9';
                chars[right] = '9';
                // Use two changes to set both to '9'
                return maximizePalindrome(chars, k - 2, left + 1, right - 1);
            }
            return maximizePalindrome(chars, k, left + 1, right - 1);
        } else {
            // Characters don't match, they were modified in the previous step
            if (chars[left] != '9' || chars[right] != '9') {
                chars[left] = '9';
                chars[right] = '9';
                // Use one change to set both to '9'
                return maximizePalindrome(chars, k - 1, left + 1, right - 1);
            }
            return maximizePalindrome(chars, k, left + 1, right - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(highestPalindrome("3943", 1)); // Output: 3993
        System.out.println(highestPalindrome("932239", 2)); // Output: 992299
    }
}

