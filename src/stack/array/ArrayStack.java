package stack.array;

import java.lang.reflect.Array;

public class ArrayStack<T> {
    private int size;
    private int capacity;
    private T[] data;

    public ArrayStack() {
        this.size = 0;
        this.capacity = 10;
        this.data = (T[]) Array.newInstance(Object.class, capacity);
    }

    public ArrayStack(Class<T> t) {
        this.size = 0;
        this.capacity = 10;
        this.data = (T[]) Array.newInstance(t, capacity);
    }

    public ArrayStack(Class<T> t, int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.data = (T[]) Array.newInstance(t, capacity);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void push(T t) {
        if (!isFull()) {
            data[size++] = t;
        } else {
            System.out.println("Stack is full, can not add new element");
        }
    }

    public void pop() {
        if (!isEmpty()) {
            data[size--] = null;
        } else {
            System.out.println("Stack is empty, can not remove element");
        }
    }

    public T peek() {
        if (!isEmpty()) {
            return data[size - 1];
        } else {
            return null;
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public T[] getData() {
        return data;
    }

    public void display() {
        for (var i = 0; i < size; i++) {
            System.out.println(data[i]);
        }
    }
}
