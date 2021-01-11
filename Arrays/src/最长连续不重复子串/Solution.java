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
        int size = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(p1<=p2 && p2<arr.length){
            if(map.containsKey(arr[p2])){
                p1 = Math.max(p1, map.get(arr[p2])+1);
            }
            map.put(arr[p2], p2);
            p2++;
            size = Math.max(size, (p2-p1));
        }
        return size;
    }

    public static void main(String[] args) {
        int[] nums = {0,1};
        System.out.println(maxLength(nums));
    }
}