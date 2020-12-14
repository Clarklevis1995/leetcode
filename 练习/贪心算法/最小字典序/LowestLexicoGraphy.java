package 练习.贪心算法.最小字典序;

import java.util.Arrays;
import java.util.Comparator;

public class LowestLexicoGraphy {
    public static class MyComparator implements Comparator<String> {
        @Override
        //按照贪心策略设计比较器
        public int compare(String s1, String s2) {
            return (s1+s2).compareTo(s2+s1);
        }
    }

    public static String lowestString(String[] strs){
        if(strs == null || strs.length == 0){
            return "";
        }
        Arrays.sort(strs, new MyComparator());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            result.append(strs[i]);
        }

        return result.toString();
    }


}
