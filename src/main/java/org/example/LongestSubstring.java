package org.example;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    public static void main(String[] args) {
        final String str = "qrsvbspk";
        System.out.println(new Solution().lengthOfLongestSubstring(str));
    }

    private static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int left = 0;
            int maxLen = 0;
            final Map<Character, Integer> characters = new HashMap<>();
            for (int right = 0; right < s.length(); right++) {
                final char symbol = s.charAt(right);
                if (characters.containsKey(symbol) && characters.get(symbol) >= left) {
                    left = characters.get(symbol) + 1;
                }

                characters.put(symbol, right);
                maxLen = Math.max(maxLen, right - left + 1);
            }


            return maxLen;
        }
    }

}
