package org.example;

import java.util.Arrays;
import java.util.Stack;

public class NumberOfVisiblePeopleInQueue {

    public static void main(String[] args) {
        int[] ints = new Solution().canSeePersonsCount(new int[] { 10, 6, 8, 5, 11, 9 });
        System.out.println(Arrays.toString(ints));
    }

    private static class Solution {
        public int[] canSeePersonsCount(int[] heights) {
            final int n = heights.length;
            final int[] result = new int[n];
            final Stack<Integer> stack = new Stack<>();

            for (int i = n - 1; i > -1; i--) {
                int count = 0;
                while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                    count++;
                    stack.pop();
                }

                if (!stack.isEmpty()) {
                    count++;
                }

                stack.push(i);
                result[i] = count;
            }


            return result;
        }
    }

}
