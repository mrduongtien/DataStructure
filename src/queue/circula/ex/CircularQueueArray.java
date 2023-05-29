package queue.circula.ex;

import java.util.ArrayList;

public class CircularQueueArray<E> {
    private int currentIndex;
    private int headIndex;
    private int tailIndex;
    private int capacity;
    private ArrayList<E> data;

    public CircularQueueArray(int capacity) {
        this.currentIndex = 0;
        this.headIndex = -1;
        this.tailIndex = -1;
        this.capacity = capacity;
        data = new ArrayList<E>();
    }

    public static void main(String[] args) {
        CircularQueueArray<Integer> queue = new CircularQueueArray<>(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(9);
        queue.enqueue(8);
        queue.display();
    }

    public boolean isEmpty() {
        return currentIndex == 0;
    }

    public boolean isFull() {
        return currentIndex == capacity;
    }

    public int size() {
        return currentIndex;
    }

    public boolean enqueue(E element) {
        if (isFull()) {
            System.out.println("Queue is full");
            return false;
        } else {
            currentIndex++;
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
            System.out.println("Queue is empty");
            return null;
        } else {
            E front = data.get(headIndex);
            currentIndex--;
            if (headIndex == tailIndex) {
                headIndex = tailIndex = -1;
            } else {
                headIndex = (headIndex + 1) % capacity;
            }
            return front;
        }
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return data.get(headIndex);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Head: " + peek());
            System.out.print("Element: ");
            for (int i = headIndex; i != tailIndex; i = (i + 1) % capacity) {
                System.out.print(data.get(i) + " ");
            }
            System.out.println(data.get(tailIndex));
            System.out.println("Tail: " + data.get(tailIndex));
            System.out.println("Size: " + size());
        }
    }

}
