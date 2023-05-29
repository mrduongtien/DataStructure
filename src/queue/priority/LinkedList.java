package queue.priority;

public class LinkedList<E> {
    private Node<E> head;

    private boolean isEmpty() {
        return head == null;
    }

    public void add(E element, int priority) {
        Node<E> targetNode = new Node<>(element, priority);
        if (isEmpty()) {
            head = targetNode;
        } else if (targetNode.priority > head.priority) {
            targetNode.next = head;
            head = targetNode;
        } else {
            var beforeNode = head;
            for (var currentNode = head.next; currentNode != null; currentNode = currentNode.next) {
                if (currentNode.priority < targetNode.priority) {
                    break;
                }
                beforeNode = currentNode;
            }
            targetNode.next = beforeNode.next;
            beforeNode.next = targetNode;
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

    public E front() {
        return isEmpty() ? null : head.data;
    }

    public static class Node<E> {
        private E data;
        private int priority;
        private Node<E> next;

        public Node(E data, int priority) {
            this.data = data;
            this.priority = priority;
            this.next = null;
        }
    }
}
