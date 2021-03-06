package 队列;

import java.util.ArrayList;
import java.util.List;

public class MyQueue {
    private List<Integer> data;
    private int p_start;

    public MyQueue() {
        this.data = new ArrayList<>();
        this.p_start = 0;
    }

    public boolean enQueue(int x){
        data.add(x);
        return true;
    }

    public boolean deQueue(){
        if (isEmpty() == true){
            return false;
        }
        p_start++;
        return true;
    }

    public int front(){
        return data.get(p_start);
    }

    public boolean isEmpty(){
        return p_start>=data.size();
    }
}
