package 较大分组的位置_830;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-05 09:07
 **/
public class Solution {
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(largeGroupPositions(s));
    }
    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> list = new ArrayList<>();
        if(s == null || s ==""){
            return list;
        }
        String s1 = s+" ";
        int count = 0;
        char old = '\0';
        List<Integer> interval = null;
        for(int i = 0; i<s1.length(); i++){
            if(s1.charAt(i)!=old){
                if(count >= 3){
                    interval = new ArrayList<>();
                    interval.add(i-count);
                    interval.add(i-1);
                    list.add(interval);
                }
                count = 1;
                old = s1.charAt(i);
            }else{
                count++;
            }
        }
        
        return list;
    }
}
