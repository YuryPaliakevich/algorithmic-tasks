package org.example;

public class ZeroArrayTransformation {

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 0, 2 };
        int[][] queries = new int[][] { { 0, 2, 1 }, { 0, 2, 1 }, { 1, 1, 3 } };
        System.out.println(new Solution().minZeroArray(nums, queries));
    }

    private static class Solution {
        public int minZeroArray(int[] nums, int[][] queries) {
            int[] arrayDiff = new int[nums.length + 1];
            int prevActualValue = 0;
            int queryIndex = 0;
            for (int i = 0; i < nums.length; i++) {
                while (arrayDiff[i] + prevActualValue < nums[i]) {
                    if (queryIndex == queries.length) {
                        return -1;
                    }

                    int start = queries[queryIndex][0];
                    int end = queries[queryIndex][1];
                    int val = queries[queryIndex][2];
                    queryIndex++;
                    if (i > end) {
                        continue;
                    }

                    int left = Math.max(start, i);
                    arrayDiff[left] = arrayDiff[left] + val;
                    arrayDiff[end + 1] = arrayDiff[end + 1] - val;
                }

                prevActualValue += arrayDiff[i];
            }

            return queryIndex;
        }
    }

}
