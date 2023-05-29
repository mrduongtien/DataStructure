package linked_list.doubly_linked_list.remove;

public class Remove<T> {
    private Node<T> head;
    private Node<T> tail;

    public static void main(String[] args) {
        Remove<Integer> main = new Remove<Integer>();
        main.addLast(1);
        main.addLast(2);
        main.addLast(3);
        main.addLast(4);
        main.addLast(5);
        main.display();

//        main.removeNode(1);
//        main.display();

//        main.removeNode(5);
//        main.display();

        main.removeNode(4);
        main.display();
    }

    protected void addLast(T data) {
        Node<T> node = new Node<>(data);
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
            System.out.print(node.data + " -> ");
        }
        System.out.print("null\n");
    }

    protected void removeNode(T data) {
        Node<T> targetNode = findNode(data);
        if (targetNode == head) {
            removeHead(targetNode);
        } else if (targetNode == tail) {
            removeTail(targetNode);
        } else {
            removeRemaining(targetNode);
        }
    }

    private void removeRemaining(Node<T> target) {
        target.prev.next = target.next;             // before to next
        target.prev.next.prev = target.prev;        // after to prev
        target.prev = null;
        target.next = null;
    }

    private void removeTail(Node<T> target) {
        tail = target.prev;
        target.prev = null;
        tail.next = null;
    }

    private void removeHead(Node<T> target) {
        head = target.next;
        target.prev = null;
        target.next = null;
    }

    protected Node<T> findNode(T data) {
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.data.equals(data)) {
                break;
            }
            currentNode = currentNode.next;
        }
        if (currentNode == null) {
            System.out.println("Node does not exists");
            return null;
        }
        return currentNode;
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
