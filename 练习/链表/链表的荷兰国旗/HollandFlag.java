package 练习.链表.链表的荷兰国旗;


/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-02 11:51
 **/
public class HollandFlag {

    public static void main(String[] args) {
        Node head = linkGenerator(new int[]{1,2,9,8,7,3,4,2,1,0});
        System.out.println(hollandFlag(head, 3));
    }

    public static Node hollandFlag(Node head, int num){
        Node hLess = null;
        Node tLess = null;
        Node hEqu = null;
        Node tEuq = null;
        Node hMore = null;
        Node tMore = null;
        while(head!=null){
            Node next = head.next;
            head.next = null;//防止加入一连串的node
            if (head.val < num){
                if (hLess == null){
                    hLess = head;
                    tLess = head;
                }else {
                    tLess.next = head;
                    tLess = tLess.next;
                }
            }else if(head.val == num){
                if (hEqu == null){
                    hEqu = head;
                    tEuq = head;
                }else {
                    tEuq.next = head;
                    tEuq = tEuq.next;
                }
            }else {
                if (hMore == null){
                    hMore = head;
                    tMore = head;
                }else {
                    tMore.next = head;
                    tMore = tMore.next;
                }
            }
            head = next;
        }

        //连接less和equal
        //尾部和下一段的头部相连
        if (tLess!=null){
            tLess.next = hEqu;
            tEuq = tEuq == null?tLess:tEuq;
        }
        //连接more
        if (tEuq!=null){
            tEuq.next = hMore;
        }
        return hLess!=null?hLess:hEqu!=null?hEqu:hMore;
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
