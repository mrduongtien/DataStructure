package queue.circula.ex;

import java.util.Iterator;

public class LinkedList<E> implements Iterable {

    private Node<E> head;
    private Node<E> tail;


    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    public void add(E element) {
        Node<E> node = new Node<E>(element);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    private boolean isEmpty() {
        return head == null;
    }

    public E remove() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return null;
        } else {
            E current = head.data;
            head = head.next;
            if (tail != null) {
                tail.next = head;
            }
            return current;
        }
    }

    public E front() {
        return isEmpty() ? null : head.data;
    }

    public E back() {
        return isEmpty() ? null : tail.data;
    }

    public static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    public class MyIterator implements Iterator {
        private Node<E> node = head;

        @Override
        public boolean hasNext() {
            return node != tail;
        }

        @Override
        public Object next() {
            Node<E> p = node;
            node = node.next;
            return p.data;
        }
    }


}
