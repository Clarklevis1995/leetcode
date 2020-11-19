package 验证回文串_125;

import java.util.ArrayList;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-11-15 22:29
 **/
public class IsPalindrome {
    public static void main(String[] args) {

        String s = ".,";
        System.out.println(isPalindrome2(s));

    }

    public static boolean isPalindrome(String s){
        ArrayList<Character> letters = new ArrayList<>();
        if (s.length()==0){
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isCharacterOrDigit(s.charAt(i))){
                letters.add(s.charAt(i));
            }
        }
        for (int i = 0; i < letters.size()/2; i++) {
            if (!(letters.get(i)+"").equalsIgnoreCase(letters.get(letters.size()-1-i)+"")){
                return false;
            }
        }
        return true;
    }

    public static boolean isCharacterOrDigit(char c){
        if ((c>=65&&c<=90)||(c>=97&&c<=122)||(c>=48&&c<=57)){
            return true;
        }
        return false;
    }

    public static boolean isPalindrome2(String s){
        int p1 = 0;
        int p2 = s.length()-1;
        while(p1<p2){
            while(p1<s.length()&&!Character.isLetterOrDigit(s.charAt(p1))){
                p1++;
            }
            while (p2>=0&&!Character.isLetterOrDigit(s.charAt(p2))){
                p2--;
            }
            if (p1<p2){
                if(Character.toLowerCase(s.charAt(p1))!=Character.toLowerCase(s.charAt(p2))){
                    return false;
                }
                p1++;
                p2--;
            }

        }
        return true;
    }
}
