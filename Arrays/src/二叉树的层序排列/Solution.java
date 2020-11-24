package 二叉树的层序排列;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: leetcode
 * @description：边弹出，边加进去弹出节点的子节点
 * @author: ClarkLevis
 * @create: 2020-11-21 08:56
 **/
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(levelOrder2(root));
    }

    //迭代法层序遍历(对每一层的元素循环遍历（记录了每一层的size，用size作为循环次数，给每一层分界）)
    public static List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }

    //迭代法，添加dumpy标记（利用外层的大循环弹出队列中的元素，用标记节点给每一层分界）
    public static List<List<Integer>> levelOrder2(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> levelNodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return result;
        }
        queue.offer(root);
        //每一层的分节符
        TreeNode dumpy = new TreeNode(-1);
        queue.offer(dumpy);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node == dumpy){
                result.add(levelNodes);
                levelNodes = new ArrayList<>();
                if (!queue.isEmpty()){
                    queue.offer(dumpy);
                }
            }else{
                levelNodes.add(node.val);
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }
}
