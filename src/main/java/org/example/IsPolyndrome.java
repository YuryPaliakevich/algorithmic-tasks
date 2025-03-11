package org.example;

public class IsPolyndrome {

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(1091));
    }

    private static class Solution {
        public boolean isPalindrome(int x) {
            final String value = String.valueOf(x);
            int i = 0; int j = value.length() - 1;

            while (i <= j) {
                if (value.charAt(i) != value.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }

            return true;
        }
    }
}
