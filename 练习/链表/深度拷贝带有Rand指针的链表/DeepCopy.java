package 练习.链表.深度拷贝带有Rand指针的链表;

import com.sun.security.auth.UnixNumericGroupPrincipal;
import 练习.链表.链表的荷兰国旗.HollandFlag;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-02 15:30
 **/
public class DeepCopy {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.rand = head;
        head.next.next.rand = null;

        System.out.println(copyListWithRand1(head));


    }

    //需要额外的存储空间
    public static Node copyListWithRand1(Node head){
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while(cur!=null){
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while(cur!=null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    //不需要额外的存储空间
    public static Node copyListWithRand2(Node head){
        Node cur = head;
        Node next = null;
        //构造出 1 -> 1 -> 2 -> 2 -> 3 -> 3 这种结构
        while(cur!=null){
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node curCopy = null;
        //设置 “复制Node”的rand指针
        while(cur!=null){
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand == null? null:cur.rand.next;
            cur = next;
        }

        Node res = head.next;
        cur = head;
        //分离混合在一起的链表
        while(cur!=null){
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next==null?null:next.next;
            cur = next;
        }

        return res;
    }

}

class Node{
    int val;
    Node next;
    Node rand;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node temp = this;
        while(temp!=null){
            result.append(temp.next==null?temp.val:temp.val+" -> ");
            temp = temp.next;
        }
        return result.toString();
    }

    public static Node linkGenerator(int[] nums){
        Node head = new Node(nums[0]);
        Node temp = head;
        for (int i = 1; i < nums.length; i++) {
            temp.next = new Node(nums[i]);
            temp = temp.next;
        }
        return head;
    }
}
