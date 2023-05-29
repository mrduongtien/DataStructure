package heap.ex;

public class Lesson5 {

    private void heapSort(int[] array) {
        printHeap(array);
        int n = array.length;

        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
            printHeap(array);
        }
    }

    private void heapify(int[] array, int size, int index) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < size && array[left] > array[largest]){
            largest = left;
        }

        if (right < size && array[right] > array[largest]){
            largest = right;
        }
        if (largest != index) {
            int swap = array[index];
            array[index] = array[largest];
            array[largest] = swap;
            heapify(array, size, largest);
        }
    }

    private void printHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Lesson5 hs = new Lesson5();
        int[] array = {5, 2, 1, 3, 4};
        hs.heapSort(array);
    }
}
