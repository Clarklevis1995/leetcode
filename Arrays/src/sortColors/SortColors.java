package sortColors;

import java.util.Arrays;
import java.util.Objects;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {1,2,0};
        sort2(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void sort(int[] nums){
        int zero = 0;
        int one = 0;
        int two = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0){
                zero++;
            }else if(nums[i]==1){
                one++;
            }else {
                two++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i<zero){
                nums[i] = 0;
            }else if (i<zero+one){
                nums[i] = 1;
            }else {
                nums[i] = 2;
            }
        }
    }

    public static void sort2(int[] nums){
        int p0 = 0;
        int p2 = nums.length-1;
        for (int i = 0; i <= nums.length-1; i++) {
            while (nums[i]==2&&i<=p2){
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                p2--;
            }
            if (nums[i]==0){
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                p0++;
            }
        }
    }
}
