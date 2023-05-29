package linked_list.singly_linked_list.insert;

public class Insert<T> {
    private Node<T> head;
    private Node<T> tail;

    static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private boolean isEmpty() {
        return head == null;
    }

    private void insertBeforeX(T data, T x) {
        if (isEmpty()) {
            return;
        } else if (head == x) {
            insertBeforeHead(data);
        } else {
            Node<T> currentNode = head;
            Node<T> nodeBeforeCurrentNode = head;
            while (currentNode != null) {
                if (currentNode.data == x) {
                    break;
                }
                nodeBeforeCurrentNode = currentNode;
                currentNode = currentNode.next;
            }
            if (currentNode != null) {
                Node<T> resultNote = new Node<>(data);
                resultNote.next = nodeBeforeCurrentNode.next;
                nodeBeforeCurrentNode.next = resultNote;
            }
        }
    }

    private void insertBeforeHead(T data) {
        Node<T> node = new Node<>(data);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    private void insertBehindTail(T data) {
        Node<T> node = new Node<>(data);
        if (isEmpty()){
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    private void insertNodeBehindNode(T data, int position) {
        if (isEmpty()) {
            return;
        } else if (position > 0) {
            int count = 1;
            Node<T> currentNode = head;
            while (currentNode != null) {
                if (count == position) {
                    break;
                }
                count++;
                currentNode = currentNode.next;
            }
            if (currentNode != null) {
                Node<T> resultNote = new Node<>(data);
                resultNote.next = currentNode.next;
                currentNode.next = resultNote;
            }
        } else {
            System.out.println("Index out of range");
        }
    }

    private Node<T> findMiddleNode() {
        Node<T> currentNode = head;
        Node<T> middleNode = head;
        while ((currentNode != null) && (currentNode.next != null) && (currentNode.next.next != null)){
            currentNode = currentNode.next.next;
            middleNode = middleNode.next;
        }
        return middleNode;
    }

    private T findMiddleNodeData() {
        Node<T> middleNode = findMiddleNode();
        return middleNode != null ? middleNode.data : null;
    }

    private void insertNodeBehindMiddleNode(T data){
        Node<T> middleNode = findMiddleNode();
        if (middleNode != null){
            Node<T> resultNode = new Node<>(data);
            resultNode.next = middleNode.next;
            middleNode.next = resultNode;
        }
    }

    private void displayList() {
        for (var node = head; node != null; node = node.next) {
            System.out.print(node.data + " -> ");
        }
        System.out.print("null" + "\n");
    }

    public static void main(String[] args) {
        Insert<Integer> numbers = new Insert<>();
        System.out.print("List data: ");
        numbers.insertBeforeHead(1);
        numbers.insertBeforeHead(2);
        numbers.insertBeforeHead(3);
        numbers.insertBehindTail(0);
        numbers.insertBehindTail(8);
        numbers.displayList();

        System.out.print("Insert Node before value 1: ");
        numbers.insertBeforeX(4, 1);
        numbers.displayList();

        System.out.print("Insert Node before position 2: ");
        numbers.insertNodeBehindNode(5, 2);
        numbers.displayList();

        System.out.print("Find middle node of list: " + numbers.findMiddleNodeData() + "\n");

        System.out.print("Insert node(9) behind middle node: ");
        numbers.insertNodeBehindMiddleNode(9);
        numbers.displayList();
    }

}
