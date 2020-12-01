package 练习.排序算法.桶排序补充问题;

import 练习.排序算法.RandomArrayGenerator;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-11-30 22:05
 **/
public class MaxGap {
    public static void main(String[] args) {
        int[] nums = RandomArrayGenerator.generate(100,100);
        System.out.println(truthValue(nums));
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums){
        //n个数，创建n+1个桶
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //取出了数组的最大最小值
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (min == max){
            return 0;
        }
        //创建3个辅助数组
        boolean[] hasNum = new boolean[nums.length+1];
        int[] maxValue = new int[nums.length+1];
        int[] minValue = new int[nums.length+1];
        //重新遍历数组，将数值填入辅助数组的桶中
        int bucket = 0;
        for (int i = 0; i < nums.length ; i++) {
            //用算法求出当前数应该在哪个桶中
            bucket = bucket(nums[i], nums.length, min, max);
            //如果桶中还没有值，就将最小值置为nums[i],如果有了，就取两者之间的最小值
            minValue[bucket] = hasNum[bucket]?Math.min(minValue[bucket],nums[i]):nums[i];
            maxValue[bucket] = hasNum[bucket]?Math.max(maxValue[bucket],nums[i]):nums[i];
            //此时肯定已经有值了，将boolean置为true
            hasNum[bucket] = true;
        }

        //桶装好后，开始找最大值,遍历所有的桶。最大值发生在相邻两个数组之间，后一个数组的min-前一个数组的max
        int res = 0;
        int lastMax = maxValue[0];
        for (int i = 1; i < nums.length+1; i++) {
            if (hasNum[i]){
                res = Math.max(res, minValue[i]-lastMax);
                lastMax = maxValue[i];
            }
        }
        return res;
    }

    /**
     *
     * @param num 当前数
     * @param len 一共有几个数
     * @param min 数组中最小值
     * @param max 数组中最大值
     * @return 当前数应该在第几个桶
     */
    public static int bucket(long num, long len, long min, long max){
        return (int)((num-min)*len/(max-min));
    }

    public static int truthValue(int[] nums){
        Arrays.sort(nums);
        int gap = 0;
        for (int i = 1; i < nums.length; i++) {
            gap = Math.max(gap, nums[i]-nums[i-1]);
        }
        return gap;
    }

}
