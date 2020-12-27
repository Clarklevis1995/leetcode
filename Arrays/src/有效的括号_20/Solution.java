package 有效的括号_20;

import java.util.Stack;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-11-27 18:07
 **/
public class Solution {
    public static void main(String[] args) {
        String s = "{[}]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (inLeftPara(s.charAt(i))){
                stack.add(s.charAt(i));
            }else {
                if (stack.size() != 0 && s.charAt(i) == getPairedPara(stack.peek())){
                    stack.pop();
                }else{
                    stack.add(s.charAt(i));

                }
            }
        }
        return stack.size() == 0;
    }

    public static boolean inLeftPara(char c){
        return c == '(' || c == '[' || c == '{';
    }

    public static char getPairedPara(char c){
        switch (c){
            case '(':
                return ')';
            case '{':
                return '}';
            case '[':
                return ']';
        }
        return 0;
    }
}
