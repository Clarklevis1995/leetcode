package 删除中间节点;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-15 23:17
 **/
public class Solution {
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

    public static void deleteNode(ListNode node) {
        if(node == null){
            return;
        }
        int size = 0;
        ListNode cur = node;
        while(cur != null){
            size++;
            cur = cur.next;
        }

        int middle = (size-1)/2;
        while(middle>1){
            node = node.next;
            middle--;
        }
        node.next = node.next.next;

    }

    public static void main(String[] args) {
        ListNode head = linkGenerator(new int[]{4,5,1,9});
        deleteNode(head);
        System.out.println(head);

    }
}
