package 练习.链表;

import 练习.链表.ListNode;

public class 链表的倒数第k节点 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        System.out.println(findKthToTail(a,2).value);
    }

    /*
    首先两个节点/指针，一个节点 node1 先开始跑，指针 node1 跑到 k-1 个节点后，另一个节点 node2
    开始跑，当 node1 跑到最后时，node2 所指的节点就是倒数第k个节点也就是正数第(L-K+1)个节点
     */
    public static ListNode findKthToTail(ListNode head, int k){
        if (head == null || k<=0){
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        int count = 1;
        while(p1.next!=null){
            p1 = p1.next;

            if (count > k-1){
                p2 = p2.next;
            }
            count++;
        }
        return p2;
    }
}
