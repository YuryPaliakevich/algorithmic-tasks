package org.example;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int i = new Solution().maxArea(new int[] { 1,3,2,5,25,24,5 });
        System.out.println(i);
    }

    private static class Solution {
        public int maxArea(int[] height) {
            int n = height.length;
            int left = 0;
            int right = n - 1;
            int result = 0;

            while (left < right) {
                int localResult = Math.min(height[left], height[right]) * (right - left);
                if (localResult > result) {
                    result = localResult;
                }

                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }

            }
            return result;
        }
    }

}
