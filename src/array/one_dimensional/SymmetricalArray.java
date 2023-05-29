package array.one_dimensional;

import java.util.Scanner;

public class SymmetricalArray {
    private Scanner scanner;
    private int size;
    private int[] arrays;
    private boolean isOpposite = true;

    private SymmetricalArray(){
        scanner = new Scanner(System.in);
    }

    private void inputData(){
        System.out.print("Input number: ");
        size = scanner.nextInt();
        arrays = new int[size];
        for (int i = 0; i < arrays.length; i++) {
            System.out.print("Input elements: ");
            arrays[i] = scanner.nextInt();
        }
    }

    private void displayResult() {
        for (int i = 0; i < (arrays.length/2); i++) {
            if (arrays[i] != arrays[(arrays.length - 1) - i]){  // select elements--
                isOpposite = false;
                break;
            } else {
                isOpposite = true;
            }
        }
        if (isOpposite){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }


    public static void main(String[] args) {
        SymmetricalArray main = new SymmetricalArray();
        main.inputData();
        main.displayResult();
    }

}
