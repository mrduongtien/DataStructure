package linked_list.doubly_linked_list.sort;

import java.util.Comparator;

public class Sorted<T extends Comparable<T>> {
    protected Node<T> head;
    protected Node<T> tail;

    protected void addLast(T data) {
        Node<T> target = new Node<T>(data);
        if (head == null) {
            head = tail = target;
        } else {
            target.prev = tail;
            tail.next = target;
            tail = target;
        }
    }

    protected void display() {
        for (var node = head; node != null; node = node.next) {
            System.out.println(node.data);
        }
    }

    protected void sortASC() {
        Node<T> current = head;
        Node<T> after = null;
        while (current != null) {
            after = current.next;
            while (after != null) {
                if (current.data.compareTo(after.data) > 0) {
                    T temp = current.data;
                    current.data = after.data;
                    after.data = temp;
                }
                after = after.next;
            }
            current = current.next;
        }
    }

    protected void sortDESC() {
        Node<T> current = head;
        Node<T> after = null;
        while (current != null) {
            after = current.next;
            while (after != null) {
                if (current.data.compareTo(after.data) < 0) {
                    T temp = current.data;
                    current.data = after.data;
                    after.data = temp;
                }
                after = after.next;
            }
            current = current.next;
        }
    }

    static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
}
