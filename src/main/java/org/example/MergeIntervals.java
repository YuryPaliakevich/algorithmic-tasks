package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] arr = new int[][] { { 2, 6 }, { 8, 10 }, { 1, 3 }, { 15, 18 } };
        int[][] merge = new Solution().merge(arr);

        for (int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }
    }

    static class Solution {
        public int[][] merge(int[][] intervals) {
            List<int[]> result = new ArrayList<>();
            Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
            result.add(intervals[0]);
            int currentIndex = 0;

            for (int i = 1; i < intervals.length; i++) {
                int[] interval = intervals[i];
                if (interval[0] <= result.get(currentIndex)[1]) {
                    result.get(currentIndex)[1] = Math.max(result.get(currentIndex)[1], intervals[i][1]);
                } else {
                    currentIndex++;
                    result.add(interval);
                }
            }

            return result.toArray(new int[][]{});
        }
    }

}














