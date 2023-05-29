package heap.ex;

public class Lesson4 {

    private void heapSort(String[] array) {
        int n = array.length;

        for (int i = (n / 2) - 1; i >= 0; i--){
            heapify(array, n, i);
        }

        for (int i = n - 1; i > 0; i --) {
            String temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }

    private void heapify(String[] array, int size, int index) {
        int largrst = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < size && array[left].compareTo(array[largrst]) < 0) {
            largrst = left;
        }
        if (right < size && array[right].compareTo(array[largrst]) < 0) {
            largrst = right;
        }
        if (largrst != index) {
            String swap = array[index];
            array[index] = array[largrst];
            array[largrst] = swap;
            heapify(array, size, largrst);
        }
    }

    public void printHeap(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Lesson4 hs = new Lesson4();
        String test = "this is my hand and you can take if you want";
        String[] text = test.split("\\s+");
        hs.heapSort(text);
        hs.printHeap(text);
    }
}
