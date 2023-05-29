package array.recursive;

import java.util.Scanner;

public class Fibonacci {
    private static final int MAX = 90;
    private static long[] fibo = new long[MAX+1];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input n: ");
        int n = scanner.nextInt();
        long result = Fibonacci(n);
        System.out.printf("The %dth fibonacci is %d", n, result);
    }

    // Top-Down
    private static long Fibonacci(int n) {
        if (n < 2){
            return fibo[n] = n;
        }
        if (fibo[n] == 0){      // khoi tao mang mac dinh bang 0
            fibo[n] = Fibonacci(n-1) + Fibonacci(n-2);
        }
        return fibo[n];
    }
}
