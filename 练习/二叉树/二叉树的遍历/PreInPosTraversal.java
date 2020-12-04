package 练习.二叉树.二叉树的遍历;

import java.util.Stack;

public class PreInPosTraversal {

    /*
    递归方式
     */
    public static void preOrderRecur(Node head){
        if (head == null){
            return;
        }
        System.out.print(head.value+" ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void inOrderRecur(Node head){
        if (head == null){
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value+" ");
        inOrderRecur(head.right);
    }

    public static void posOrderRecur(Node head){
        if (head == null){
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value+" ");
    }

    public static void preOrderNoRecur(Node head){
        if (head != null){
            Stack<Node> stack = new Stack<>();
            Node cur = head;
            stack.push(cur);
            while(!stack.isEmpty()){
                cur = stack.pop();
                System.out.print(cur.value+" ");
                if (cur.right!=null){
                    stack.push(cur.right);
                }
                if (cur.left!=null){
                    stack.push(cur.left);
                }
            }
        }
    }

    public static void inOrderNoRecur(Node head){
        if (head!=null){
            Stack<Node> stack = new Stack<>();
            Node cur = head;
            while(!stack.isEmpty() || cur != null){
                //如果当前节点不为空，一直将当前节点和左子节点
                if (cur!=null){
                    stack.push(cur);
                    cur = cur.left;
                }else {
                    cur = stack.pop();
                    System.out.print(cur.value+" ");
                    cur = cur.right;
                }
            }
        }
    }

    public static void posOrderNoRecur(Node head){
        if (head != null){
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            Node cur = head;
            stack1.push(cur);
            while(!stack1.isEmpty()){
                cur = stack1.pop();
                stack2.push(cur);
                if (cur.left!=null){
                    stack1.push(cur.left);
                }
                if (cur.right!=null){
                    stack1.push(cur.right);
                }
            }
            while(!stack2.isEmpty()){
                System.out.print(stack2  .pop().value+" ");
            }
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        //preOrderNoRecur(head);
        //inOrderNoRecur(head);
        posOrderNoRecur(head);
    }


}
