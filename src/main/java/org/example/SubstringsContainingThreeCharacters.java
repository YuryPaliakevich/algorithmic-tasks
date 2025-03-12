package org.example;

import java.util.HashMap;
import java.util.Map;

public class SubstringsContainingThreeCharacters {

    public static void main(String[] args) {
        int i = new Solution().numberOfSubstrings("abcabc");
        System.out.println(i);
    }

    private static class Solution {


        public int numberOfSubstrings(String s) {
            final Map<Character, Integer> symbols = new HashMap<>();
            int result = 0;
            int n = s.length();
            int left = 0;

            symbols.put('a', 0);
            symbols.put('b', 0);
            symbols.put('c', 0);

            final char[] characters = s.toCharArray();

            for (int i = 0; i < characters.length; i++) {
                final char symbol = characters[i];

                symbols.put(symbol, symbols.get(symbol) + 1);

                while (symbols.get('a') != 0 && symbols.get('b') != 0 && symbols.get('c') != 0) {
                    result += n - i;
                    char key = characters[left];
                    symbols.put(key, symbols.get(key) - 1);
                    left++;
                }

            }

            return result;
        }
    }

}















