package 练习.字符串.KMP;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-29 10:17
 **/
public class Kmp {

    public static int KMP(String str1, String str2){
        if (str1 == null || str2 == null || str1.length()<1 || str1.length()<str2.length() || str2.length()<1){
            return -1;
        }
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        //得到str2的next数组
        int[] next = getNextArray(s2);
        //两个指针，分别指向str1和str2当前比较的位置
        int p1 = 0;
        int p2 = 0;
        while(p1<str1.length() && p2<str2.length()){
            if (s1[p1] == s2[p2]){
                p1++;
                p2++;
            }else {//当前位置不匹配了
                if (next[p2] == -1){//如果已经到了str2的第一个字符还没有匹配
                    p1++;//就继续尝试str1的下一个字符
                }else {
                    p2 = next[p2];//指针指向str2前缀的下一个位置
                }
            }
        }
        return p2 == str2.length()?p1-p2:-1;//如果，p2跑完了整个str2，说明匹配完毕，此时p1肯定也停在str2的末尾，则开始位置就是p1-p2
        //否则说明两个字符串没有匹配上，返回-1

    }

    public static int[] getNextArray(char[] str2){
        if (str2.length == 1){
            return new int[]{-1};
        }
        //要返回的next数组
        int[] next = new int[str2.length];
        next[0] = -1;//认为规定：0位置上的值为-1
        next[1] = 0;//因为前后缀不包括前缀的最后一个数和后缀的第一个数，所以这里唯一的一个数不属于前缀和后缀，值为0；
        int i = 2;//从第二个位置开始遍历
        int cn = 0;//跳跃到的位置：
        while (i<str2.length) {
            if (str2[i - 1] == str2[cn]) {//如果当前位置的上一个位置和cn指向的位置相等，cn++， 且当前位置值=cn
                next[i++] = ++cn;
            } else if (cn > 0) {//如果当前位置的上一个位置和cn指向的位置不相等，cn跳到next[cn]
                cn = next[cn];
            } else {//如果不相等且cn==0，则i位置的值也为0
                next[i++] = 0;
            }
        }
        return next;
    }
}
