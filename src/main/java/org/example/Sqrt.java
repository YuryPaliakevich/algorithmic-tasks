package org.example;

public class Sqrt {

    public static void main(String[] args) {
        int i = new Solution().mySqrt(2147395599);
        System.out.println(i);
    }

    static class Solution {
        public int mySqrt(int x) {
            if (x == 0) {
                return 0;
            }
            if (x == 1) {
                return 1;
            }

            int left = 0, right = x / 2;
            while (left < right) {
                int mid = left + (right - left) / 2;
                long square = (long) mid * mid;
                if (square < x) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            long result = left * (long) left;
            return result > x ? left - 1 : left;
        }
    }

}
