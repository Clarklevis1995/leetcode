package 练习;

public class 括号深度 {
    public static void main(String[] args) {
        String s = "(((())))(())()";
        System.out.println(paraDepth(s));
    }

    public static int paraDepth(String s){
        int max = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                count++;
                max = Math.max(max,count);
            }else {
                count--;
            }
        }
        return max;
    }
}
