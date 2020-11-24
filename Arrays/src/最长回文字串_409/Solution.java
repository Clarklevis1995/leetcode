package 最长回文字串_409;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-11-24 16:24
 **/
public class Solution {
    public static void main(String[] args) {

        String s = "abccccdd";
        System.out.println(longestPalindrome2(s));
    }

    public static int longestPalindrome(String s){
        if (s.length() == 0){
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        char[] letters = s.toCharArray();
        int count = 0;
        for (char c:letters
             ) {
            if (set.contains(c)){
                count++;
                set.remove(c);
            }else {
                set.add(c);
            }
        }
        if (!set.isEmpty()){
            return 2*count+1;
        }else {
            return 2*count;
        }
    }

    //方法2，利用数组，桶计数
    public static int longestPalindrome2(String s){
        //将所有的字符按照ASCII码装到对应的bucket中
        int[] letters = new int[128];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)]++;
        }

        int count = 0;
        for (int n:letters
             ) {
            if (n>1){
                count+=(n/2*2);
            }
            if (n%2==1&&count%2==0){
                count++;
            }
        }

        return count;
    }
}
