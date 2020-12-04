package 练习.排序算法;

import java.util.Arrays;

public class CountSort {

    public static void main(String[] args) {
        int[] nums = {1,3,2,5,7,4,9,0};
        System.out.println(Arrays.toString(countSort(nums)));
    }
    public static int[] countSort( int[] nums) {
        int[] buckets = new int[findMax(nums)+1];
        for(int i = 0; i<nums.length;i++){
            buckets[nums[i]]++;
        }
        int p = 0;//指向nums数组
        for(int i = 0; i<buckets.length; i++){
            while(buckets[i]!=0){
                nums[p++] = i;
                buckets[i]--;
            }
        }
        return nums;
    }

    public static int findMax(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]>max){
                max = nums[i];
            }
        }
        return max;
    }
}
