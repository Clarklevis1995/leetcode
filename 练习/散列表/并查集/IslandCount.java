package 练习.散列表.并查集;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-11 17:12
 **/
public class IslandCount {

    public static int countIsland(int[][] m){
        if (m == null || m[0] == null){
            return 0;
        }
        int N = m.length;
        int M = m[0].length;
        int res = 0;
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < M; j++) {
                if (m[i][j] == 1){
                    res++;
                    infect(m,i,j,N,M);
                }
            }
        }
        return res;
    }

    /**
     *
     * @param m 包含岛的矩阵
     * @param i 当前点所在的位置x
     * @param j 当前点所在的位置y
     * @param N 行数
     * @param M 列数
     */
    public static void infect(int[][] m, int i, int j, int N, int M){
        //如果坐标越界，或者当前位置的值不为1，不做任何操作
        if(i<0 || i>=N || j<0 || j>=M || m[i][j] != 1){
            return;
        }
        m[i][j] = 2;
        infect(m, i+1, j, N, M);
        infect(m, i-1, j, N, M);
        infect(m, i, j+1, N, M);
        infect(m, i, j-1, N, M);
    }

    public static void main(String[] args) {
        int[][] island = new int[][]{
                {0,0,1,0,1,0},
                {1,1,1,0,1,0},
                {1,0,0,1,0,0},
                {0,0,0,0,0,0}
        };
        System.out.println(countIsland(island));
    }
}
