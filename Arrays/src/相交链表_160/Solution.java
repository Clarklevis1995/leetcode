package 相交链表_160;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-05 13:28
 **/
public class Solution {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        ListNode tailA = getTail(headA).tail;
        ListNode tailB = getTail(headB).tail;
        int sizeA = getTail(headA).size;
        int sizeB = getTail(headB).size;

        if(tailA!=tailB){
            return null;
        }

        ListNode longer = sizeA>sizeB?headA:headB;
        ListNode shorter = sizeA>sizeB?headB:headA;
        int sub = Math.abs(sizeA-sizeB);
        for(int i = 0; i<sub; i++){
            longer = longer.next;
        }

        while(longer!=null){
            if(longer == shorter){
                return longer;
            }
            longer = longer.next;
            shorter = shorter.next;
        }

        return null;



    }

    public Value getTail(ListNode head){
        int size = 1;
        while(head.next!=null){
            size++;
            head = head.next;
        }
        return new Value(size, head);
    }

    class Value{
        int size;
        ListNode tail;

        public Value(int size, ListNode node){
            this.size = size;
            this.tail = node;
        }
    }

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }
}
