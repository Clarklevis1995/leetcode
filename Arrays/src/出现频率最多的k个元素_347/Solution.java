package 出现频率最多的k个元素_347;

import java.util.*;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-04 17:26
 **/
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,2,3,3,3};
        int[] result = topKFrequent2(nums, 3);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 利用堆排序的做法
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            if(!map.containsKey(num)){
                map.put(num,1);
            }else{
                map.put(num, map.get(num)+1);
            }
        }

        //int[]{num, times}
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        int[] res = new int[k];
        int index = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int num = entry.getKey();
            int times = entry.getValue();
            queue.add(new int[]{num, times});
        }
        while(!queue.isEmpty() && k>0 && index<res.length){
            res[index++] = queue.poll()[0];
            k--;
        }
        return res;
    }

    public static int[] topKFrequent2(int[] nums, int k){
        //用来存储每个不同的数字和它出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        //准备一个桶数组List[]，下标表示频率，每个桶中的链表存储当前频率下的数值
        ArrayList<Integer>[] buckets = new ArrayList[nums.length+1];
        for (Map.Entry<Integer, Integer> en:map.entrySet()
             ) {
            int num = en.getKey();
            int times = en.getValue();
            if(buckets[times] == null){
                //如果当前频率下的元素不存在，就初始化这个列表
                buckets[times] = new ArrayList<>();
            }
            buckets[times].add(num);//在当前频率的桶中加入符合该频率的数值
        }

        //结果数组
        int[] res = new int[k];
        int index = 0;
        a:for(int i = buckets.length-1; i>=0; i--){//遍历整个桶数组
            if(buckets[i] == null){//如果当前桶为空，说明当前频率下没有元素在其中
                continue;
            }
            b:for (int num:buckets[i]//如果当前桶非空，就将桶中的元素一个一个加入到结果数组中
                 ) {
                res[index++] = num;//随着元素的加入，结果数组的指针在不断增加
                if (index == res.length){//如果结果数组的指针越界了，说明结果数组已满，直接终止外层循环
                    break a;
                }
            }
        }
        return res;
    }
}
