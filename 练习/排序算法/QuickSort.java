package 练习.排序算法;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-11-25 08:18
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {3,5,6,1,2,7,9,8,0,4};
        quickSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums, int leftBound, int rightBound){
        if (leftBound>=rightBound){
            return;
        }
        int partition = partition(nums, leftBound, rightBound);
        quickSort(nums, leftBound, partition-1);
        quickSort(nums, partition+1, rightBound);

    }

    public static int partition(int[] nums, int leftBound, int rightBound){
        int pivot = rightBound;
        int p1 = leftBound;
        int p2 = rightBound-1;
        while (p1<=p2){
            while(p1<=p2&&nums[p1]<=nums[pivot]) p1++;
            while(p1<=p2&&nums[p2]>nums[pivot]) p2--;
            if (p1<p2){
                swap(nums, p1, p2);
            }
        }
        swap(nums, p1, pivot);
        return p1;
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
