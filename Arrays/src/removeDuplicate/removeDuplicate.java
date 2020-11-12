package removeDuplicate;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-11-12 18:07
 **/
public class removeDuplicate {

    public static void main(String[] args){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDup(nums));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDup(int[] nums){
        if (nums.length == 0){
            return 0;
        }
        int pointer = 1;
        int duCount = 0;
        int standard = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]!=standard){
                int temp = nums[i];
                nums[i] = nums[pointer];
                nums[pointer++] = temp;
                standard = temp;
            }else {
                duCount++;
            }
        }
        return nums.length-duCount;
    }
}
