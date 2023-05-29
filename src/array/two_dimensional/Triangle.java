package array.two_dimensional;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input height: ");
        int h = scanner.nextInt();
        var triangle = new String[h][h * 2 - 1];             // rows = h
        drawTriangle(triangle);
        showTriangle(triangle);
    }

    private static void showTriangle(String[][] triangle) {
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < 2 * triangle.length - 1; j++) {
                System.out.print(triangle[i][j]);
            }
            System.out.println();
        }
    }

    private static void drawTriangle(String[][] triangle) {
        var h = triangle.length;
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j < 2 * h; j++) {
                if (j < h - i + 1 || j > h + i - 1) {
                    triangle[i - 1][j - 1] = "   ";
                } else {
                    triangle[i - 1][j - 1] = " * ";
                }
            }
        }
    }
}
