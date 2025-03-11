package org.example;

public class LongestPalindomicsubstring {

    public static void main(String[] args) {
        String s = new Solution().longestPalindrome("ababa");
        System.out.println(s);
    }

    private static class Solution {
        public String longestPalindrome(String s) {

            final int n = s.length();
            if (n == 0) {
                return "";
            }

            int l = 0, r = 0;

            for (int i = 0; i < n; i++) {

                int[] res;

                res = polyndromIndeces(i, i, s);

                if (r - l < res[1] - res[0]) {
                    l = res[0];
                    r = res[1];
                }

                if (i < n - 1) {
                    res = polyndromIndeces(i, i + 1, s);
                }

                if (r - l < res[1] - res[0]) {
                    l = res[0];
                    r = res[1];
                }
            }


            return s.substring(l, r + 1);
        }

        private int[] polyndromIndeces(int left, int right, String s) {
            int[] result = new int[2];
            int n = s.length();

            while (left > -1 && right < n && s.charAt(left) == s.charAt(right)) {
                result[0] = left;
                result[1] = right;
                left--;
                right++;
            }

            return result;
        }


    }

}
