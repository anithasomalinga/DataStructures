package corejava.stackqueue;

public class Queue {

    private int[] arr;
    private int capacity;
    private int size;
    private int rear = -1;
    private int front = 0;

    public Queue(int capacity) {
        arr = new int[capacity];
        this.capacity = capacity;
        size = 0;
    }

    public void enqueue(int data) {
        if (size == capacity) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % capacity; // circular wrap
        arr[rear] = data;
        size++;
    }

    public int dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return -1;
        }
        int data = arr[front];
        front = (front + 1) % capacity; //circular wrap
        size--;
        return data;
    }

    public int peek() {
        if(size == 0) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];
    }

}
