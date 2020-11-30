package 练习.排序算法;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-11-28 09:19
 **/
public class HeapSort {
    public static void main(String[] args) {
        int[] nums = {3, 5, 6, 1, 2, 7, 9, 8, 0, 4};
        sort(nums);
        System.out.println(Arrays.toString(nums));

    }

    /*
    1. 让数组整体形成大根堆
    2. 最后一个位置和堆顶位置交换， size-1
    3. 重新调整为大根堆
    4. 重复2-3步骤
    5. 直到 size == 0
     */


    public static void sort(int[] nums){
        if (nums.length<2){
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            insert(nums, i);
        }
        int size = nums.length;
        while(size>0){
            swap(nums, 0, size-1);
            heapify(nums, 0, --size);
        }
    }
    /**
     * 每当顶部元素发生了改变，就进行一次堆化，将最大的值推到堆顶
     * @param nums
     * @param index
     * @param size
     */
    public static void heapify(int[] nums, int index, int size){
        int left = index * 2+1;
        while(left <size){
            int largest = (left+1)<size&&nums[left]<nums[left+1]?left+1:left;
            largest = nums[largest]<nums[index]?index:largest;
            if (largest == index){
                return;
            }
            swap(nums, index, largest);
            index = largest;
            left = index*2+1;
        }
    }
    /**
     * 每插入一个新的元素，都调整成大根堆
     * @param nums
     * @param index
     */
    public static void insert(int[] nums, int index){
        while(nums[index]>nums[(index-1)/2]){
            swap(nums, index, (index-1)/2);
            index = (index-1)/2;
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
