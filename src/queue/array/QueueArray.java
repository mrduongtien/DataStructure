package queue.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class QueueArray<E extends Integer> {
    private int currentElements;
    private ArrayList<E> data;

    public QueueArray() {
        currentElements = 0;
        data = new ArrayList<E>();
    }

    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        int max = n;
        QueueArray<Integer> queue = new QueueArray<>();
        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            queue.enqueue(x);
            queue.sort();
            while (!queue.isEmpty() && queue.peek() == max) {
                System.out.print(queue.dequeue() + " ");
                --max;
            }
            System.out.println();
        }
    }

    public void enqueue(E element) {
        data.add(element);
        currentElements++;
    }

    public E dequeue() {
        if (!isEmpty()) {
            currentElements--;
            E element = data.get(0);
            data.remove(element);
            return element;
        }
        return null;
    }

    public boolean isEmpty() {
        return currentElements == 0;
    }

    public int size() {
        return currentElements;
    }

    public E peek() {
        return isEmpty() ? null : data.get(0);
    }

    public void display() {
        for (var e : data) {
            System.out.print(e + " -> ");
        }
        System.out.println("null");
    }

    public void sort() {
        data.sort((o1, o2) -> o2.intValue() - o1.intValue());
    }
}
