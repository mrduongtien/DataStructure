package queue.priority.ex;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueueLinkedList<Integer> priorityQueue = new PriorityQueueLinkedList<Integer>();
        System.out.println("Input choice: ");
        int choice;
        do {
            System.out.println("=========== MENU ===========");
            System.out.println("1. Add new element to Queue.");
            System.out.println("2. Remove first element of Queue.");
            System.out.println("3. Select first element of Queue.");
            System.out.println("4. Number elements of Queue: .");
            System.out.println("5. Display all elements of Queue.");
            System.out.println("6. Check empty.");
            System.out.println("7. Select elements have min priority.");
            System.out.println("0. Out Program.");
            System.out.println("Please choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0 -> System.out.println("Thank you");
                case 1 -> {
                    System.out.println("Input value of element and priority: ");
                    int value = scanner.nextInt();
                    int priority = scanner.nextInt();
                    priorityQueue.add(value, priority);
                }
                case 3 -> System.out.println(priorityQueue.peek());
                case 4 -> System.out.println(priorityQueue.size());
                case 5 -> priorityQueue.display();
                case 6 -> System.out.println(priorityQueue.isEmpty());
                case 7 -> priorityQueue.minElements();
                default -> System.out.println("Check input, please");
            }
        } while (choice != 0);
    }
}
