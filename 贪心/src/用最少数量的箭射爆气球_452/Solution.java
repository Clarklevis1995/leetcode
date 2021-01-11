package 用最少数量的箭射爆气球_452;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-05 12:50
 **/
public class Solution {

    public static void main(String[] args) {
        //[[-2147483646,-2147483645],[2147483646,2147483647]
        System.out.println(findMinArrowShots(new int[][]{{1,2},{3,4}}));
    }
    public static int findMinArrowShots(int[][] points) {
        //计算不重叠区间的个数
        if(points == null){
            return 0;
        }
        if(points.length <= 1){
            return points.length;
        }
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                if(arr1[1]<arr2[1]){
                    return -1;
                }else if(arr1[1]>arr2[1]){
                    return 1;
                }else {
                    return 0;
                }
            }
        });


        int count = 1;
        int index = 0;
        for(int i = 1; i<points.length; i++){
            if(points[i][0]>points[index][1]){
                count++;
                index = i;
            }
        }
        return count;
    }
}
