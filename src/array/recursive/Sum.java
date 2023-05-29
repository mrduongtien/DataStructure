package array.recursive;

import java.util.Scanner;

public class Sum {
    // S = 1 + 2 + ... + n;

    // fibonaci n
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input n: ");
        int n = scanner.nextInt();
        int s = sum(n);
        System.out.printf("S(1 -> %d) = %d\n", n, s);

        long fibonacci = fibonacciN(n);
        System.out.printf("The %dth fibonacci number is %d", n,  fibonacci);
    }

    private static int sum(int n) {
        if (n == 1){
            return n;
        } else {
            return n + sum(n - 1);
        }
    }

    //
    private static long fibonacciN(int n){
        if (n < 2){
            return n;
        } else {
            return fibonacciN(n - 1) + fibonacciN(n - 2);
        }
    }
}
