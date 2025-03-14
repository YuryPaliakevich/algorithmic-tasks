package org.example;

public class MaximumCandiesAllocatedToKChildren {

    public static void main(String[] args) {
        int[] candies = { 2,5 };
        int i = new Solution().maximumCandies(candies, 11);
        System.out.println(i);
    }

    private static class Solution {
        public int maximumCandies(int[] candies, long k) {
            int result = 0;

            int max = 0;

            for (int candy : candies) {
                max = Math.max(max, candy);
            }

            int left = 1, right = max;

            while (left <= right) {
                int candiesPerPerson = left + (right - left) / 2;
                int sum = 0;
                for (int candy : candies) {
                    sum += candy / candiesPerPerson;
                }

                if (sum >= k) {
                    result = candiesPerPerson;
                    left = candiesPerPerson + 1;
                } else {
                    right = candiesPerPerson - 1;
                }
            }

            return result;
        }
    }

}
