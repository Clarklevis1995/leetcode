package 字符串轮转;

import java.util.HashSet;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-15 17:59
 **/
public class StringRotate {
    //"PvcvpkpHwaXQxpgGzURBvHRMvCsCPPmlKBSzXDWSvrxLBPdAvRpgcIwNOVQDdwPIElrAFqmb"
    //"SvrxLBPdAvRpgcIwNOVQDdwPIElrAFqmbPvcvpkpHwaXQxpgGzURBvHRMvCsCPPmlKBSzXDW"
    public static boolean isFlipedString(String s1, String s2) {
        if(s1.length()!=s2.length()){
            return false;
        }
        if(s1.equals(s2)){
            return true;
        }
        String s3 = s2+s2;
        String s4 = s1+s1;
        return s3.contains(s1)&&s4.contains(s2);

    }

    public static void main(String[] args) {
        String s1 = "PvcvpkpHwaXQxpgGzURBvHRMvCsCPPmlKBSzXDWSvrxLBPdAvRpgcIwNOVQDdwPIElrAFqmb";
        String s2 = "SvrxLBPdAvRpgcIwNOVQDdwPIElrAFqmbPvcvpkpHwaXQxpgGzURBvHRMvCsCPPmlKBSzXDW";
        System.out.println(isFlipedString(s1, s2));
    }
}
