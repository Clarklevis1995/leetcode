package 设计循环队列;
//["MyCircularQueue","enQueue","enQueue","enQueue","enQueue","Rear","isFull","deQueue","enQueue","Rear"]
//[[3],[1],[2],[3],[4],[],[],[],[4],[]]
public class Test {
    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(3);
        System.out.println(queue.enQueue(1));//true
        System.out.println(queue.enQueue(2));;//true
        System.out.println(queue.enQueue(3));//true
        System.out.println(queue.enQueue(4));//false

        System.out.println(queue.Rear());//3
        System.out.println(queue.isFull());//true
        System.out.println(queue.deQueue());//true

        System.out.println(queue.enQueue(4));//true
        System.out.println(queue.Rear());//4
    }
}
