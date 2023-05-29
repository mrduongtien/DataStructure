package array.one_dimensional;

import java.util.Scanner;

public class SumOfElement {
    private Scanner scanner;
    private int[] arrays;
    private int size, sum;

    private SumOfElement(){
        scanner = new Scanner(System.in);
    }

    private void inputData(){
        System.out.print("Input size of array: ");
        size = Integer.parseInt(scanner.nextLine());
        arrays = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Input arr [" + i + "]: ");
            arrays[i] = Integer.parseInt(scanner.nextLine());
        }
    }

    private void showResults(){
        inputData();
        for (int i = 0; i < size-1; i++) {
            if (arrays[i] < arrays[i + 1]) {
                sum += arrays[i + 1];
            }
        }
        System.out.println(sum);
    }


    public static void main(String[] args) {
        new SumOfElement().showResults();
    }
}