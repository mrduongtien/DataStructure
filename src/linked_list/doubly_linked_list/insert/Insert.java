package linked_list.doubly_linked_list.insert;

public class Insert<T> {
    private Node<T> head;
    private Node<T> tail;

    public static void main(String[] args) {
        Insert<Integer> numbers = new Insert<>();
        numbers.addFirst(1);
        numbers.addFirst(2);
        numbers.addFirst(3);
        numbers.addLast(6);
        numbers.addLast(8);

        System.out.print("List data from head: ");
        numbers.displayListFromHead();

        System.out.print("List data from tail: ");
        numbers.displayListFromTail();

        System.out.print("Add alter element: ");
        numbers.addAfterElement(0, 8);
        numbers.displayListFromHead();

        System.out.print("Add node before element with value: ");
        numbers.addBeforeElement(5, 0);
        numbers.displayListFromHead();

        System.out.print("Add node before element with position: ");
        numbers.addAlterElement(9, 5);
        numbers.displayListFromHead();

        System.out.println("Middle node: " + numbers.middleNodeData());
    }

    private boolean isEmpty() {
        return head == null;
    }

    private void addFirst(T data) {
        Node<T> resultNode = new Node<T>(data);
        if (isEmpty()) {
            head = tail = resultNode;
        } else {
            resultNode.next = head;
            head.prev = resultNode;
            head = resultNode;
        }
    }

    private void addLast(T data) {
        Node<T> resultNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = resultNode;
        } else {
            resultNode.prev = tail;
            tail.next = resultNode;
            tail = resultNode;
        }
    }

    private void addAfterElement(T data, T element) {
        if (isEmpty()) {
            System.out.print("List is null");
        } else {
            Node<T> currentNode = head;
            while (currentNode != null) {
                if (currentNode.data.equals(element)) {
                    break;
                }
                currentNode = currentNode.next;
            }
            if (currentNode != null && currentNode == tail) {
                addLast(data);
            } else if (currentNode != null) {
                Node<T> resultNode = new Node<>(data);
                resultNode.next = currentNode.next;
                resultNode.prev = currentNode;
                currentNode.next.prev = resultNode;
                currentNode.next = resultNode;
            } else {
                System.out.println("Not found");
            }
        }
    }

    private void addAlterElement(T data, int position) {
        if (isEmpty()) {
            System.out.println("List is null");
        } else if (position > 0) {
            Node<T> currentNode = head;
            int count = 1;
            while (currentNode != null) {
                if (count == position) {
                    break;
                }
                count++;
                currentNode = currentNode.next;
            }
            if (currentNode != null && currentNode == tail) {
                addLast(data);
            } else if (currentNode != null) {
                Node<T> resultNode = new Node<>(data);
                resultNode.next = currentNode.next;
                resultNode.prev = currentNode;
                currentNode.next.prev = resultNode;
                currentNode.next = resultNode;
            } else {
                System.out.println("Not found");
            }
        } else {
            System.out.println("Index out of range");
        }
    }

    private void addBeforeElement(T data, T element) {
        if (isEmpty()) {
            System.out.println("List is null");
            return;
        } else if (head.data.equals(element)) {
            addFirst(data);
        } else {
            Node<T> currentNode = head;
            Node<T> beforeNode = head;
            while (currentNode != null) {
                if (currentNode.data.equals(element)) {
                    break;
                }
                beforeNode = currentNode;
                currentNode = currentNode.next;
            }
            if (currentNode != null) {
                Node<T> resultNode = new Node<>(data);
                resultNode.next = currentNode;
                resultNode.prev = beforeNode;
                currentNode.prev = resultNode;
                beforeNode.next = resultNode;
            }
        }
    }

    private void displayListFromHead() {
        for (var node = head; node != null; node = node.next) {
            System.out.print(node.data + " -> ");
        }
        System.out.print("null\n");
    }

    private void displayListFromTail() {
        for (var node = tail; node != null; node = node.prev) {
            System.out.print(node.data + " -> ");
        }
        System.out.print("null\n");
    }

    private Node<T> middleNode() {
        Node<T> currentNode = head;
        Node<T> middleNode = head;
        while ((currentNode != null) && (currentNode.next != null) && (currentNode.next.next != null)) {
            currentNode = currentNode.next.next;
            middleNode = middleNode.next;
        }
        return middleNode;
    }

    private T middleNodeData() {
        Node<T> middleNode = middleNode();
        return middleNode != null ? middleNode.data : null;
    }

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
}
