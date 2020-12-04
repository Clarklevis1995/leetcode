package 练习.二叉树.二叉树的序列化和反序列化;

import 练习.二叉树.二叉树的遍历.Node;

import javax.management.QueryEval;
import java.util.LinkedList;
import java.util.Queue;

public class Serialize {

    public static String preString(Node head){
        if (head == null){
            return "#!";
        }
        String result = head.value+"!";
        result += preString(head.left);
        result += preString(head.right);
        return result;
    }

    public static String inString(Node head){
        if (head == null){
            return "#!";
        }
        String result = "";
        result+=inString(head.left);
        result+=head.value+"!";
        result+=inString(head.right);

        return result;
    }

    public static String posString(Node head){
        if(head == null){
            return "#!";
        }
        String result = "";
        result += posString(head.left);
        result += posString(head.right);
        result += head.value+"!";
        return result;
    }

    public Node reconByString(String s){
        String[] values = s.split("!");
        Queue<String> queue = new LinkedList<>();
        for (String value:values
             ) {
            queue.offer(value);
        }
        return reconPreOrder(queue);
    }



    public Node reconPreOrder(Queue<String> queue){
        String value = queue.poll();
        if (value.equals("#")){
            return null;
        }
        Node head = new Node(Integer.parseInt(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }




    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;


        System.out.println(posString(n1));
    }
}
