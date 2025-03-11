package org.example;

public class ReverseInteger {

    public static void main(String[] args) {
        int reverse = new Solution().reverse(1563847412);
        System.out.println(reverse);
    }

    private static class Solution {

        public int reverse(int x) {
            int result = 0;

            while (x != 0) {
                int digit = x % 10;
                x /= 10;
                try {
                    result = Math.multiplyExact(result, 10);
                    result = Math.addExact(result, digit);
                } catch (ArithmeticException e) {
                    return 0;
                }
            }

            return result;
        }

    }

}
