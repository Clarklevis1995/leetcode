package 练习.固定数组实现.栈.获取栈中最小值;

import java.util.Stack;

public class NewStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int num){
        stack.push(num);
        if (minStack.size() == 0){
            minStack.push(num);
        }else {
            minStack.push(Math.min(num, this.getMin()));
        }
    }

    public int getMin(){
        if (stack.size() == 0){
            throw new ArrayIndexOutOfBoundsException("栈已空");
        }
        return minStack.peek();
    }

    public int pop(){
        if (stack.size() == 0){
            throw new ArrayIndexOutOfBoundsException("栈已空");
        }
        minStack.pop();
        return stack.pop();
    }

    public static void main(String[] args) {
        NewStack newStack = new NewStack();
        newStack.push(1);
        newStack.push(2);
        newStack.push(3);
        newStack.push(4);
        newStack.push(5);
        newStack.push(0);
        System.out.println("Before pop:----------");
        System.out.println(newStack.getMin());
        newStack.pop();
        System.out.println("After pop:-----------");
        System.out.println(newStack.getMin());
    }
}
