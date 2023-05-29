package stack.exercise;

import java.lang.reflect.Array;

public class Lesson1<T> {
    private int size;
    private int capacity;
    private T[] data;

    public Lesson1() {
        this.size = 0;
        this.capacity = 10;
        this.data = (T[]) Array.newInstance(Object.class, capacity);
    }

    public Lesson1(Class<T> t) {
        this.size = 0;
        this.capacity = 10;
        this.data = (T[]) Array.newInstance(t, capacity);
    }

    public Lesson1(Class<T> t, int capacity) {
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

    public T getData() {
        return (T) data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void push(T data) {
        if (!isFull()) {
            this.data[size++] = data;
        } else {
            System.out.println("Stack is full, can't add new instance");
        }
    }

    public void pop() {
        if (!isEmpty()) {
            this.data[size--] = null;
        } else {
            System.out.println("Stack is empty, can't remove instance");
        }
    }

    public T peek() {
        if (!isEmpty()) {
            return data[size - 1];
        } else {
            return null;
        }
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.println(data[i]);
        }
    }
}
