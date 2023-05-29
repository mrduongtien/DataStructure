package heap;

import java.lang.reflect.Array;

public class RemoveHeap<E extends Comparable<E>> {
    private final int MAX_SIZE;
    private E[] data;
    private int currentSize;

    public RemoveHeap(Class<E> dataType, int size) {
        this.MAX_SIZE = size;
        this.currentSize = 0;
        this.data = (E[]) Array.newInstance(dataType, MAX_SIZE);
    }

    public void display() {
        for (int i = 0; i < currentSize; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public boolean addToMaxHead(E e) {
        currentSize++;
        if (currentSize <= MAX_SIZE) {
            data[currentSize - 1] = e;
            swapMaxHead(currentSize - 1);
            return true;
        }
        return false;
    }

    private void swapMaxHead(int index) {
        var parentIndex = (index - 1) / 2;
        if (data[index].compareTo(data[parentIndex]) > 0) {
            E temp = data[index];
            data[index] = data[parentIndex];
            data[parentIndex] = temp;
            swapMaxHead(parentIndex);
        }
    }

    public boolean remove(E e) {
        var index = findIndex(e);
        if (index >= 0) {
            data[index] = data[currentSize - 1];
            data[currentSize - 1] = null;
            currentSize--;
            swapElement(index);
            return true;
        }
        return false;
    }

    private void swapElement(int index) {
        var largest = index;
        var left = 2 * index + 1;
        var right = 2 * index + 2;
        if (left < currentSize && (data[left].compareTo(data[largest]) > 0)) {
            largest = left;
        } else if (right < currentSize && (data[right].compareTo(data[largest]) > 0)) {
            largest = right;
        }
        if (largest != index) {
            E temp = data[index];
            data[index] = data[largest];
            data[largest] = temp;
            swapElement(index);
        }
    }

    

    private int findIndex(E e) {
        for (int i = 0; i < currentSize; i++) {
            if (data[i].compareTo(e) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RemoveHeap<String> heap = new RemoveHeap<>(String.class, 100);
        heap.addToMaxHead("A");
        heap.addToMaxHead("B");
        heap.addToMaxHead("C");
        heap.addToMaxHead("D");
        heap.addToMaxHead("E");
        heap.addToMaxHead("F" );
        heap.addToMaxHead("G" );


        heap.display();
        heap.remove("G");
        heap.display();
        heap.remove("A");
        heap.display();
    }
}
