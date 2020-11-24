package 主要元素;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-11-24 08:58
 **/
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums){
        if (nums.length == 0){
            return -1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n:nums
             ) {
            if (map.containsKey(n)){
                int times = map.get(n);
                times++;
                map.put(n,times);
            }else {
                map.put(n,1);
            }
            if (map.get(n)>nums.length/2){
                return n;
            }
        }
        return -1;
    }

    //投票算法
    public static int majorityElement2(int[] nums){
        if (nums.length == 0){
            return -1;
        }

        int majority = 0;
        int count = 0;

        for (int num:nums
             ) {
            if (count == 0){
                majority = num;
                count++;
            }else {
                if (num == majority){
                    count++;
                }else {
                    count--;
                }
            }
        }

        if (count == 0){
            return -1;
        }
        int identify = 0;
        for (int n:nums
             ) {
            if (n == majority){
                identify++;
            }
            if (identify>nums.length/2){
                return majority;
            }
        }
        return -1;
    }
}
