package 练习.栈实现队列;

import java.util.Stack;

public class TwoStackQueue {
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public TwoStackQueue() {
        this.pushStack = new Stack<>();
        this.popStack = new Stack<>();
    }

    public void add(int num){
        pushStack.push(num);
    }

    public int pull(){
        pour();
        if (popStack.isEmpty()){
            throw new RuntimeException("The queue is empty");
        }
        return popStack.pop();
    }

    public int peek(){
        pour();
        if (popStack.isEmpty()){
            throw new RuntimeException("The queue is empty");
        }
        return popStack.peek();
    }

    /**
     * 将push栈中的元素加入pop栈中
     */
    public void pour(){

        //如果pop栈不为空，则一定不能将push栈中的元素加进来
        if (!popStack.isEmpty()){
            return;
        }
        while(!pushStack.isEmpty()){
            popStack.push(pushStack.pop());
        }
    }

    public String toString(){
        return popStack.toString();
    }


    public static void main(String[] args) {
        TwoStackQueue queue = new TwoStackQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        for (int i = 0; i < 5; i++) {
            System.out.println(queue.pull());
            System.out.println(queue);
            System.out.println("-------------");
        }
    }
    /*
    1
    [5, 4, 3, 2]
    -------------
    2
    [5, 4, 3]
    -------------
    3
    [5, 4]
    -------------
    4
    [5]
    -------------
    5
    []
    -------------
     */
}
