package heap;

import java.lang.reflect.Array;

public class MyHeap<E extends Comparable<E>> {
    private final int MAX_SIZE;
    private E[] data;
    private int currentSize;

    public MyHeap(Class<E> dataType, int size) {
        MAX_SIZE = size;
        currentSize = 0;
        data = (E[]) Array.newInstance(dataType, MAX_SIZE);
    }

    public static void main(String[] args) {
        MyHeap<String> heap = new MyHeap<>(String.class, 100);
        heap.addMaxHeap("A");
        heap.addMaxHeap("B");
        heap.addMaxHeap("C");
        heap.addMaxHeap("D");
        heap.addMaxHeap("E");
        heap.addMaxHeap("F" );
        heap.addMaxHeap("G" );


        heap.showElements();
        heap.remove("G");
        heap.showElements();
        heap.remove("A");
        heap.showElements();
    }

    public boolean addMaxHeap(E e) {
        currentSize++;
        if (currentSize <= MAX_SIZE) {
            data[currentSize - 1] = e;
            siftUpMax(currentSize - 1);
            return true;
        }
        return false;
    }

    private void siftUpMax(int index) {
        var parentIndex = (index - 1) / 2;
        if (data[index].compareTo(data[parentIndex]) > 0) {
            E temp = data[index];
            data[index] = data[parentIndex];
            data[parentIndex] = temp;
            siftUpMax(parentIndex);
        }
    }

    public boolean addMinHeap(E e) {
        currentSize++;
        if (currentSize <= MAX_SIZE) {
            data[currentSize - 1] = e;
            siftUpMin(currentSize - 1);
            return true;
        }
        return false;
    }

    private void siftUpMin(int index) {
        var parentIndex = (index - 1) / 2;
        if (data[index].compareTo(data[parentIndex]) < 0) {
            E temp = data[index];
            data[index] = data[parentIndex];
            data[parentIndex] = temp;
            siftUpMin(parentIndex);
        }
    }

    public void showElements() {
        for (int i = 0; i < currentSize; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public boolean remove(E e) {
        var index = findNode(e);
        if (index >= 0) {
            data[index] = data[currentSize - 1];
            data[currentSize - 1] = null;
            currentSize--;
            siftDown(index);
            return true;
        } else {
            return false;
        }
    }

    private void siftDown(int index) {
        var largest = index;
        var left = index * 2 + 1;
        var right = index * 2 + 2;
        if (left < currentSize && (data[left].compareTo(data[largest]) > 0)) {
            largest = left;
        } else if (right < currentSize && (data[right].compareTo(data[largest]) > 0)) {
            largest = right;
        }
        if (largest != index) {
            E temp = data[index];
            data[index] = data[largest];
            data[largest] = temp;
            siftDown(index);
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
