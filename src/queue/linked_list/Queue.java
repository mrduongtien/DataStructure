package queue.linked_list;

import java.util.Comparator;
import java.util.Scanner;

public class Queue<E extends Integer> {
    private LinkedList<E> linkedList;
    private int counterElement;

    public Queue() {
        linkedList = new LinkedList<E>();
        counterElement = 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int max = n;
        Queue<Integer> queue = new Queue<Integer>();
        Comparator<Integer> comparator = (o1, o2) -> o2 - o1;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            queue.enqueue(x);
            queue.sort(comparator);
            while (!queue.isEmpty() && queue.peek() == max) {
                System.out.print(queue.dequeue() + " ");
                --max;
            }
            System.out.println();
        }
    }

    public void enqueue(E element) {
        counterElement++;
        linkedList.add(element);
    }

    public E dequeue() {
        if (!isEmpty()) {
            counterElement--;
        }
        return linkedList.remove();
    }

    private boolean isEmpty() {
        return counterElement == 0;
    }

    public E peek() {
        return linkedList.front();
    }

    public void sort(Comparator<Integer> comparator) {
        linkedList.sort(comparator);
    }
}
