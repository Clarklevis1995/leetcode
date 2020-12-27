package 最长连续不重复子串;

import java.util.*;


public class Solution {
    /**
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public static int maxLength (int[] arr) {
        if (arr.length == 0){
            return 0;
        }
        // write code here
        int p1 = 0;
        int p2 = 0;
        int size = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(p1<=p2 && p2<arr.length){
            if(map.containsKey(arr[p2])){
                p1 = Math.max(p1, map.get(arr[p2]));

            }
            map.put(arr[p2], p2);
            size = Math.max(size, (p2-p1));
            p2++;
        }
        return size;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,4,5,6,3,7,8,9,1,2,2,1,11,12,13,14,15,16,17,18,19,20};
        System.out.println(maxLength(nums));
    }
}