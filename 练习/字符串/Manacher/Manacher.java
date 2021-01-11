package 练习.字符串.Manacher;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-29 16:18
 **/


public class Manacher {

    /**
     * 目的：将传入的String转换成插入#虚轴的String
     * @param s 要被转化的String
     * @return 转化好的字符串数组（方便后续使用）
     */
    public static char[] manacherString(String s){
        char[] charArr = s.toCharArray();
        char[] result = new char[s.length()*2+1];//为#提供空间
        int index = 0;
        for (int i = 0; i < result.length; i++) {
            result[i] = (i & 1) == 0?'#':charArr[index++]; //这里 (i & 1)是判断i是不是奇数，如果是奇数，传入#）
        }
        return result;
    }
}
