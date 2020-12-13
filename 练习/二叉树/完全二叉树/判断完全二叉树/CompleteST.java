package 练习.二叉树.完全二叉树.判断完全二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-04 21:11
 **/
public class CompleteST {

    public static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    /*
    利用层序遍历来判断
     */
    public static boolean isCBT(Node head){
        if (head == null){
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        boolean beginLeaf = false;//是否进入之后的节点都是叶子节点模式？
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            Node left = cur.left;
            Node right = cur.right;
            if (beginLeaf&&(left!=null || right!=null) || left==null&&right!=null){
                return false;
            }
            if (left!=null){
                queue.offer(left);
            }
            if (right!=null){
                queue.offer(right);
            }
            if (left!=null&&right==null){
                beginLeaf = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);


        System.out.println(isCBT(head));

    }
}
