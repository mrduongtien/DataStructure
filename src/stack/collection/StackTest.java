package stack.collection;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input data: ");
        String data = scanner.nextLine();
        String[] words = data.split("\\s+");

        Stack<String> stack = new Stack<>();
        for (var e: words) {
            stack.push(e);
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
