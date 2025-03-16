package org.example;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = new int[] {2,3,5};
        List<List<Integer>> lists = new Solution().combinationSum(candidates, 8);
        System.out.println(lists);
    }

    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            backtrack(candidates, target, 0, new ArrayList<>(), result);
            return result;
        }

        private void backtrack(int[] candidates, int target, int start, List<Integer> currentCombination, List<List<Integer>> result) {
            if (target == 0) {
                result.add(new ArrayList<>(currentCombination));
                return;
            }

            if (target < 0) {
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                currentCombination.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i, currentCombination, result);
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
    }

}
