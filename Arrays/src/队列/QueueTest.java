package 队列;

public class QueueTest {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.enQueue(5);
        myQueue.enQueue(3);

        if (!myQueue.isEmpty()){
            System.out.println(myQueue.front());
        }

        myQueue.deQueue();
        if (!myQueue.isEmpty()){
            System.out.println(myQueue.front());
        }

        myQueue.deQueue();
        if (!myQueue.isEmpty()){
            System.out.println(myQueue.front());
        }
    }
}
