package 练习.链表.回文链表;

import java.util.Stack;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-02 10:34
 **/
public class Palindrome {
    public static void main(String[] args) {
        Node head = linkGenerator(new int[]{1,2,3,4,5,5,4,3,2,1});
        System.out.println(head);
        //System.out.println(isPalindrome3(head));
    }

    //空间复杂度为n
    public static boolean isPalindrome1(Node head){
        Stack<Integer> stack = new Stack<>();
        Node pointer = head;
        while (pointer!=null){
            stack.push(pointer.val);
            pointer = pointer.next;
        }
        pointer = head;
        while (!stack.isEmpty()){
            if (stack.pop()!=pointer.val){
                return false;
            }
            pointer = pointer.next;
        }
        return true;
    }

    //空间复杂度为n/2
    public static boolean isPalindrome2(Node head){
        if (head == null || head.next == null){
            return true;
        }
        Node slow = head.next;//注意这里慢指针的初始位置
        Node fast = head;

        //当循环终止时，fast在最后一位（奇数），或者在倒数第二位（偶数）
        //slow在中间位置的下一位（奇数）1->2->3->(2)->1，或者在中间相等两数的第二个数（偶数）1->2->3->(3)->2->1
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //将此时从slow开始的链表压栈
        Stack<Integer> stack = new Stack<>();
        while (slow!=null){
            stack.push(slow.val);
            slow = slow.next;
        }

        while(!stack.isEmpty()){
            if (head.val != stack.pop()){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome3(Node head){
        if (head == null || head.next == null){
            return true;
        }

        Node n1 = head;//慢指针
        Node n2 = head;//快指针
        //慢指针移动到中点，或者中间偏左的位置（偶数）
        while(n2.next!=null&&n2.next.next!=null){
            n1 = n1.next;
            n2 = n2.next.next;
        }
        //开始反转后半部分的链表
        n2 = n1.next;
        n1.next = null;//mid.next = null
        Node n3 = null;
        while(n2!=null){
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }

        //两个节点分别从两端遍历，查看每个节点的相等情况
        n3 = n1;
        n2 = head;
        boolean res = true;
        while (n1!=null&&n2!=null){
            if (n1.val!=n2.val){
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        //再将后半部分的链表反转回来
        n1 = n3.next;
        n3.next = null;
        while(n1!=null){
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }






    public static class Node{
        int val;
        Node next;

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
