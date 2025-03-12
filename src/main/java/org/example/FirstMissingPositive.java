package org.example;

public class FirstMissingPositive {

    public static void main(String[] args) {
        final int[] nums = new int[] {3,2,1,3,5};
        int i = new Solution().firstMissingPositive(nums);
        System.out.println(i);
    }

    private static class Solution {
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[temp - 1];
                    nums[temp - 1] = temp;
                }
            }

            for (int i = 0; i < n; i++) {
                if (i + 1 != nums[i]) {
                    return i + 1;
                }
            }

            return n + 1;
        }
    }

}
