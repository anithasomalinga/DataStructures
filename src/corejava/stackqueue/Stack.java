package corejava.stackqueue;

// LIFO - Depth First Search - Last In First Out
// Only top to add or del data
public class Stack {

    private int[] arr;
    private int top = -1;
    private int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public void push(int data) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = data;
    }

    // delete data
    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }

    // Return the top value
    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top];
    }
}
