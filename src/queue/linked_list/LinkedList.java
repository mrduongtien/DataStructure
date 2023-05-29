package queue.linked_list;

import java.util.Comparator;

public class LinkedList<E extends Integer> {
    private Node<E> head;
    private Node<E> tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void add(E element) {
        Node<E> node = new Node<E>(element, null);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public E remove() {
        if (!isEmpty()) {
            E currentNode = head.data;
            head = head.next;
            return currentNode;
        }
        return null;
    }

    public E front() {
        return isEmpty() ? null : head.data;
    }

    public void display() {
        for (var node = head; node != null; node = node.next) {
            System.out.print(node.data + " -> ");
        }
        System.out.println("null");
    }

    public void sort(Comparator<Integer> comparator) {
        for (Node<E> p = head; p != null; p = p.next) {
            for (Node<E> node = head; node != null; node = node.next) {
                if (comparator.compare(p.data, node.data) < 0) {
                    E temp = p.data;
                    p.data = node.data;
                    node.data = temp;
                }
            }
        }
    }

    static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

}
