package 不重叠的区间个数_435;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-05 11:00
 **/
public class Solution {
    public static void main(String[] args) {
        //[1,2], [2,3], [3,4], [1,3]
        //[[1,100],[11,22],[1,11],[2,12]]
        int[][] interval = {{1,100},{11,22},{1,11},{2,12}};
        System.out.println(eraseOverlapIntervals(interval));
    }
    public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        if (intervals.length == 1){
            return 1;
        }

        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                return arr1[1] - arr2[1];
            }
        });

        int count = 1;
        int index = 0;//指向（左边界）>=前者（有边界的区间）的
        for(int i = 1; i<intervals.length; i++){
            if(intervals[i][0]>=intervals[index][1]){
                count++;
                index = i;
            }
        }
        return intervals.length - count;
    }
}
