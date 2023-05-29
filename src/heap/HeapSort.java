package heap;

public class HeapSort {

    /* B1: Build Heap (max or min) => sorting
     *   1.1: root = (n-1) / 2
     *   1.2: last parent node (= n / 2) - 1;
     *   1.3: left node: 2n + 1
     *   1.4: right node: 2n + 2
     * B2: Swap root vs last_node_la, size--, loop B1*/

    public void heapSort(int[] array) {
        int n = array.length;

        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapifyHeap(array, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            // move current node to end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapifyHeap(array, i, 0);
        }

    }

    private void heapifyHeap(int[] array, int size, int index) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        // if left child is larger than root
        if (left < size && array[left] > array[largest]) {
            largest = left;
        }
        // if right child is larger than roor
        if (right < size && array[right] > array[largest]) {
            largest = right;
        }
        // if largest is not root
        if (largest != index) {
            int swap = array[index];
            array[index] = array[largest];
            array[largest] = swap;
            heapifyHeap(array, size, largest);
        }
    }

    public void printHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        HeapSort hp = new HeapSort();
        int[] array = { 12, 11, 13, 5, 6, 7 };
        hp.heapSort(array);
        hp.printHeap(array);
    }

}
