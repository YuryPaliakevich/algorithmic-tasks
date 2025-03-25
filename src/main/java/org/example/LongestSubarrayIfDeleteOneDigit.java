package org.example;

public class LongestSubarrayIfDeleteOneDigit {


    public static void main(String[] args) {
        int[] numbers = new int[]{0,1,1,0,1,1,0};
//        int answer = 6;
        int result = new Solution().find(numbers);
        System.out.println(result);
    }

    static class Solution {


        public int find(int[] nums) {
            int maxLength = 0;
            int left = 0;
            int zeroCount = 0;

            for (int right = 0; right < nums.length; right++) {
                if (nums[right] == 0) {
                    zeroCount++;
                }

                while (zeroCount > 1) {
                    if (nums[left] == 0) {
                        zeroCount--;
                    }
                    left++;
                }

                maxLength = Math.max(maxLength, right - left);
            }

            return maxLength;
        }
    }


}
