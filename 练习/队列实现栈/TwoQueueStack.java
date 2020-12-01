package 练习.队列实现栈;

import java.util.LinkedList;
import java.util.Queue;

public class TwoQueueStack {
    private Queue<Integer> data;
    private Queue<Integer> help;

    public TwoQueueStack() {
        this.data = new LinkedList<>();
        this.help = new LinkedList<>();
    }

    public void push(int num){
        data.add(num);
    }

    public int peek(){
        if (data.isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        while(data.size()>1){
            help.add(data.poll());
        }
        int res = data.poll();
        help.add(res);
        swap();
        return res;

    }

    public int pop(){
        if (data.isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        while (data.size()>1){
            help.add(data.poll());
        }
        int res = data.poll();
        swap();
        return res;
    }

    public void swap(){
        Queue<Integer> temp = data;
        data = help;
        help = temp;
    }

    public String toString(){
        return data.toString();
    }

    public static void main(String[] args) {
        TwoQueueStack stack = new TwoQueueStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        //按顺序弹出栈顶
        for (int i = 0; i < 6; i++) {
            System.out.println(stack.pop());
            System.out.println(stack);
            System.out.println("--------------");
        }
    }
}
