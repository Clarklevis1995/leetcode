package 练习.前缀树;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-12 16:10
 **/
public class TrieTree {
    public static class TrieNode{
        int path;//经过该节点的次数
        int end;//以当前node为节点的次数
        TrieNode[] nexts;

        public TrieNode() {
            this.path = 0;
            this.end = 0;
            this.nexts = new TrieNode[26];//规定当前String中的字符都是26个英文字母（小写）
        }
    }

    public static class Trie{
        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }
        /**
         * 插入word
         * @param s 要插入的word
         */
        public void insert(String s){
            if (s == null){
                return;
            }
            char[] chars = s.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i<chars.length; i++) {
                index = chars[i] - 'a';//确定是nexts中的哪一条支路
                if (node.nexts[index] == null){
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];//node变为下一个节点
                node.path++;//这个节点被经过，path++
            }
            node.end++;//循环结束，此时停到的节点就是String末尾，end++
        }

        /**
         * 查看要查找的值插入了几次
         * @param word
         * @return
         */
        public int search(String word){
            if (word == null){
                return 0;
            }
            TrieNode node = root;
            int index = 0;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                index = chars[i]-'a';
                if (node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        /**
         * 删除提供的word
         * @param word
         */
        public void delete(String word){
            //只有这个word存在才能删除
            if (search(word)!=0){
                TrieNode node = root;
                int index = 0;
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    index = chars[i] - 'a';
                    node = node.nexts[index];
                    //将经过node的次数-1
                    node.path--;
                    //如果删除之后，经过当前节点的次数==0，说明没有word会经过此节点了，直接指向null
                    if (node.path == 0){
                        node = null;
                        return;
                    }
                }
                node.end--;
            }
        }

        /**
         * 给定前缀的出现次数
         * @param prefix 提供的前缀
         * @return 前缀在树中的出现次数
         */
        public int prefixNum(String prefix){
            if (prefix == null){
                return 0;
            }
            TrieNode node = root;
            int index = 0;
            char[] chars = prefix.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.path;
        }
    }

    public static void main(String[] args) {
        Trie tree = new Trie();
        tree.insert("root");
        tree.insert("root");
        tree.insert("root");
        tree.insert("root");
        tree.insert("root");
        tree.insert("root");

        tree.delete("root");
        tree.delete("root");
        tree.delete("root");

        tree.insert("hello");
        tree.insert("hello");
        tree.insert("hello");

        tree.insert("this");
        System.out.println(tree.search("root")); //3
        System.out.println(tree.search("hello"));//3
        System.out.println(tree.search("this"));//1
        System.out.println(tree.prefixNum("ro"));//6
    }
}
