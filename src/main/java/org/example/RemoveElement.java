package org.example;

import java.util.Arrays;

public class RemoveElement {

    public static void main(String[] args) {
        int []nums = new int[] {0,1,2,2,3,0,4,2};
        int i = new Solution().removeElement(nums, 2);
        System.out.println(Arrays.toString(nums));
        System.out.println(i);
    }

    private static class Solution {
        public int removeElement(int[] nums, int val) {
            if (nums.length == 0) {
                return 0;
            }

            int k = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == val) {
                    continue;
                }

                nums[k] = nums[i];
                k++;
            }

            return k;
        }
    }

}
