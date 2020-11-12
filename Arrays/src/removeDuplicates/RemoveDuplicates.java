package removeDuplicates;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-11-12 20:18
 **/
public class RemoveDuplicates {
    public static void main(String[] args) {

        int[] nums = {0,0,0,0,1,1,1,1,1,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

    }

    public static int removeDuplicates(int[] nums){
        if (nums.length == 0){
            return 0;
        }
        int pointer = 0;
        int standard = nums[0];
        int times = 1;
        int countRemove = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]==standard&&times==1){
                times++;
                pointer++;
                if (nums[pointer]!=standard){
                    nums[pointer] = standard;
                }
            }else if(nums[i]==standard&&times>1){
                countRemove++;
                times++;
            }else if (nums[i]!=standard){
                int temp = nums[i];
                nums[++pointer] = temp;
                times = 1;
                standard = temp;
            }
        }
        return nums.length - countRemove;
    }
}
