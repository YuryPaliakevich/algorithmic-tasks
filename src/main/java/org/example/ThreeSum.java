package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = new int[] { 2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10 };
        List<List<Integer>> lists = new Solution().threeSum(nums);
        System.out.println(lists);
    }

    private static class Solution {

        public List<List<Integer>> threeSum(int[] nums) {
            final List<List<Integer>> result = new ArrayList<>();
            final Set<List<Integer>> resultHash = new HashSet<>();

            int n = nums.length;
            int target = 0;
            Arrays.sort(nums);
            for (int i = 0; i < n - 2; i++) {
                int left = i + 1;
                int right = n - 1;
                if (nums[i] > target) {
                    break;
                }
                while (left < right) {
                    int localResult = nums[i] + nums[left] + nums[right];
                    if (localResult == target && !resultHash.contains(List.of(nums[i], nums[left], nums[right]))) {
                        result.add(List.of(nums[i], nums[left], nums[right]));
                        resultHash.add(List.of(nums[i], nums[left], nums[right]));
                    } else if (localResult < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return result;
        }
    }

}
