package org.example;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        List<String> strings = new Solution().generateParenthesis(3);
        System.out.println(strings);
    }

    private static class Solution {
        public List<String> generateParenthesis(int n) {
            final List<String> result = new ArrayList<>();

            backtrack(new StringBuilder(), 0, 0, n, result);

            return result;
        }

        private void backtrack(StringBuilder path, int left, int right, int n, List<String> result) {
            if (path.length() == n * 2) {
                result.add(path.toString());
                return;
            }

            if (left < n) {
                path.append('(');
                backtrack(path, left + 1, right, n, result);
                path.deleteCharAt(path.length() - 1);
            }

            if (right < left) {
                path.append(')');
                backtrack(path, left, right + 1, n, result);
                path.deleteCharAt(path.length() - 1);
            }

        }

    }

}
