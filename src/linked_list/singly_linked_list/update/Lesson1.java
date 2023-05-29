package linked_list.singly_linked_list.update;

public class Lesson1<T> {
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

    protected void addLast(T data){
        Node<T> node = new Node<>(data);
        if (head == null){
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    protected boolean updateHeadNode(T data) {
        Node<T> resultNode = new Node<>(data);
        if (head == null){
            System.out.println("Not found data");
        } else {
            head.data = resultNode.data;
            return true;
        }
        return false;
    }

    protected int updateNode(Node target, T data) {
        int count = 0;
        for (var node = head; node != null; node = node.next) {
            if (node.data.equals(target.data)){
                node.data = data;
                count++;
            } else if (node.next == null){
                return count;
            }
        }
        return 0;
    }


    protected void displayList() {
        for (var node = head; node != null; node = node.next) {
            System.out.print(node.data + " -> ");
        }
        System.out.println("null\n");
    }


    
}
