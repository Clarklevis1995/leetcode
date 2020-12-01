package 练习.排序算法;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-11-25 08:50
 **/
public class InsertSort {
    public static void main(String[] args) {

        int[] nums = {3,5,6,1,2,7,9,8,0,4};
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void insertSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j > 0 ; j--) {
                if (nums[j]<nums[j-1]){
                    swap(nums, j, j-1);
                }
            }
        }
    }
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
