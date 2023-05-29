package queue.priority.ex;

import java.util.ArrayList;
import java.util.List;

public class LinkedList<E>  {
    private int currentElement;
    private Node<E> head;

    public class Node<E> {
        private E data;
        private int priority;
        private Node<E> next;

        public Node(E data, int priority) {
            this.data = data;
            this.priority = priority;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return currentElement;
    }

    public E front() {
        return isEmpty() ? null : head.data;
    }

    public void add(E element, int priority) {
        Node<E> newNode = new Node<>(element, priority);
        if (isEmpty()) {
            head = newNode;
        } else if (head.priority < newNode.priority) {
            newNode.next = head;
            head = newNode;
        } else {
            var beforeNode = head;
            for (var currentNode = head.next; currentNode != null; currentNode = currentNode.next) {
                if (currentNode.priority < newNode.priority) {
                    break;
                }
                beforeNode = currentNode;
            }
            newNode.next = beforeNode.next;
            beforeNode.next = newNode;
        }
    }

    public E remove() {
        if (!isEmpty()) {
            E current = head.data;
            head = head.next;
            return current;
        }
        return null;
    }

    public List<E> toList() {
        List<E> list = new ArrayList<>();
        Node<E> currentNode = head;
        while (currentNode != null) {
            list.add(currentNode.data);
            currentNode = currentNode.next;
        }
        return list;
    }

    public void minPriorityElements() {
        if (isEmpty()) {
            System.out.println("Queue is null");
        } else {
            int minPriority = head.priority;
            for (var currentNode = head.next; currentNode != null; currentNode = currentNode.next) {
                if (currentNode.priority < minPriority) {
                    minPriority = currentNode.priority;
                }
            }
            for (var currentNode = head.next; currentNode != null; currentNode = currentNode.next) {
                if (currentNode.priority == minPriority) {
                    System.out.print(currentNode.data + " ");
                }
            }
            System.out.println();
        }
    }

}
