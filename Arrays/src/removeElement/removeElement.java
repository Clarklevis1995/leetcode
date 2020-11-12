package removeElement;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-11-12 17:58
 **/
public class removeElement {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        System.out.println(remove(nums,2));
    }

    public static int remove(int[] nums, int val){
        int pointer = 0;
        int countVal = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=val){
                int temp = nums[i];
                nums[i] = nums[pointer];
                nums[pointer++] = temp;
            }else {
                countVal++;
            }
        }
        return nums.length-countVal;
    }
}
