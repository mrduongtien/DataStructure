package heap.ex;

import heap.HeapSort;

public class Lesson1 {

    public void heapSort(int[] array) {
        int n = array.length;

        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapfity(array, n, i);
        }

        for (int i = n-1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapfity(array, i, 0);
        }
    }

    private void heapfity(int[] array, int size, int index) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < size && array[left] > array[largest]) {
            largest = left;
        }
        if (right < size && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != index) {
            int swap = array[index];
            array[index] = array[largest];
            array[largest] = swap;
            heapfity(array, size, largest);
        }
    }

    public void printHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Lesson1 hp = new Lesson1();
        int[] array = {8, 8, 9, 9, 1, 2, 3, 0};
        hp.heapSort(array);
        hp.printHeap(array);
    }
}
