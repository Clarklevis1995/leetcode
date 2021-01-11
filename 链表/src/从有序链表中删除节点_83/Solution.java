package 从有序链表中删除节点_83;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2021-01-06 13:31
 **/
public class Solution {

    public static void main(String[] args) {
        ListNode head = linkGenerator(new int[]{1,1,2,3,3});
        System.out.println(deleteDuplicates(head));
    }


    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode ptr = head.next;
        ListNode result = head;
        int old = head.val;
        while(true){
            if(ptr == null || ptr.val != old){
                head.next = ptr;
                head = head.next;
            }
            if (ptr == null){
                break;
            }else {
                old = ptr.val;
                ptr = ptr.next;
            }

        }
        return result;
    }

    public static class ListNode {
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
