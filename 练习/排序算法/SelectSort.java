package 练习.排序算法;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-11-25 08:57
 **/
public class SelectSort {
    public static void main(String[] args) {
        int[] nums = {3,5,6,1,2,7,9,8,0,4};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void selectSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i]>nums[j]){
                    swap(nums, i, j);
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
