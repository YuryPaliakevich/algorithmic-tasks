package org.example;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3 };
        List<List<Integer>> subsets = new Solution().subsets(nums);
        System.out.println(subsets);
    }

    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            final List<List<Integer>> result = new ArrayList<>();
            backtracking(0, new ArrayList<>(), nums, result);
            return result;
        }

        private void backtracking(int index, List<Integer> currentStack, int[] nums, List<List<Integer>> result) {
            if (index > nums.length) {
                return;
            }

            result.add(new ArrayList<>(currentStack));

            for (int i = index; i < nums.length; i++) {
                currentStack.add(nums[i]);
                backtracking(i + 1, currentStack, nums, result);
                currentStack.remove(currentStack.size() - 1);
            }
        }

    }

}
