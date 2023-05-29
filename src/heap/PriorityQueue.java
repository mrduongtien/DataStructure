package heap;

public class PriorityQueue<E extends Comparable<E>> {
    private final int MAX_SIZE;
    private Node[] data;
    private int currentSize;

    public PriorityQueue(int size) {
        this.MAX_SIZE = size;
        this.currentSize = 0;
        this.data = new Node[MAX_SIZE];
    }

    public boolean add(E e, int priority) {
        if (!isFull()) {
            Node<E> node = new Node<E>(e, priority);
            data[currentSize] = node;
            siftUp(currentSize);
            currentSize++;
            return true;
        }
        return false;
    }

    private void siftUp(int index) {
        var parentIndex = (index - 1) / 2;
        if (data[index].getPriority() > data[parentIndex].getPriority()) {
            Node<E> temp = data[index];
            data[index] = data[parentIndex];
            data[parentIndex] = temp;
            siftUp(parentIndex);
        }
    }

    public void siftDown(int index) {
        var largest = index;
        var left = 2 * index + 1;
        var right = 2 * index + 2;
        if (left < currentSize &&
                data[left].getPriority() > data[largest].getPriority()) {
            largest = left;
        } else if (right < currentSize &&
                data[right].getPriority() > data[largest].getPriority()) {
            largest = right;
        }
        if (largest != index) {
            Node<E> temp = data[index];
            data[index] = data[largest];
            data[largest] = temp;
            siftUp(largest);
        }
    }

    private boolean isFull() {
        return currentSize == MAX_SIZE;
    }

    private boolean isEmpty() {
        return currentSize == 0;
    }

    public int size() {
        return currentSize;
    }

    public Node<E> peek() {
        return isEmpty() ? null : data[0];
    }

    public Node<E> pop() {
        if (!isEmpty()) {
            Node<E> removeNode = data[0];
            data[0] = data[currentSize - 1];
            data[currentSize - 1] = null;
            currentSize--;
            siftDown(0);
            return removeNode;
        }
        return null;
    }

    public int search(E e) {
        for (int i = 0; i < currentSize; i++) {
            if (data[i].getValue().compareTo(e) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static class Node<E extends Comparable<E>> {
        private E value;
        private int priority;

        public Node(E e, int priority) {
            this.value = e;
            this.priority = priority;
        }

        public E getValue() {
            return value;
        }

        public int getPriority() {
            return priority;
        }
    }

    public void display() {
        for (int i = 0; i < currentSize; i++) {
            System.out.print(data[i].getValue() + "(" + data[i].getPriority() + ") ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PriorityQueue<String> queue = new PriorityQueue<>(100);
        queue.add("Thuy", 5);
        queue.add("Hong", 3);
        queue.add("Huong", 2);
        queue.add("Loan", 1);
        queue.add("Hoa", 5);
        queue.add("Thanh", 4);
        queue.add("Duy", 6);
        queue.display();

        queue.pop();
        queue.display();
        queue.pop();
        queue.display();

    }
}
