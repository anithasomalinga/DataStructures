package corejava.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    private Queue<Integer> queue1; // main queue
    private Queue<Integer> queue2; // temp queue

    public StackUsingQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int data) {
        queue1.add(data);
    }

    public int pop() {
        if (queue1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        int top = queue1.poll(); // last element - top of stack
        // swap q1 and q2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return top;
    }

    public int peek() {
        if (queue1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        int top = queue1.poll(); // last element - top of stack
        queue2.add(top); // put it back!
        // swap q1 and q2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return top;
    }
}
