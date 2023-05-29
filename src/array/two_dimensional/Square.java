package array.two_dimensional;

import java.util.Scanner;

public class Square {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input length: ");
        int m = scanner.nextInt();
        String[][] square = new String[m][m];
        drawSquare(square);
        showSquare(square);
    }

    private static void showSquare(String[][] square) {
        for (var rows : square) {
            for (var cols : rows) {
                System.out.print(cols);
            }
            System.out.println();
        }
    }

    private static void drawSquare(String[][] square) {
        int n = square.length;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if ((i == 1) || (i == n) || (j == 1) || (j == n) ||
                        (i == j) || (i + j) == (n + 1)) {
                    square[i - 1][j - 1] = " * ";
                } else {
                    square[i - 1][j - 1] = "   ";
                }
            }
        }
    }

}
