import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-09 09:37
 **/
public class demo {
    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        Integer[] integers = queue.toArray(new Integer[]{});
        System.out.println(Arrays.toString(integers));


    }
}
