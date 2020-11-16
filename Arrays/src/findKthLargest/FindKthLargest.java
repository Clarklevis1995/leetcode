package findKthLargest;

import java.util.Random;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-11-14 17:31
 **/
public class FindKthLargest {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        var findKth = new FindKthLargest();
        System.out.println(findKth.findKthLargest(nums, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums,0,nums.length-1, nums.length-k);
    }

    /**
     * 快速选择算法
     *
     * @param nums
     * @param l
     * @param r
     * @param index 目标元素位于的位置
     * @return
     */
    public int quickSelect(int[] nums, int l, int r, int index) {
        int q = randomPartition(nums, l, r);
        if (q == index) {
            return nums[q];
        } else {
            return q < index ? quickSelect(nums, q + 1, r, index) : quickSelect(nums, l, q - 1, index);
        }
    }


    /**
     * 为快速排序中pivot的选择添加随机性，随机选择数组中的一个数，和左右边的数互换
     *
     * @param nums
     * @param l
     * @param r
     * @return
     */
    public int randomPartition(int[] nums, int l, int r) {
        Random random = new Random();
        int i = random.nextInt(r - l + 1) + l;//range l-r
        swap(nums, i, r);
        return partition(nums, l, r);

    }

    /**
     * @param nums
     * @param left
     * @param right
     * @return 返回一个以数组最右侧元素pivot为分界的数组，左侧元素都小于pivot， 右侧元素都大于pivot
     */
    public int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int l = left;
        int r = right - 1;
        while (l <= r) {
            while (l <= r && nums[l] <= pivot) {
                l++;
            }
            while (l <= r && nums[r] > pivot) {
                r--;
            }
            if (l < r) {
                swap(nums, l, r);
            }
        }
        swap(nums, l, right);
        return l;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
