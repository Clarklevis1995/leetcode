package 练习.散列表.并查集;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-11 11:38
 **/
public class UnionSet {
    public static class Node{

    }

    public static class unionFindSet{
        public HashMap<Node, Node> fatherMap;//key: child, value: father
        public HashMap<Node, Integer> sizeMap;//key: 当前节点， value：当前节点所在集合的size

        public unionFindSet(List<Node> nodes) {
            makeSets(nodes);
        }

        private void makeSets(List<Node> nodes){
            this.fatherMap = new HashMap<>();
            this.sizeMap = new HashMap<>();
            //集合初始化的时候，每个元素自成一个集合
            for (Node node:nodes) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        /**
         * 递归版本
         * @param node
         * @return
         */
        public Node findHead(Node node){
            Node father = fatherMap.get(node);
            //通过递归找到整个集合的代表节点
            if (father != node){
                father = findHead(father);
            }
            //将所有节点连到那个代表节点上去
            fatherMap.put(node, father);
            return father;
        }

        /**
         *
         * 非递归版本
         * @param node
         * @return
         */
        public Node findHead2(Node node){
            Stack<Node> nodeStack = new Stack<>();
            Node father = fatherMap.get(node);
            while(father!=node){
                nodeStack.push(node);
                node = father;
                father = fatherMap.get(node);
            }
            while(!nodeStack.isEmpty()){
                fatherMap.put(nodeStack.pop(),father);
            }
            return father;
        }

        /**
         * 判断是否是同一个集合
         * @param a
         * @param b
         * @return
         */
        public boolean isSameSet(Node a, Node b){
            return findHead(a) == findHead(b);
        }

        public void union(Node a, Node b){
            if (a == null || b == null){
                return;
            }
            Node aHead = findHead(a);
            Node bHead = findHead(b);
            //只有两个代表节点不相等才需要合并
            if (aHead!=bHead){
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                if (aSetSize>bSetSize){
                    //将bSet挂载到aSet下面
                    fatherMap.put(bHead, aHead);
                    //更新aSet的size（两个set size的和）
                    sizeMap.put(aHead, aSetSize+bSetSize);
                }else {
                    fatherMap.put(aHead, bHead);
                    sizeMap.put(bHead, aSetSize+bSetSize);
                }
            }
        }
    }



}
