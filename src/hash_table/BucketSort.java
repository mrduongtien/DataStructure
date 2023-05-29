package hash_table;

import java.util.ArrayList;

public class BucketSort {
    public static void main(String[] args) {
        double[] arr = new double[]{8.37, 5.25, 1.25, 3.15, 0.17, 6.89, 7.54, 4.31,
                3.16, 5.78, 8.37, 0.78, 0.98, 1.48, 2.65, 3.75, 5.18, 6.24};
        System.out.println("Mảng trước khi sắp xếp: ");
        showElements(arr);
        bucketSort(arr, 15);
        System.out.println("Mảng sau khi sắp xếp: ");
        showElements(arr);
    }

    private static void showElements(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void bucketSort(double[] arr, int k) {
        if (k < 0) { // nếu n nhỏ hơn 0, kết thúc
            throw new RuntimeException("Số phân vùng không hợp lệ: " + k);
        }
        @SuppressWarnings("unchecked")
        ArrayList<Double>[] buckets = new ArrayList[k + 1];
        for (int i = 0; i <= k; i++) { // khởi tạo k danh sách rỗng
            buckets[i] = new ArrayList<>();
        }
        double max = findMax(arr); // tìm giá trị lớn nhất trong mảng
        // phân phối các phần tử vào các danh sách khác nhau
        for (int i = 0; i < arr.length; i++) {
            int bucketIndex = (int) (arr[i] * k / max);
            buckets[bucketIndex].add(arr[i]);
        }
        for (int i = 0; i <= k; i++) { // sắp xếp các danh sách
            buckets[i].sort(null); // sắp xếp tăng dần
        }
        // gộp các phần tử lại mảng gốc
        int index = 0; // khởi tạo vị trí index
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index] = buckets[i].get(j);
                index++;
            }
        }
    }

    private static double findMax(double[] arr) {
        double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
