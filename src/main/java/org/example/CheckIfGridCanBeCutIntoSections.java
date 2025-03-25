package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CheckIfGridCanBeCutIntoSections {

    public static void main(String[] args) {
        int[][] arr = new int[][] { {1,0,5,2},{0,2,2,4},{3,2,5,3},{0,4,4,5} };
        boolean can = new Solution().checkValidCuts(5, arr);
        System.out.println(can);
    }

    static class Solution {
        public boolean checkValidCuts(int n, int[][] rectangles) {
            int[][] xIntervals = new int[rectangles.length][2];
            int[][] yIntervals = new int[rectangles.length][2];

            for (int i = 0; i < rectangles.length; i++) {
                xIntervals[i][0] = rectangles[i][0];
                xIntervals[i][1] = rectangles[i][2];
                yIntervals[i][0] = rectangles[i][1];
                yIntervals[i][1] = rectangles[i][3];
            }


            Arrays.sort(xIntervals, Comparator.comparing(a -> a[0]));
            Arrays.sort(yIntervals, Comparator.comparing(a -> a[0]));

            if (canBe(xIntervals)) {
                return true;
            }

            return canBe(yIntervals);
        }

        public boolean canBe(int [][] intervals) {
            List<int[]> result = new ArrayList<>();
            result.add(intervals[0]);
            int currentIndex = 0;

            for (int i = 1; i < intervals.length; i++) {
                int[] interval = intervals[i];
                if (interval[0] < result.get(currentIndex)[1]) {
                    result.get(currentIndex)[1] = Math.max(result.get(currentIndex)[1], intervals[i][1]);
                } else {
                    currentIndex++;
                    result.add(interval);
                }
            }

            return result.size() >= 3;
        }
    }

}
