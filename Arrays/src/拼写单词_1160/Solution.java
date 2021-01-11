package 拼写单词_1160;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-27 19:21
 **/
public class Solution {
    public static int countCharacters(String[] words, String chars) {
        HashMap<Character, Integer> charsMap = new HashMap<>();
        HashMap<Character, Integer> wordMap = new HashMap<>();
        for(char c:chars.toCharArray()){
            charsMap.put(c, charsMap.getOrDefault(c,0)+1);
        }

        int sum = 0;
        for(String word:words){
            wordMap = new HashMap<>();
            for(char c:word.toCharArray()){
                wordMap.put(c, wordMap.getOrDefault(c,0)+1);
            }
            boolean canBeRemember = true;
            for(char key:word.toCharArray()){
                if(!(charsMap.containsKey(key))||(wordMap.get(key)>charsMap.get(key))){
                    canBeRemember = false;
                    break;
                }
            }
            if (canBeRemember){
                sum += word.length();
            }

        }
        return sum;
    }

    public static int count2(String[] words, String chars){
        int[] cArr = new int[26];
        for (char c:chars.toCharArray()
             ) {
            cArr[c-'a']++;
        }
        int result = 0;
        for (String word:words
             ) {
            int[] wArr = new int[26];
            for (char w:word.toCharArray()
                 ) {
                wArr[w-'a']++;
            }
            boolean can = true;
            for (int i = 0; i < 26; i++) {
                if (wArr[i]>cArr[i]){
                    can = false;
                    break;
                }
            }
            if (can) {
                result += word.length();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"hello","world","leetcode"};
        String chars = "welldonehoneyr";
        System.out.println(count2(words, chars));
    }
}
