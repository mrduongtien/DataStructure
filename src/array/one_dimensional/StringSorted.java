package array.one_dimensional;

import java.util.Arrays;
import java.util.Scanner;

public class StringSorted {
    private Scanner scanner;
    private String[] names;

    private StringSorted(){
        scanner = new Scanner(System.in);
    }

    private void inputData(){
        System.out.println("Input number: ");
        int size = Integer.parseInt(scanner.nextLine());
        names = new String[size];
        for (int i = 0; i < names.length; i++) {
            System.out.print("Input full name " + (i+1) + ": ");
            names[i] = scanner.nextLine();
        }
    }

    private void displayNameSorted(){
        Arrays.sort(names, (o1, o2) -> o1.length() - o2.length());
        System.out.println("Result: ");
        for (String elements: names) {
            System.out.println(elements);
        }
    }

    public static void main(String[] args) {
        StringSorted main = new StringSorted();
        main.inputData();
        main.displayNameSorted();
    }
}
