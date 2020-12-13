package 练习.散列表;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-10 15:02
 **/
public class RandomPool {
    public static class Pool<K>{
        private HashMap<K, Integer> keyIndexMap;
        private HashMap<Integer, K> indexKeyMap;
        private int size;

        public Pool() {
            this.keyIndexMap = new HashMap<>();
            this.indexKeyMap = new HashMap<>();
            size = 0;
        }

        public void insert(K key){
            if (!keyIndexMap.containsKey(key)){
                keyIndexMap.put(key,size);
                indexKeyMap.put(size++, key);
            }
        }

        /**
         * 保证要删除的index不变，改变对应的key（用最后一位的key替换），这样可以保证在删除完成之后，0~size-1之间不会有空位
         * @param key
         */
        public void delete(K key){
            if (keyIndexMap.containsKey(key)){
                int deleteIndex = keyIndexMap.get(key);
                int lastIndex = --size;
                K lastKey = indexKeyMap.get(lastIndex);
                keyIndexMap.put(lastKey, deleteIndex);
                indexKeyMap.put(deleteIndex, lastKey);
                keyIndexMap.remove(key);
                indexKeyMap.remove(lastIndex);

            }
        }

        public K getRandom(){
            if (this.size == 0){
                return null;
            }
            int randomIndex = (int)(Math.random()*size);
            return indexKeyMap.get(randomIndex);
        }
    }

    public static void main(String[] args) {
        Pool<String> pool = new Pool<>();
        pool.insert("Li");
        pool.insert("Chao");
        pool.insert("Fan");
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
    }

}
