package queue.priority;

public class PriorityQueue<E> {
    private int currentSize;
    private LinkedList<E> data;

    public PriorityQueue() {
        this.currentSize = 0;
        data = new LinkedList<>();
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        priorityQueue.add(1, 3);
        priorityQueue.add(2, 1);
        priorityQueue.add(3, 2);
        priorityQueue.add(4, 9);

        System.out.println("Elements: ");
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.remove() + " ");
        }


    }

    public void add(E e, int priority) {
        currentSize++;
        data.add(e, priority);
    }

    public E peek() {
        return data.front();
    }

    public E remove() {
        if (!isEmpty()) {
            currentSize--;
            return data.remove();
        }
        return null;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public int size() {
        return currentSize;
    }
}
