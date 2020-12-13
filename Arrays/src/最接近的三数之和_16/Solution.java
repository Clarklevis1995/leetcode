package 最接近的三数之和_16;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-12 11:17
 **/
public class Solution {
    //暴力解法
    public static int threeSumClosest(int[] nums, int target) {
        int sub = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                for(int k = j+1; k<nums.length; k++){
                    int newSub = Math.abs(nums[i]+nums[j]+nums[k]-target);
                    if (newSub<sub){
                        sub = newSub;
                        sum = nums[i]+nums[j]+nums[k];
                    }
                }
            }
        }
        return sum;
    }

    //双指针法
    public static int threeSumClosest2(int[] nums, int target) {
        //不要用极大值，会越界
        /*int best = 10000000;
        Arrays.sort(nums);
        for(int i = 0; i<nums.length; i++){
            int pb = i+1;
            int pc = nums.length-1;
            while(pb<pc){
                int sum = nums[i] + nums[pb] + nums[pc];
                if(sum == target){
                    return target;
                }
                if(Math.abs(best-target)>Math.abs(sum-target)){
                    best = sum;
                }
                if(sum < target){
                    pb++;
                }else{
                    pc--;
                }
            }
        }
        return best;*/
        int best = 10000000;
        Arrays.sort(nums);
        for(int i = 0; i<nums.length; i++){
            int pb = i+1;
            int pc = nums.length-1;
            while(pb<pc){
                int sum = nums[i] + nums[pb] + nums[pc];
                if(sum == target){
                    return target;
                }
                if(Math.abs(best-target)>Math.abs(sum-target)){
                    best = sum;
                }
                if(sum < target){
                    pb++;
                    //如果当前位置和上一个位置相同，则继续前往下一个位置，直到当前位置的数和之前不同，
                    //所以需要判断的是当前位置和之前位置的数是否相同，
                    //如果判断条件是：nums[pb+1] == nums[pb]；则当前位置的数会被跳过，可能会导致指针pb和pc不能指向数值想同的不同位置
                    //比如下面的例子：{-1，0，1，1，55}；无法使得pb指向第一个1，pc指向第二个1
                    while(pb<pc && nums[pb] == nums[pb-1]){
                        pb++;
                    }
                }

                if(sum > target){
                    pc--;
                    while(pb<pc && nums[pc+1] == nums[pc]){
                        pc--;
                    }
                }
            }
        }
        return best;

    }


    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,1,55};
        System.out.println(threeSumClosest2(nums, 3));
    }
}
