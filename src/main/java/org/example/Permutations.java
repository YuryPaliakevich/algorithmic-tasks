package org.example;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        List<List<Integer>> permute = new Solution().permute(new int[] { 1, 2, 3 });
        System.out.println(permute);
    }

   static class Solution {

        public List<List<Integer>> permute(int[] nums) {
            final List<List<Integer>> result = new ArrayList<>();
            backtracking(result, nums, new ArrayList<>());
            return result;
        }

        private void backtracking(List<List<Integer>> result, int[] nums, List<Integer> stack) {
            if (stack.size() == nums.length) {
                result.add(new ArrayList<>(stack));
                return;
            }

            for (int num : nums) {
                if (!stack.contains(num)) {
                    stack.add(num);
                    backtracking(result, nums, stack);
                    stack.remove(stack.size() - 1);
                }
            }
        }
    }
}
