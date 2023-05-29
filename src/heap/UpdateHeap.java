package heap;

import java.lang.reflect.Array;

public class UpdateHeap<E extends Comparable<E>> {
    private final int MAX_SIZE;
    private int currentSize;
    private E[] data;

    public UpdateHeap(Class<E> dataType, int size) {
        this.currentSize = 0;
        this.MAX_SIZE = size;
        this.data = (E[]) Array.newInstance(dataType, MAX_SIZE);
    }

    public static void main(String[] args) {
        UpdateHeap<String> heap = new UpdateHeap<>(String.class, 100);
        heap.add("A");
        heap.add("B");
        heap.add("C");
        heap.add("D");
        heap.add("E");

        heap.display();

        heap.update("A", "T");
        heap.display();
    }

    public void display() {
        for (int i = 0; i < currentSize; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public boolean add(E e) {
        currentSize++;
        if (currentSize <= MAX_SIZE) {
            data[currentSize - 1] = e;
            siftUp(currentSize - 1);
            return true;
        }
        return false;
    }

    private void siftUp(int index) {
        var parentIndex = (index - 1) / 2;
        if (data[index].compareTo(data[parentIndex]) > 0) {
            E temp = data[index];
            data[index] = data[parentIndex];
            data[parentIndex] = temp;
            siftUp(parentIndex);
        }
    }

    private boolean update(E oldNode, E newNode) {
        var index = findNode(oldNode);
        if (index >= 0) {
            data[index] = newNode;
            var parentIndex = (index - 1) / 2;
            if (data[parentIndex].compareTo(data[index]) < 0) {
                siftUp(index);
            } else {
                siftDown(index);
            }
            return true;
        }
        return false;
    }

    private void siftDown(int index) {
        var largest = index;
        var left = 2 * index + 1;
        var right = 2 * index + 2;
        if (left < currentSize && data[left].compareTo(data[largest]) > 0) {
            largest = left;
        }
        if (right < currentSize && data[right].compareTo(data[largest]) > 0) {
            largest = right;
        }
        if (largest != index) {
            E tmp = data[index];
            data[index] = data[largest];
            data[largest] = tmp;
            siftDown(largest);
        }
    }

    private int findNode(E e) {
        for (int i = 0; i < currentSize; i++) {
            if (data[i].compareTo(e) == 0) {
                return i;
            }
        }
        return -1;
    }

}
