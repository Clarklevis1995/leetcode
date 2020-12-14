package 练习.贪心算法.IPO问题;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-14 11:32
 **/
public class MaxProfitObject {
    /**
     * 项目节点类，包含了项目的花费和利润
     */
    public static class Node{
        int cost;
        int profit;

        public Node(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }
    }

    public static class MinCostComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.cost-o2.cost;//小的放前面
        }
    }

    public static class MaxProfitComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o2.profit-o1.profit;//大的放前面
        }
    }

    public static int findMaxCapital(int k, int W, int[] profit, int[] cost){
        Node[] projects = new Node[profit.length];
        for (int i = 0; i < profit.length; i++) {
            projects[i] = new Node(cost[i],profit[i]);
        }
        //构建小顶堆
        PriorityQueue<Node> minCostHeap = new PriorityQueue<>(new MinCostComparator());
        //构建大顶堆
        PriorityQueue<Node> maxProfitHeap = new PriorityQueue<>(new MaxProfitComparator());
        //将所有项目添加到小顶堆中
        minCostHeap.addAll(Arrays.asList(projects));
        //保证总项目数不超过k
        for (int i = 0; i < k; i++) {
            //一旦小顶堆不空，且小根堆顶的cost不大于W，就将这个项目添加到大根堆
            while(!minCostHeap.isEmpty()&&minCostHeap.peek().cost<=W){
                maxProfitHeap.add(minCostHeap.poll());
            }
            //如果此时大根堆空掉了，返回当前的W
            if (maxProfitHeap.isEmpty()){
                return W;
            }
            //如果没有空，就取出大根堆的顶（利润最高的项目），收益加给W
            W += maxProfitHeap.poll().profit;
        }
        return W;
    }

    public static void main(String[] args) {
        int[] cost = {1,2,3};
        int[] profit = {0,1,1};
        System.out.println(findMaxCapital(2,0,cost, profit));
    }




}
