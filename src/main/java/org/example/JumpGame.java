package org.example;

public class JumpGame {

    public static void main(String[] args) {
        final int[] nums = new int[] {3,2,1,0,4};
        boolean i = new Solution().canJump(nums);
        System.out.println(i);
    }

    static class Solution {
        public boolean canJump(int[] nums) {
            int maxReachable = 0;
            if (nums.length == 1) {
                return true;
            }

            for (int i = 0; i < nums.length; i++) {
                if (i > maxReachable) {
                    return false;
                }

                maxReachable = Math.max(maxReachable, nums[i] + i);

                if (maxReachable > nums.length - 1) {
                    return true;
                }
            }

            return false;
        }
    }

}
