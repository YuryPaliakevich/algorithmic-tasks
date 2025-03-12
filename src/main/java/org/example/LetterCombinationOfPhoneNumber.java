package org.example;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNumber {

    public static void main(String[] args) {
        final List<String> strings = new Solution().letterCombinations("23");
        System.out.println(strings);
    }

    private static class Solution {

        public List<String> letterCombinations(String digits) {
            if (digits.isEmpty()) {
                return new ArrayList<>();
            }
            final List<String> solution = new ArrayList<>();
            final String[] digitToLetters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
            backtrack(solution, digits, digitToLetters, new StringBuilder(), 0);
            return solution;
        }

        private void backtrack(List<String> result, String digits, String[] digitToLetters, StringBuilder path, int index) {
            if (path.length() == digits.length()) {
                result.add(path.toString());
                return;
            }

            String letters = digitToLetters[digits.charAt(index) - '0'];
            for (char letter : letters.toCharArray()) {
                path.append(letter);
                backtrack(result, digits, digitToLetters, path, index + 1);
                path.deleteCharAt(path.length() - 1);
            }
        }

    }

}














