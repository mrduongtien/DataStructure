package linked_list.singly_linked_list.insert;

public class Additional<T> {
    private Node<T> head;

    static class Node<T> {
        private T data;
        private Node<T> next;

        public Node (T data) {
            this.data = data;
            this.next = null;
        }
    }

    private boolean isEmpty(){
        return head == null;
    }

    private void addLastList(T data) {
        Node<T> resultNode = new Node<>(data);
        if (isEmpty()){
            head = resultNode;
        } else {
            Node<T> currentNode = head;
            while (currentNode.next != null) {      // The last element in linked list is always null
                currentNode = currentNode.next;
            }
            resultNode.next = null;
            currentNode.next = resultNode;
        }
    }

    private void addFirstList(T data){
        Node<T> resultNode = new Node<>(data);
        if (isEmpty()){
            head = resultNode;
        } else {
            resultNode.next = head;
            head = resultNode;
        }
    }

    private void addAfterElement(T data, T element){
        Node<T> resultNode = new Node<>(data);
        if (isEmpty()){
            head = resultNode;
        } else {
            Node<T> currentNode = head;
            while (currentNode.data != element){
                currentNode = currentNode.next;
            }
            resultNode.next = currentNode.next;
            currentNode.next = resultNode;
        }
    }

    private void addBeforeElement(T data, T element){
        if (isEmpty()){
            System.out.println("List is null");
        } else if (head.data.equals(element)){
            addFirstList(data);
        } else {
            Node<T> currentNode = head;
            Node<T> beforeCurrentNode = head;
            while (currentNode != null){
                if (currentNode.data == element){
                    break;
                }
                beforeCurrentNode = currentNode;
                currentNode = currentNode.next;
            }
            if (currentNode != null){
                Node<T> resultNode = new Node<>(data);
                resultNode.next = beforeCurrentNode.next;
                beforeCurrentNode.next = resultNode;
            }
        }
    }

    private void addAfterElement(T data, int position){
        if (isEmpty()) {
            System.out.println("List is null");
            return;
        } else if (position > 0) {
            int count = 1;
            Node<T> currentNode = head;
            while(currentNode != null){
                if (count == position){
                    break;
                }
                count++;
                currentNode = currentNode.next;
            }
            if (currentNode != null){
                Node<T> resultNode = new Node<>(data);
                resultNode.next = currentNode.next;
                currentNode.next = resultNode;
            }
        } else {
            System.out.println("Index out of range");
        }
    }

    private Node<T> findMiddleElement() {
        Node<T> middleNode = head;
        Node<T> currentNode = head;
        while ((currentNode != null) && (currentNode.next != null) && (currentNode.next.next != null)) {
            currentNode = currentNode.next.next;
            middleNode = middleNode.next;
        }
        return middleNode;
    }

    private T findMiddleElementData() {
        Node<T> middleNode = findMiddleElement();
        return middleNode != null ? middleNode.data : null;
    }

    private void displayList(){
        for (var node = head; node != null; node = node.next){
            System.out.print(node.data + " -> ");
        }
        System.out.print("null\n");
    }

    public static void main(String[] args) {
        Additional<String> names = new Additional<>();
        System.out.print("List data: ");
        names.addLastList("Duong");
        names.addLastList("Dinh");
        names.addLastList("Tien");
        names.addFirstList("Ong");
        names.displayList();

        System.out.print("Add node to alter element with data: ");
        names.addAfterElement("Developer", "Tien");
        names.displayList();

        System.out.print("Add node to alter element with positon: ");
        names.addAfterElement("Pham", 2);
        names.displayList();

        System.out.print("Add node to before element with data: ");
        names.addBeforeElement("is", "Developer");
        names.displayList();

        System.out.println("Middle element: " + names.findMiddleElementData());
    }
}
