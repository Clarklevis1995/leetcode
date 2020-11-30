package 只出现一次的数字;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-11-27 18:29
 **/
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,4,4,5,5};
        System.out.println(singleNumber(nums));
    }
    public static int singleNumber(int[] nums){
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
