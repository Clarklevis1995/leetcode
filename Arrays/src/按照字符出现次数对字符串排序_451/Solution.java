package 按照字符出现次数对字符串排序_451;

import java.util.*;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-04 20:02
 **/
public class Solution {
    public static void main(String[] args) {
        String s = "Aabb";
        System.out.println(frequencySort2(s));
    }


    public static String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        List<Character>[] buckets = new ArrayList[s.length()+1];

        for(Map.Entry<Character, Integer> en : map.entrySet()){
            char letter = en.getKey();
            int times = en.getValue();
            if(buckets[times] == null){
                buckets[times] = new ArrayList<>();
            }
            buckets[times].add(letter);
        }

        StringBuilder result = new StringBuilder();
        for(int i = buckets.length-1; i>=0; i--){
            if(buckets[i]!=null){
                for(char c: buckets[i]){
                    for(int j = 0; j<i; j++){
                        result.append(c);
                    }
                }
            }
        }
        return result.toString();
    }

    public static String frequencySort2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>();
        for(Map.Entry<Character, Integer> en : map.entrySet()){
            list.add(en);
        }
        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> en : list){
            for(int i = 0; i<en.getValue(); i++){
                result.append(en.getKey());
            }
        }
        return result.toString();
    }
}
