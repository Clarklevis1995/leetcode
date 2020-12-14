package 练习.暴力递归与动态规划.暴力递归.汉诺塔问题;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-14 15:21
 **/
public class HanoiTower {

    /**
     * 打印出汉诺塔的详细步骤
     * @param N 问题的规模（一共N个圆片）
     * @param from 最开始所有圆片都在的柱子
     * @param to 最后所有圆片要前往的柱子
     * @param help 用于辅助操作的柱子
     */
    public static void process(int N, String from, String to, String help){
        if (N == 1){
            System.out.println("move 1 from "+from+" to"+to);
            return;
        }
        process(N-1, from, help, to);
        System.out.println("move "+N+" from "+from+" to"+to);
        process(N-1, help, to, from);

    }

    public static void main(String[] args) {
        process(3, "柱子1", "柱子3", "柱子2");
    }

}
