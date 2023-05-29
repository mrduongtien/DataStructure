package queue.circula.ex;

import java.util.Iterator;

public class CircularQueueLinkedList<E> {
    private int currentElement;
    private LinkedList<E> data;

    public CircularQueueLinkedList() {
        currentElement = 0;
        data = new LinkedList<>();
    }

    public static void main(String[] args) {
        CircularQueueLinkedList<Integer> queue = new CircularQueueLinkedList<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.dequeue();
        queue.dequeue();
        queue.display();
    }

    public boolean isEmpty() {
        return currentElement == 0;
    }

    public int size() {
        return currentElement;
    }

    public boolean enqueue(E element) {
        currentElement++;
        data.add(element);
        return true;
    }

    public E dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is null");
            return null;
        } else {
            currentElement--;
            return data.remove();
        }
    }

    public E peek() {
        if (isEmpty()) {
            System.out.println("Queue is null");
            return null;
        }
        return data.front();
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is null");
        } else {
            System.out.print("Elements: ");
            for (var e : data) {
                System.out.print(e + " ");
            }
            System.out.println(data.back());
        }
    }

}