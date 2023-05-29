package array.one_dimensional;

import java.util.Scanner;

public class InsertElement {

    private Scanner scanner;
    private int n, k, x;
    private int[] arr;

    private InsertElement(){
        scanner = new Scanner(System.in);
    }

    private void inputData(){
        System.out.print("Input n (size): ");
        n = Integer.parseInt(scanner.nextLine());
        System.out.print("Input k (location): ");
        k = Integer.parseInt(scanner.nextLine());
        System.out.print("Input x (element): ");
        x = Integer.parseInt(scanner.nextLine());

        arr = new int[n+1];
        for (int i = 0; i < n; i++) {
            System.out.print("Input array[" + i + "]: ");
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
    }

    /*
     * 1. x-> k
     * 2. if k <= 0 ? insert arr[0]
     * 3. if k >= n ? insert arr[n-1]
     * */

    private void insertXIntoK(){
        inputData();
        if (k <= 0) {
            k = 0;
        } else if (k >= n){
            k = arr.length - 1;
        }
        for (int i = (arr.length - 1); i > k; i--) {
            arr[i] = arr[i-1];
        }
        arr[k] = x;
        display();
    }

    private void display() {
        System.out.print("Result: ");
        for (int elements : arr) {
            System.out.print(elements + " ");
        }
    }

    public static void main(String[] args) {
        new InsertElement().insertXIntoK();
    }
}
