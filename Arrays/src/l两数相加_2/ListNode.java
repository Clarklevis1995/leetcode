package l两数相加_2;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-11-17 23:05
 **/
public class ListNode {
    int val;
    ListNode next;
    ListNode(){};
    ListNode(int val){this.val = val;}
    ListNode(int val, ListNode next){this.val = val; this.next = next;}

    @Override
    public String toString() {
        if (next == null){
            return ""+this.val;
        }else {
            return ""+this.val+" "+next;
        }
    }
}
