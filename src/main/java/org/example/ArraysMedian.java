package org.example;

public class ArraysMedian {

    public static void main(String[] args) {
        int[] num1 = new int[] {1, 12, 15, 26, 38};
        int[] num2 = new int[] {2, 13, 17, 30, 45, 60};

        double medianSortedArrays = new Solution().findMedianSortedArrays(num1, num2);
        System.out.println(medianSortedArrays);
    }

    private static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                return findMedianSortedArrays(nums2, nums1);
            }

            int num1_len = nums1.length;
            int num2_len = nums2.length;
            int n = num1_len + num2_len;

            int low = 0, high = num1_len;

            while (low <= high) {
                int leftSmaller = (low + high) / 2;
                int rightLarger = (num1_len + num2_len + 1) / 2 - leftSmaller;

                int l1 = leftSmaller == 0 ? Integer.MIN_VALUE : nums1[leftSmaller - 1];
                int r1 = leftSmaller == num1_len ? Integer.MAX_VALUE : nums1[leftSmaller];

                int l2 = rightLarger == 0 ? Integer.MIN_VALUE : nums2[rightLarger - 1];
                int r2 = rightLarger == num2_len ? Integer.MAX_VALUE : nums2[rightLarger];

                if (l1 <= r2 && l2 <= r1) {
                    // If total elements are even, return the average of the middle two
                    if (n % 2 == 0) {
                        return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                    } else {
                        return Math.max(l1, l2);
                    }
                } else if (l1 > r2) {
                    high = leftSmaller - 1;
                } else {
                    low = leftSmaller + 1;
                }

            }

            return 0;
        }
    }

}
