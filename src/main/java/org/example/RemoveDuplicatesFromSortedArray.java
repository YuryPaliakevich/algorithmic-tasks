package org.example;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int i = new Solution().removeDuplicates(nums);
        ;
        System.out.println(i);
    }

    private static class Solution {
        public int removeDuplicates(int[] nums) {
            int n = nums.length;
            int currentDigit = nums[0];
            int k = 1;

            for (int i = 1; i < n; i++) {
                if (currentDigit == nums[i]) {
                    continue;
                }

                nums[k] = nums[i];
                currentDigit = nums[i];
                k++;
            }

            return k;
        }
    }

}
