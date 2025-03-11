package org.example;

import java.util.Map;
import java.util.TreeMap;

public class TargetSum {

    public static void main(String[] args) {
        final int[] nums = { 1, 2, 3, 4, 6, 7, 8, 9 };
        final int target = 15;
        int[] ints = new Solution().twoSum(nums, target);
        System.out.println(ints[0] + " " + ints[1]);
    }

    private static class Solution {
        public int[] twoSum(int[] nums, int target) {
            final Map<Integer, Integer> map = new TreeMap<>();
            final int[] result = new int[2];
            map.put(nums[0], 0);
            for (int i = 1; i < nums.length; i++) {
                final Integer resultIndex = map.get(target - nums[i]);
                if (resultIndex != null) {
                    result[0] = i;
                    result[1] = resultIndex;
                    break;
                }
                map.put(nums[i], i);
            }

            return result;
        }
    }


}
