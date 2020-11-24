package 最长公共前缀_14;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-11-23 22:19
 **/
public class Solution {
    public static void main(String[] args) {
        String[] strs = {"a"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs[0].length() == 0){
            return "";
        }
        StringBuffer result = new StringBuffer();
        int i = 0;
        while(true){
            char common = strs[0].charAt(i);
            for(String s:strs){
                if(i<s.length()){
                    if(s.charAt(i) == common){
                        continue;
                    }else{
                        return result.toString();
                    }
                }else{
                    return result.toString();
                }
            }
            result.append(common);
            i++;
            if (i == strs[0].length()){
                return result.toString();
            }
        }
    }
}
