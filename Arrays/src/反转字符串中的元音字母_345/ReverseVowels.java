package 反转字符串中的元音字母_345;

import java.util.*;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-11-16 10:56
 **/
public class ReverseVowels {
    public static void main(String[] args) {
        String s = "leetcode";
        //System.out.println(reverseVowels(s));
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->(b-a));
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue.peek());
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<Integer> list1= new LinkedList<>();

    }

    public static String reverseVowels(String s){
        char[] letters = s.toCharArray();
        int p1 = 0;
        int p2 = s.length()-1;

        while (p1<p2){
            while (p1<p2&&!isVowel(s.charAt(p1))){
                p1++;
            }
            while (p1<p2&&!isVowel(s.charAt(p2))) {
                p2--;
            }
            if (p1<p2){
                swap(letters, p1,p2);
                p1++;
                p2--;
            }
        }
        return String.valueOf(letters);

    }

    public static boolean isVowel(char c){
        c = Character.toLowerCase(c);
        return c == 'a'||c=='e'||c=='i'||c=='o'||c=='u';
    }

    public static void swap(char[] letters, int i, int j){
        char temp = letters[i];
        letters[i] = letters[j];
        letters[j] = temp;
    }
}
