package 数组中第k个最大元素_215;

import java.util.PriorityQueue;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-04 16:32
 **/
public class Solution {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums, 4));
    }

    /**
     * 堆排序的方法 O(nlogn)
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        int result = 0;

        while (!queue.isEmpty() && k != 0) {
            result = queue.poll();
        }
        return result;
    }
}
