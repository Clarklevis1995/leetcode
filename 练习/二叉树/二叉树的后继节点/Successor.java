package 练习.二叉树.二叉树的后继节点;

public class Successor {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node findSuccessor(Node node){
        if (node == null){
            return null;
        }
        //如果有右子树，后继节点一定是右子树上最左边的节点
        if (node.right!=null){
            Node cur = node.right;
            while(cur.left!=null){
                cur = cur.left;
            }
            return cur;
        }
        //如果没有右子树，则向上找parent
        //如果发现当前节点是parent的左子节点，返回parent
        //如果发现当前节点是parent的右子节点，将parent变为当前节点，继续向上找，直到发现自己是某个parent的左子节点
        Node parent = node.parent;
        while(parent != null){
            if (node == parent.left){
                return parent;
            }
            node = parent;
            parent = parent.parent;
        }
        return null;
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

        //parent node
        n1.parent = null;
        n2.parent = n1;
        n3.parent = n1;
        n4.parent = n2;
        n5.parent = n2;
        n6.parent = n3;
        n7.parent = n3;

        Node successor = findSuccessor(n5);
        System.out.println(successor==null?"null":successor.value);
    }
}
