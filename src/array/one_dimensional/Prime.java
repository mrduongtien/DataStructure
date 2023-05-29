package array.one_dimensional;

import java.util.Scanner;

public class Prime {
    private Scanner scanner;
    private int[] arrays;
    private int sizeOfArray;

    private Prime() {
        scanner = new Scanner(System.in);
    }

    private int[] inputData(){
        System.out.print("Input size of array: ");
        sizeOfArray = scanner.nextInt();
        arrays = new int[sizeOfArray];
        for (int i = 0; i < arrays.length; i++) {
            System.out.print("Input number " + (i+1) + ": ");
            arrays[i] = scanner.nextInt();
        }
        return arrays;
    }

    private boolean isPrime(int n){
        if (n < 2){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

    private void displayPrimeNumbers(){
        System.out.println("Prime Number: ");
        for (int i = 0; i < arrays.length; i++) {
            if (isPrime(arrays[i])){
                System.out.print(arrays[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        Prime b1 = new Prime();
        b1.inputData();
        b1.displayPrimeNumbers();
    }

}
