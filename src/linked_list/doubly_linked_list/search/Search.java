package linked_list.doubly_linked_list.search;

public class Search<T> {
    protected Node<T> head;
    protected Node<T> tail;

    static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        public T getData() {
            return data;
        }
    }
    
    protected void addLast(T data) {
        Node<T> node = new Node<T>(data);
        if (head == null) {
            head = tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
    }
    
    protected void display() {
        for (var node = head; node != null; node = node.next) {
            System.out.println(node.data);
        }
    }
    
    protected Node<T> search(T data) {
        for (var node = head; node != null; node = node.next) {
            if (node.data.equals(data)){
                return node;
            }
        }
        return null;
    }
    
}

