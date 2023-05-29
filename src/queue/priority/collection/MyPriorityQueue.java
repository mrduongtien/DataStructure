package queue.priority.collection;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MyPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        priorityQueue.add(1);
        priorityQueue.add(3);
        priorityQueue.add(2);

        showQueueElement(priorityQueue);
    }

    private static <T> void showQueueElement(PriorityQueue<T> priorityQueue) {
        while (!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.remove() + " ");
        }
        System.out.println();
    }
}
