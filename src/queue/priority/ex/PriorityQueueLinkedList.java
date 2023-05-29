package queue.priority.ex;

public class PriorityQueueLinkedList<E> {
    private int currentSize;
    private LinkedList<E> data;

    public PriorityQueueLinkedList() {
        this.currentSize = 0;
        this.data = new LinkedList<E>();
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public E peek() {
        return isEmpty() ? null : data.front();
    }

    public void add(E element, int priority) {
        currentSize++;
        data.add(element, priority);
    }

    public E remove() {
        if (!isEmpty()) {
            currentSize--;
            data.remove();
        }
        return null;
    }

    public int size() {
        return currentSize;
    }

    public void display() {
        for (var e: data.toList()) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public void minElements() {
        data.minPriorityElements();
    }
}
