package 练习.固定数组实现.栈;

import java.security.spec.ECField;

public class ArrayStack {
    public int[] data;
    private int index;


    public ArrayStack(int initialSize) {
        if (initialSize<0){
            throw new ArrayIndexOutOfBoundsException("初始容量不能为负数");
        }
        this.data = new int[initialSize];
        this.index = 0;
    }

    public int peek(){
        if (index == 0)
            throw new ArrayIndexOutOfBoundsException("The stack is empty");
        return data[index-1];
    }

    public void push(int num){
        if (index == data.length){
            throw new ArrayIndexOutOfBoundsException("The stack is full");
        }
        data[index++] = num;
    }

    public int pop(){
        if (index == 0){
            throw new ArrayIndexOutOfBoundsException("The stack is empty");
        }
        return data[--index];
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("[ ");
        for (int i = 0; i < data.length; i++) {
            builder.append(data[i]);
            if (i!=data.length-1){
                builder.append(", ");
            }
        }
        builder.append(" ]");
        return builder.toString();

    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        try {
            stack.peek();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);

        //查看栈顶元素
        System.out.println("查看栈顶元素--------------");
        System.out.println(stack.peek());

        System.out.println("出栈--------------");
        try{
            for (int i = 0; i < 5; i++) {
                System.out.println(stack.pop());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }




    }
}

