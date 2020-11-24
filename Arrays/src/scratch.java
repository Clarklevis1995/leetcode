import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-11-18 13:31
 **/
public class scratch {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer(10);
        s.append("1234");
        //System.out.println("length: "+s.length());
        //System.out.println("capacity: "+s.capacity());

        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(6);
        list.add(0,4);
        list.remove(1);
        for (int i:list
             ) {
            System.out.print(i+" ");
        }

    }
}
