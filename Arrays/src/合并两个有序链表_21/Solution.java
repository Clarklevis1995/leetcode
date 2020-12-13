package 合并两个有序链表_21;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-05 16:56
 **/
public class Solution {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        while(l1!=null){
            cur.next = l1.next;
            cur = cur.next;
            l1 = l1.next;
        }

        while(l2!=null){
            cur.next = l2.next;
            cur = cur.next;
            l2 = l2.next;
        }

        return head.next;

    }

    public static void main(String[] args) {
        ListNode l1 = linkGenerator(new int[]{1,2,4});
        ListNode l2 = linkGenerator(new int[]{1,3,4});
        System.out.println(mergeTwoLists(l1,l2));
    }


    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            ListNode temp = this;
            while(temp!=null){
                result.append(temp.next==null?temp.val:temp.val+" -> ");
                temp = temp.next;
            }
            return result.toString();
        }
    }

    public static ListNode linkGenerator(int[] nums){
        ListNode head = new ListNode(nums[0]);
        ListNode temp = head;
        for (int i = 1; i < nums.length; i++) {
            temp.next = new ListNode(nums[i]);
            temp = temp.next;
        }
        return head;
    }
}
