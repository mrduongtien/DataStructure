package stack.linked_list;

public class LinkedList<T> {
    private Node<T> head;

    public void add(T data) {
        head = new Node<>(data, head);
    }

    public boolean isEmpty() {
        return head == null;
    }

    public T remove() {
        if (!isEmpty()) {
            T current = head.data;
            head = head.next;
            return current;
        }
        return null;
    }

    public T front() {
        return isEmpty() ? null : head.data;
    }

    public void display() {
        for (var node = head; node != null; node = node.next) {
            System.out.print(node.data + "->");
        }
        System.out.println();
    }

    public class Node<T> {
        T data;
        Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
}
