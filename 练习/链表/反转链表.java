package 练习.链表;

public class 反转链表 {
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
        ListNode newHead = reverseList(a);
        while(newHead!=null){
            System.out.println(newHead.value);
            newHead = newHead.next;
        }

    }

    public static ListNode reverseList(ListNode head){
        if (head == null){
            return null;
        }
        ListNode next = null;
        ListNode pre = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
class ListNode{
    int value;
    ListNode next = null;

    public ListNode(int value) {
        this.value = value;
    }
}