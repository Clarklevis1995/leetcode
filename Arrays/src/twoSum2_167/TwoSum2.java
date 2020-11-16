package twoSum2_167;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-11-15 22:14
 **/
public class TwoSum2 {
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(numbers, 9)));

    }

    public static int[] twoSum(int[] numbers, int target){
        int p1 = 0;
        int p2 = numbers.length-1;
        while (p1<p2){
            if (numbers[p1]+numbers[p2]==target){
                return new int[]{p1+1,p2+1};
            }else if (numbers[p1]+numbers[p2]>target){
                p2--;
            }else {
                p1++;
            }
        }
        return null;
    }
}
