package heap.ex;

public class Lesson3 {

    private void heapSort(String[] array) {
        int n = array.length;

        for (int i = (n / 2) - 1; i >= 0; i --) {
            heapify(array, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            String temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }

    private void heapify(String[] array, int size, int index) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < size && array[left].compareTo(array[largest]) > 0) {
            largest = left;
        }
        if (right < size && array[right].compareTo(array[largest]) > 0) {
            largest = right;
        }
        if (largest != index) {
            String swap = array[index];
            array[index] = array[largest];
            array[largest] = swap;
            heapify(array, size, largest);
        }
    }

    public void printHeap(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Lesson3 hs = new Lesson3();
        String tes1 = "this is my hand and you can take if you want";
        String[] array = tes1.split("\\s+");
        hs.heapSort(array);
        hs.printHeap(array);
    }
}
