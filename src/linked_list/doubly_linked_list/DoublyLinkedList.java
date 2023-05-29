package linked_list.doubly_linked_list;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    static class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private void addFirst(T data) {
        Node<T> resultNode = new Node<T>(data);
        if (head == null) {
            head = tail = resultNode;
        } else {
            resultNode.next = head;
            head.prev = resultNode;
            head = resultNode;
        }
    }

    private void addLast(T data) {
        Node<T> resultNode = new Node<T>(data);
        if (head == null) {
            head = tail = resultNode;
        } else {
            resultNode.prev = tail;
            tail.next = resultNode;
            tail = resultNode;
        }
    }

    private void addAfterElement(T data, T element) {
        if (head == null) {
            System.out.println("List is null");
        } else if (head.data.equals(element)) {
            addFirst(data);
        } else {
            Node<T> currentNode = head;
            while (currentNode != null) {
                if (currentNode.data == element) {
                    break;
                }
                currentNode = currentNode.next;
            }
            if (currentNode != null) {
                Node<T> resultNode = new Node<>(data);
                resultNode.next = currentNode.next;
                resultNode.prev = currentNode;
                currentNode.next.prev = resultNode;
                currentNode.next = resultNode;
            }
        }
    }

    private void displayList() {
        for (var node = head; node != null; node = node.next) {
            System.out.print(node.data + " -> ");
        }
        System.out.print("null\n");
    }

}
