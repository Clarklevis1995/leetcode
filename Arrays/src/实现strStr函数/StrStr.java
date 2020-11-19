package 实现strStr函数;

public class StrStr {
    public static void main(String[] args) {

        String haystack = "a";
        String needle = "a";
        System.out.println(strStr(haystack,needle));
        char c = 127;

        System.out.println(c+1);

    }

    public static int strStr(String haystack, String needle){
        int p = 0;
        int needleLen = needle.length();
        if(needleLen==0){
            return 0;
        }
        while(p+needleLen<=haystack.length()){
            if(haystack.substring(p,p+needleLen).equals(needle)){
                return p;
            }else{
                p++;
            }
        }
        return -1;
    }
}

class A extends ClassLoader{

}

class B extends Number{

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }
}
