package 长度最小的子数组_209;

public class MinSubArrayLen {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,nums));

    }

    public static int minSubArrayLen(int s, int[] nums){
        if (nums.length==0){
            return 0;
        }
        int start = 0;
        int end = 0;
        int sum = 0;
        int count = Integer.MAX_VALUE;
        while(end<nums.length){
            sum = sum+=nums[end];
            while(sum>=s){
                count = Math.min(count,end-start+1);
                sum = sum-nums[start];
                start++;
            }
            end++;
        }
        return count==Integer.MAX_VALUE?0:count;
    }
}
