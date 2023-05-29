package stack.exercise;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Lesson2<T> {
    private int size;
    private int capacity;
    private T[] data;

    public Lesson2() {
        this.size = 0;
        this.capacity = 10;
        this.data = (T[]) Array.newInstance(Object.class, capacity);
    }

    public Lesson2(Class<T> t) {
        this.size = 0;
        this.capacity = 10;
        this.data = (T[]) Array.newInstance(t, capacity);
    }

    public Lesson2(Class<T> t, int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.data = (T[]) Array.newInstance(t, capacity);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public T[] getData() {
        return data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void push(T t) {
        if (!isFull()) {
            this.data[size++] = t;
        } else {
            System.out.println("Stack is full, can't add new element");
        }
    }

    public void pop() {
        if (!isEmpty()) {
            this.data[size--] = null;
        } else {
            System.out.println("Stack is empty, can't remove element");
        }
    }

    public T peek() {
        if (!isEmpty()) {
            return this.data[size - 1];
        }
        return null;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
    }

    public void displayReverse() {
        for (int i = size - 1 ; i >= 0; i--) {
            System.out.print(data[i] + " ");
        }
    }

    public static void reverseWord(Lesson2<String> stack, String[] element) {
        for (var e: element) {
            stack.push(e);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lesson2<String> stringStack = new Lesson2<>(String.class, 10);
        System.out.print("Input string: ");

        String str = scanner.nextLine();
        String[] element = str.split("\s+");
        reverseWord(stringStack, element);
        stringStack.displayReverse();
    }
}
