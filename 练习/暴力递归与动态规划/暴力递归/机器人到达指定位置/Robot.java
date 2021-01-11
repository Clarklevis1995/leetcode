package 练习.暴力递归与动态规划.暴力递归.机器人到达指定位置;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-31 11:29
 **/
public class Robot {
    public static void main(String[] args) {
        System.out.println(ways2(7,4,9,5));
    }

    public static int ways1(int N, int M, int K, int P){
        if (N<2 || M<1 || M>N || K<1 || P<1 || P>N){
            return 0;
        }
        return walk(N, M, K, P);
    }

    /**
     *暴力递归
     * @param N 位置的数量
     * @param cur 当前位置
     * @param rest 剩下的步数
     * @param dest 终点的位置
     * @return 能够到达终点的路径数量
     */
    public static int walk(int N, int cur, int rest, int dest){
        //如果没有接下来的步数了，如果到达了目的地，返回1，没有到达目的地，返回0
        if(rest == 0){
            return cur == dest? 1: 0;
        }
        //如果还有接下来的步数，如果当前位置在1，只能向后走
        if (cur == 1){
            return walk(N, cur+1, rest-1, dest);
        }
        //如果还有接下来的步数，如果当前位置在N，只能向前走
        if (cur == N){
            return walk(N, cur-1, rest-1, dest);
        }
        //如果当前位置在中间，既可以向后走也可以向前走，两者加起来
        return walk(N, cur-1, rest-1,dest)+walk(N, cur+1, rest-1, dest);
    }

    /**
     * 动态规划后
     * @param N
     * @param M
     * @param K
     * @param P
     * @return
     */
    public static int ways2(int N, int M, int K, int P){
        if(N<2 || M<1 || M>N || K<1 || P<1 || P>N){
            return 0;
        }

        int[][] dp = new int[K+1][N+1]; //行数代表还剩几步（0~K），列代表几个位置（1~M）（0列不要了）
        dp[0][M] = 1;//base case: 还剩0步的时候，M位置上的值为1
        //要求的位置是dp[K][P]位置上的数
        for (int i = 1; i < K+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if(j == 1){
                    dp[i][j] = dp[i-1][j+1];
                }else if(j == N){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = dp[i-1][j-1]+dp[i-1][j+1];
                }
            }
        }
        return dp[K][P];

    }


}
