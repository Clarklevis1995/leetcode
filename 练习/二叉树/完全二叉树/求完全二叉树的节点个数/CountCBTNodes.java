package 练习.二叉树.完全二叉树.求完全二叉树的节点个数;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-05 08:59
 **/
public class CountCBTNodes {

    public static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static int nodeCount(Node head){
        if (head == null){
            return 0;
        }
        return process(head, 1, mostLeftLevel(head, 1));
    }
    /**
     *
     * @param node 当前被处理的节点
     * @param level 当前节点所在的层数
     * @param h 整棵树的最大层数
     * @return 当前节点为头节点的子树的节点数
     */
    public static int process(Node node, int level, int h){
        if (level == h){
            return 1;
        }
        if (mostLeftLevel(node.right, level+1) == h){//此时右子树的左边界到达了最大深度，说明左子树是满的，递归检查右子树
            //注意这里的左移运算需要用括号括起来（移位运算符的运算级很低，低于+-）
            return (1<<(h-level))+process(node.right, level+1, h);
        }else {//此时右子树的左边界没有到达最大深度，说明右子树是满的，高度为 h-level-1，继续递归左子树
            return (1<<(h-level-1))+process(node.left, level+1, h);
        }
    }

    /**
     *
     * @param head 当前节点
     * @param level 当前节点所在的层数
     * @return 返回当前节点最深层的左节点的层数（相对于整棵树的层数）
     */
    public static int mostLeftLevel(Node head, int level){
        while (head!=null){
            level++;
            head = head.left;
        }
        return level-1;
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        //System.out.println(nodeNum(head));
        System.out.println(nodeCount(head));

    }
}
