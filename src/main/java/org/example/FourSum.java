package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {

    public static void main(String[] args) {
        int[] a = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        List<List<Integer>> lists = new Solution().fourSum(a, target);
        System.out.println(lists);
    }

    private static class Solution {

        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);

            final Set<List<Integer>> result = new HashSet<>();
            int n = nums.length;

            for (int i = 0; i < n - 3; i++) {
                for (int j = i + 1; j < n - 2; j++) {
                    int left = j + 1;
                    int right = n - 1;
                    while (left < right) {
                        long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                        if (sum == target) {
                            final List<Integer> solution = new ArrayList<>();
                            solution.add(nums[left]);
                            solution.add(nums[i]);
                            solution.add(nums[j]);
                            solution.add(nums[right]);
                            result.add(solution);
                            right--;
                        } else if (sum > target) {
                            right--;
                        } else {
                            left++;
                        }
                    }
                }
            }

            return new ArrayList<>(result);
        }
    }
}
