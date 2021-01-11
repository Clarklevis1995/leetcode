package 无重复字符的最长连续子串_3;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-31 09:28
 **/
public class Solution {
    public static void main(String[] args) {
        String s = "au";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {

        if(s.length() == 0){
            return 0;
        }
        int maxSize = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        while(l<=r && r<s.length()){
            if(map.containsKey(s.charAt(r))){
                l = Math.max(l, map.get(s.charAt(r))+1);
            }
            map.put(s.charAt(r), r++);
            maxSize = Math.max(maxSize, (r-l));
        }
        return maxSize;
    }

    public static int lengthOfLongestSubstring2(String s){
        int maxSize = 0;
        HashSet<Character> set = new HashSet<>();
        int l = 0;
        int r = 0;
        while(l<=r && r<s.length()){
            while(r<s.length() && (!set.contains(s.charAt(r)))){
                set.add(s.charAt(r++));
            }
            maxSize = Math.max(maxSize, r-l);
            if(r == s.length()-1){
                return maxSize;
            }
            set.remove(s.charAt(l));
            l++;
        }
        return maxSize;
    }


}
