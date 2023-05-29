package linked_list.doubly_linked_list.update;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

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

    protected Node<T> addAccount(T data) {
        Node<T> newAccount = new Node<T>(data);
        if (head == null) {
            head = tail = newAccount;
        } else {
            newAccount.prev = tail;
            tail.next = newAccount;
            tail = newAccount;
        }
        return newAccount;
    }

    protected void displayList() {
        for (var node = head; node != null; node = node.next) {
            System.out.println(node.data + " -> ");
        }
        System.out.print("null\n");
    }

    protected boolean updateBalanceOfAccount(Node target, T newData) {
        for (var currentAccount = head; currentAccount != null; currentAccount = currentAccount.next) {
            if (currentAccount.data.equals(target.data)) {
                currentAccount.data = newData;
                return true;
            }
        }
        return false;
    }

    public Node<T> getNode(T data) {
        for (var node = head; node != null; node = node.next) {
            if(node.data.equals(data)) {
                return node;
            }
        }
        return null;
    }
}