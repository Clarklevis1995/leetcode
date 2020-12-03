package 练习.链表.两个相交的链表;

import 练习.链表.链表的荷兰国旗.HollandFlag;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-02 18:30
 **/
public class Intersection {

    public static Node getIntersectNode(Node head1, Node head2){
        if (head1 == null || head2 == null){
            return null;
        }
        if (head1 == head2){
            return head1;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null){
            return noLoop(head1, head2);
        }else if(loop1 != null&&loop2 != null){
            return bothLoop(head1, head2, loop1, loop2);
        }else {
            return null;
        }
    }

    public static Node getLoopNode(Node head){
        if (head == null || head.next == null || head.next.next == null){
            return null;
        }
        //两个只针的位置要错开
        Node fast = head.next.next;
        Node slow = head.next;
        //第一次重合
        while(fast != slow){
            if (fast.next == null||fast.next.next==null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        //重合后，快指针放回head
        fast = head;
        //寻找第二次重合
        while (fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        //返回当前重合节点
        return fast;
    }

    public static Node noLoop(Node head1, Node head2){
        if (head1 == null || head2 == null){
            return null;
        }
        //遍历head1
        int len1 = 0;
        Node endNode1 = null;
        Node cur = head1;
        while(cur != null){
            if (cur.next == null){
                endNode1 = cur;
            }
            len1++;
            cur = cur.next;
        }

        //遍历head2
        int len2 = 0;
        Node endNode2 = null;
        cur = head2;
        while(cur != null){
            if (cur.next == null){
                endNode2 = cur;
            }
            len2++;
            cur = cur.next;
        }
        //结尾节点不相等，肯定不相交
        if (endNode1!=endNode2){
            return null;
        }
        //结尾节点相等
        //长的链表先遍历sub步
        Node longerHead = len1>len2?head1:head2;
        Node shorterHead = len1>len2?head2:head1;
        int sub = len1>len2?len1-len2:len2-len1;

        for (int i = 0; i < sub; i++) {
            longerHead = longerHead.next;
        }
        while(longerHead!=shorterHead){

            longerHead = longerHead.next;
            shorterHead = shorterHead.next;
        }
        return longerHead;
    }

    public static Node bothLoop(Node head1, Node head2, Node loop1, Node loop2){

        if (loop1 == loop2){
            int len1 = 0;
            Node cur1 = head1;
            while(cur1 != loop1){
                len1++;
                cur1 = cur1.next;
            }

            //遍历head2
            int len2 = 0;
            Node cur2 = head2;
            while(cur2 != loop1){
                len2++;
                cur2 = cur2.next;
            }
            //结尾节点相等
            //长的链表先遍历sub步
            Node longerHead = len1>len2?head1:head2;
            Node shorterHead = len1>len2?head2:head1;
            int sub = len1>len2?len1-len2:len2-len1;

            for (int i = 0; i < sub; i++) {
                longerHead = longerHead.next;
            }
            while(longerHead!=shorterHead){

                longerHead = longerHead.next;
                shorterHead = shorterHead.next;
            }
            return longerHead;
        }

        Node cur = loop1.next;
        while (cur!=loop1){
            if (cur == loop2){
                return loop2;
            }
            cur = cur.next;
        }
        return null;
    }


    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }
}
