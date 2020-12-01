package 练习;

public class 把字符串转换成整数 {
    public static void main(String[] args) {
        String s = "3.14159";
        System.out.println(parseInt(s));
    }

    public static int parseInt(String str){
        /*
        剑指offer: 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
        但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
        数值为0或者字符串不是一个合法 的数值则返回0。
         */
        int result = 0;
        str = str.trim();
        if (str.length() == 0){
            return 0;
        }
        int flag = 0;
        if (str.charAt(0) == '-'){
            flag = 1;
        }else if(str.charAt(0) == '+'){
            flag = 2;
        }else if(!Character.isDigit(str.charAt(0))){
            return 0;
        }

        int start = flag>0?1:0;
        for (int i = start; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))){
                int temp = str.charAt(i) - '0';
                if (result>Integer.MAX_VALUE/10||(result==Integer.MAX_VALUE/10&&temp>7)){
                    return flag == 1?Integer.MIN_VALUE:Integer.MAX_VALUE;
                }
                result = result*10+temp;
            }else {
                break;
            }
        }
        return flag == 1?-result:result;
    }
}
