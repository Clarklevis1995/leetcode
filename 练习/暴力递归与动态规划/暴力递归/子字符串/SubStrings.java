package 练习.暴力递归与动态规划.暴力递归.子字符串;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-14 16:30
 **/
public class SubStrings {
    /**
     * 打印出当前字符串的所有子序列
     * @param strs 字符串转成的字符数组
     * @param i 当前指针的位置
     * @param result 返回的字符串结果
     */
    public static void printAllSub(char[] strs, int i, String result){
        if(i == strs.length){
            System.out.println(result);
            return;
        }
        printAllSub(strs, i+1, result);
        printAllSub(strs, i+1, result+strs[i]);
    }

    public static void main(String[] args) {
        String s = "abcde";
        char[] chars = s.toCharArray();
        printAllSub(chars, 0, "");
    }
}
