import java.util.Arrays;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-11-12 16:58
 **/
public class moveZeros {
    public static void move(int[] nums){
        int length = nums.length;
        int pointer = 0;
        int zeroCount = 0;
        for (int i = 0; i <= length-1; i++) {
            if (nums[i] != 0){
                nums[pointer] = nums[i];
                pointer++;
            }
            else {
                zeroCount++;
            }
        }
        for (int i = 0; i < zeroCount; i++) {
            nums[length-1-i] = 0;
        }
    }

    public static void move2(int[] nums){
        int pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0){
                int temp = nums[i];
                nums[i] = nums[pointer];
                nums[pointer] = temp;
                pointer++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1};
        move(nums);
        System.out.println(Arrays.toString(nums));
    }
}
