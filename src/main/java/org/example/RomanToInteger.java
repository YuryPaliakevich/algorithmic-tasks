package org.example;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        int i = new Solution().romanToInt("MCMXCIV");
        System.out.println(i);
    }

    private static class Solution {

        public int romanToInt(String s) {
            final Map<Character, Integer> characterOccurrence = new HashMap<>();
            char[] charArray = s.toCharArray();
            int result = 0;

            for (int i = charArray.length - 1; i > -1; i--) {
                char c = charArray[i];
                if ('I' == c && (characterOccurrence.getOrDefault('V', Integer.MAX_VALUE) == i + 1 || characterOccurrence.getOrDefault('X', Integer.MAX_VALUE) == i + 1)) {
                    result--;
                } else if ('X' == c && (characterOccurrence.getOrDefault('L', Integer.MAX_VALUE) == i + 1 || characterOccurrence.getOrDefault('C', Integer.MAX_VALUE) == i + 1)) {
                    result -= 10;
                } else if ('C' == c && (characterOccurrence.getOrDefault('D', Integer.MAX_VALUE) == i + 1 || characterOccurrence.getOrDefault('M', Integer.MAX_VALUE) == i + 1)) {
                    result -= 100;
                } else {
                    result += getValue(c);
                }

                characterOccurrence.put(c, i);
            }

            return result;
        }

        private int getValue(char c) {
            switch (c) {
                case 'I': return 1;
                case 'V': return 5;
                case 'X': return 10;
                case 'L': return 50;
                case 'C': return 100;
                case 'D': return 500;
                case 'M': return 1000;
                default: return 0;
            }
        }

    }

}
