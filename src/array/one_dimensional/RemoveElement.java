package array.one_dimensional;

import java.util.Scanner;

public class RemoveElement {
    private Scanner scanner;
    private int[] array;
    private int size, x;

    private RemoveElement(){
        scanner = new Scanner(System.in);
    }

    private void inputData(){
        System.out.print("Input size of array: ");
        size = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter value of element to be deleted: ");
        x = Integer.parseInt(scanner.nextLine());
        array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Input arr [" + i + "]: ");
            array[i] = Integer.parseInt(scanner.nextLine());
        }
    }

    private void showResults(){
        inputData();
        for (int i = 0; i < size; i++) {
            if (array[i] == x){
                for (int j = i; j < size-1; j++) {
                    array[j] = array[j+1];
                }
                size--;
                i--;
            }
        }
        display();
    }

    private void display() {
        System.out.print("Result: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        new RemoveElement().showResults();
    }
}

