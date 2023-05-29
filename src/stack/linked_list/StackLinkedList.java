package stack.linked_list;

import stack.exercise.Student;

public class StackLinkedList<T> {
    private LinkedList<T> top;
    private int counter;

    public StackLinkedList() {
        this.top = new LinkedList<T>();
        this.counter = 0;
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public T peek() {
        return top.front();
    }

    public void push(T element) {
        top.add(element);
        counter++;
    }

    public T pop() {
        if (!isEmpty()) {
            counter--;
        }
        return top.remove();
    }

    public int size() {
        return counter;
    }

    public void display() {
        while (!isEmpty()) {
            System.out.print(pop() + " -> ");
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        StackLinkedList<Integer> stack = new StackLinkedList<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.size());

        stack.pop();
        stack.pop();
        System.out.println(stack.size());

        stack.display();
    }
}
