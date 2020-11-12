package twoSum;

import java.util.Arrays;
import java.util.Hashtable;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-11-12 22:10
 **/
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(nums,9)));


    }

    public static int[] twoSum(int[] nums, int target){
        Hashtable<Integer, Integer> table = new Hashtable<>();
        for (int i = 0; i < nums.length; i++) {
            if (table.containsKey(target - nums[i])){
                return new int[]{table.get(target-nums[i]),i};
            }else {
                table.put(nums[i],i);
            }
        }
        return null;

    }
}
