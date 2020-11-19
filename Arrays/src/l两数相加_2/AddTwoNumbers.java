package l两数相加_2;

import java.util.List;
import java.util.Stack;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-11-17 23:05
 **/
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = generate(new int[]{9,9,9,9,9,9,9});
        ListNode l2 = generate(new int[]{9,9,9,9});
        System.out.println(addTwoNumbers(l1,l2));
    }

    public static ListNode generate(int[] nums){
        ListNode result = new ListNode();
        ListNode header = result;
        for (int i = 0; i < nums.length ; i++) {
            result.val = nums[i];
            if (i!=nums.length-1){
                result.next = new ListNode();
                result = result.next;
            }
        }
        return header;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode result = new ListNode(0);
        ListNode head = result;
        while(true){

            if((result.val+l1.val+l2.val)>=10){
                result.next = new ListNode((result.val+l1.val+l2.val)/10);
            }else{
                result.next = new ListNode(0);
            }
            result.val = (result.val+l1.val+l2.val)%10;
            if(l1.next!=null || l2.next!=null){
                result = result.next;
                if(l1.next == null){
                    l1.next = new ListNode(0);
                }
                if(l2.next == null){
                    l2.next = new ListNode(0);
                }
                l1 = l1.next;
                l2 = l2.next;
            }else{
                if (result.next.val==0) {
                    result.next = null;
                }
                break;
            }
        }

        Stack stack = new Stack();
        stack.pop();


        return head;
    }
}
