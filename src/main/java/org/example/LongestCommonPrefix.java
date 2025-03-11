package org.example;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        final String[] strs = { "abab","aba","" };
        System.out.println(new Solution().longestCommonPrefix(strs));
    }

    private static class Solution {

        public String longestCommonPrefix(String[] strs) {
            String longestPrefix = strs[0];
            for (String str : strs) {
                final StringBuilder available = new StringBuilder();
                for (int j = 0; j < longestPrefix.length() && j < str.length(); j++) {
                    if (longestPrefix.charAt(j) != str.charAt(j)) {
                        break;
                    } else {
                        available.append(str.charAt(j));
                    }
                }
                longestPrefix = available.toString();
            }

            return longestPrefix;
        }
    }

}
