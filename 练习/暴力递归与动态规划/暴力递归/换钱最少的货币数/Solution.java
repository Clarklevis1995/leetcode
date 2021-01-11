package 练习.暴力递归与动态规划.暴力递归.换钱最少的货币数;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-01 20:46
 **/
public class Solution {

    public static void main(String[] args) {
        int[] arr = {5,2,3};
        System.out.println(lessChange2(arr, 0));
    }

    public static int lessChange(int[] arr, int aim){
        if (arr.length<1 || aim < 0 || arr ==null){
            return -1;
        }
        return process(arr, 0, aim);
    }

    /**
     *
     * @param arr
     * @param i 当前是第几个纸币
     * @param rest 在使用当前纸币之前，还剩多少钱需要凑
     * @return 可以凑得目标的最少纸币数量
     */
    public static int process(int[] arr, int i, int rest){
        if(i== arr.length){
            return rest == 0? 0:-1;
        }

        int result = -1;
        for(int j = 0; j*arr[i]<=rest; j++){
            int next = process(arr, i+1, rest-arr[i]*j);
            if (next != -1){
                result = result == -1?next+j:Math.min(result, next+j);
            }
        }
        return result;
    }

    public static int lessChange2(int[] arr, int aim){
        if (arr.length<1 || aim < 0 || arr ==null){
            return -1;
        }
        int N = arr.length;
        int[][] dp = new int[N+1][aim+1];
        //base case：
        //这个位置表示已经用到最后一张纸币，rest为0，即正好满足的情况
        for (int i = 1; i <= aim ; i++) {
            dp[N][i] = -1;
        }

        for (int i = N-1; i >= 0 ; i--) {
            for (int rest = 1; rest <= aim; rest++) {
                dp[i][rest] = -1;
                if (dp[i+1][rest] != -1){
                    dp[i][rest] = dp[i+1][rest];
                }
                if (rest - arr[i] >= 0 && dp[i][rest-arr[i]] != -1){
                    if (dp[i][rest] == -1){
                        dp[i][rest] = dp[i][rest-arr[i]]+1;
                    }else {
                        dp[i][rest] = Math.min(dp[i][rest], dp[i][rest - arr[i]]+1);
                    }
                }


            }

        }
        return dp[0][aim];

    }
}
