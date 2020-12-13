package 练习.二叉树.判断平衡树;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-04 19:46
 **/
public class Balance {

    public static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class ReturnValue{
        boolean isBalance;
        int height;

        public ReturnValue(boolean isBalance, int height) {
            this.isBalance = isBalance;
            this.height = height;
        }
    }

    public static boolean isBalance(Node head){
        return process(head).isBalance;
    }

    public static ReturnValue process(Node head){
        if (head == null){
            return new ReturnValue(true, 0);
        }
        ReturnValue leftValue = process(head.left);
        ReturnValue rightValue = process(head.right);

        if (!leftValue.isBalance){
            return new ReturnValue(false,0);
        }
        if (!rightValue.isBalance){
            return new ReturnValue(false,0);
        }
        if (Math.abs(rightValue.height-leftValue.height)>1){
            return new ReturnValue(false,0);
        }
        return new ReturnValue(true, Math.max(rightValue.height, leftValue.height)+1);
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);


        System.out.println(isBalance(head));

        Node head2 = new Node(1);
        head2.right = new Node(3);
        head2.right.left = new Node(6);
        head2.right.left = new Node(7);
        System.out.println(isBalance(head2));

    }



}
