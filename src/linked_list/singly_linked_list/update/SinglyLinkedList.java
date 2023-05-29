package linked_list.singly_linked_list.update;

public class SinglyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public void insertHead(T data) {
        Node<T> p = new Node<>(data);
        if (head == null) {
            head = tail = p;
        } else {
            p.next = head;
            head = p;
        }
    }

    public void insertTail(T data) {
        Node<T> p = new Node<>(data);
        if (head == null) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

    public void insertAlterX(T data, T x) {
        Node<T> p = new Node<>(data);
        Node<T> nodeX = head;
        while (nodeX != null) {
            if (nodeX.data == x) {
                break;
            }
            nodeX = nodeX.next;
        }
        if (nodeX != null) {
            p.next = nodeX.next;
            nodeX.next = p;
        } else {
            System.out.println("Not found");
        }
    }

    public void showList() {
        for (var node = head; node != null; node = node.next) {
            System.out.println(node.data + " -> ");
        }
        System.out.print("null\n");
    }

    static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean updateNodeData(Node target, T newData) {
        for (var node = head; node != null; node = node.next) {
            if (node.data.equals(target.data)){
                node.data = newData;
                return true;
            }
        }
        return false;
    }
}
