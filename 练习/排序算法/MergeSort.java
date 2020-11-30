package 练习.排序算法;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-11-28 11:57
 **/
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {3, 5, 6, 1, 2, 7, 9, 8, 0, 4};
        sort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));


    }

    public static void sort(int[] nums, int L, int R){
        if (R == L){
            return;
        }

        int mid = (R+L)/2;
        sort(nums, L, mid);
        sort(nums, mid+1, R);
        merge(nums, L, R, mid);



    }

    public static void merge(int[] nums, int L, int R, int mid){
        int[] temp = new int[R-L+1];
        int p = 0;
        int p1 = L;
        int p2 = mid + 1;
        while(p1<=mid&&p2<=R){
            temp[p++] = nums[p1]<nums[p2]?nums[p1++]:nums[p2++];
        }

        //如果p2遍历完了
        while(p1<=mid){
            temp[p++] = nums[p1++];
        }
        //如果p1遍历完了
        while(p2<=R){
            temp[p++] = nums[p2++];
        }

        //将temp拷贝回nums中
        System.arraycopy(temp, 0, nums, L, temp.length);


    }
}
