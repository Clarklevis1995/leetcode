package 练习.排序算法;

import java.util.Arrays;

import static 练习.排序算法.SortTest.QuickSortTest.quickSort;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-22 14:09
 **/
public class SortTest {
    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 1, 2, 7, 9, 8, 0, 4};
        HeapSortTest.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }



    public static class QuickSortTest{
        public static void quickSort(int[] nums, int leftBound, int rightBound){
            if (leftBound>=rightBound){
                return;
            }
            int pivot = partition(nums, leftBound, rightBound);
            quickSort(nums, leftBound, pivot-1);
            quickSort(nums, pivot+1, rightBound);
        }

        public static int partition(int[] nums, int leftBound, int rightBound){
            int left = leftBound;
            int right = rightBound - 1;
            int pivot = rightBound;

            while(left<=right){
                while(left<=right && nums[left]<=nums[pivot]) left++;
                while(left<=right && nums[right]>nums[pivot]) right--;
                if (left<right){
                    swap(nums, left, right);
                }
            }
            swap(nums, left, pivot);
            return left;
        }

        public static void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static class HeapSortTest{
        public static void heapSort(int[] nums){
            if (nums.length<2){
                return;
            }
            int size = nums.length;
            for (int i = 0; i < size; i++) {
                insert(nums, i);
            }
            while(size>0){
                swap(nums, 0, size-1);
                heapify(nums, 0, --size);
            }

        }

        public static void insert(int[] nums, int index){
            while(nums[index]>nums[(index-1)/2]){
                swap(nums, index, (index-1)/2);
                index = (index-1)/2;
            }
        }

        public static void heapify(int[] nums, int index, int size){
            int left = index*2+1;
            while(left<size){
                int largest = (left+1)<size && nums[left+1]>nums[left]?left+1:left;
                largest = nums[largest]>nums[index]?largest:index;
                if (largest == index){
                    return;
                }
                swap(nums, index, largest);
                index = largest;
                left = index*2+1;
            }
        }

        public static void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}


