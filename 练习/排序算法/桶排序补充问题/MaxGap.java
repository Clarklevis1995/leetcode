package 练习.排序算法.桶排序补充问题;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-11-30 22:05
 **/
public class MaxGap {
    public static void main(String[] args) {

    }

    public static int solution(int[] nums){

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
}
