package org.example;

public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        int i = new Solution().majorityElement(nums);
        System.out.println(i);
    }

    private static class Solution {
        public int majorityElement(int[] nums) {
            int candidate = 0;
            int count = 0;

            for (int num : nums) {
                if (candidate == num) {
                    count++;
                } else {
                    if (count == 0) {
                        candidate = num;
                    } else {
                        count--;
                    }
                }
            }

            return candidate;
        }
    }

}
