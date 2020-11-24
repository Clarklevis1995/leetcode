package 练习;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-11-24 16:55
 **/
public class 验证回文串 {
    public static void main(String[] args) {
        String s = "race a car";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s){
        if (s.length()==0){
            return true;
        }
        int p1 = 0;
        int p2 = s.length()-1;
        while(p1<p2){
            while(p1<p2&&!Character.isLetterOrDigit(s.charAt(p1))){
                p1++;
            }
            while(p1<p2&&!Character.isLetterOrDigit(s.charAt(p2))){
                p2--;
            }
            if (p1<p2) {
                if (Character.toLowerCase(s.charAt(p1)) == Character.toLowerCase(s.charAt(p2))) {
                    p1++;
                    p2--;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
