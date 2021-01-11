package 删除链表的倒数第n个节点_19;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-28 22:57
 **/
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);

    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fast = head;
        ListNode slow = head;
        ListNode dum = new ListNode(-1);
        dum.next = head;
        ListNode pre = null;

        for(int i = 0; i<n-1; i++){
            fast = fast.next;
        }
        while(fast.next != null){
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        if(slow != head){
            pre.next = slow.next;
        }else{

        }

        return dum.next;

    }

}
