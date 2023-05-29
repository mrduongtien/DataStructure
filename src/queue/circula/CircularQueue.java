package queue.circula;

import java.util.ArrayList;

public class CircularQueue<E> {
    private int headIndex;
    private int tailIndex;
    private int capacity;
    private int currentElement;
    private ArrayList<E> data;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        headIndex = -1;
        tailIndex = -1;
        currentElement = 0;
        data = new ArrayList<E>(capacity);
    }

    public static void main(String[] args) {
        CircularQueue<Integer> queue = new CircularQueue<Integer>(10);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);
        queue.enqueue(400);
        queue.enqueue(500);
        queue.enqueue(600);
        queue.enqueue(700);
        queue.enqueue(800);
        queue.enqueue(900);
        System.out.println("Size of queue: " + queue.size());
        queue.display();
    }

    public boolean isEmpty() {
        return currentElement == 0;
    }

    public boolean isFull() {
        return currentElement == capacity;
    }

    public int size() {
        return currentElement;
    }

    public boolean enqueue(E element) {
        if (isFull()) {
            System.out.println("Queue is full");
            return false;
        } else {
            currentElement++;
            if (headIndex == -1) {
                headIndex++;
            }
            tailIndex = (tailIndex + 1) % capacity;
            if (data.size() == capacity) {
                data.set(tailIndex, element);
            } else {
                data.add(element);
            }
            return true;
        }
    }

    public E dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is null");
            return null;
        } else {
            E front = data.get(headIndex);
            currentElement--;
            if (headIndex == tailIndex) {
                headIndex = tailIndex = -1;
            } else {
                headIndex = (headIndex + 1) % capacity;
            }
            return front;
        }
    }

    public E peek() {
        return isEmpty() ? null : data.get(headIndex);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Head: " + data.get(headIndex));
            System.out.println("Element: ");
            for (int i = headIndex; i != tailIndex; i = (i + 1) % capacity) {
                System.out.print(data.get(i) + " ");
            }
            System.out.println(data.get(tailIndex));
            System.out.println("Tail: " + data.get(tailIndex));
        }
    }
}
