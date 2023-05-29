package tree.ex;

public class Lesson1<T extends Comparable<T>> {
    private Node<T> root;

    static class Node<T> {
        private T data;
        private Node<T> leftNode;
        private Node<T> rightNode;

        public Node(T data) {
            this.data = data;
            this.leftNode = null;
            this.rightNode = null;
        }
    }

    public Lesson1() {
        this.root = null;
    }

    private void add(T data) {
        root = insert(root, data);
    }

    private Node<T> insert(Node<T> root, T data) {
        if (root == null) {
            return new Node<T>(data);
        } else if (root.data.compareTo(data) > 0) {
            root.leftNode = insert(root.leftNode, data);
        } else if (root.data.compareTo(data) < 0) {
            root.rightNode = insert(root.rightNode, data);
        }
        return root;
    }

    public void addNodeUsingLoop(T data) {
        Node<T> newNode = new Node<T>(data);
        if (root == null) {
            root = newNode;
        } else {
            Node<T> currentNode = root;
            while (true) {
                if (currentNode.data.compareTo(data) <= 0) {
                    if (currentNode.rightNode != null) {
                        currentNode = currentNode.rightNode;
                    } else {
                        currentNode.rightNode = newNode;
                        break;
                    }
                } else {
                    if (currentNode.leftNode != null) {
                        currentNode = currentNode.leftNode;
                    } else {
                        currentNode.leftNode = newNode;
                        break;
                    }
                }
            }
        }
    }

    public void inOrder() {
        inOderRec(root);
    }

    private void inOderRec(Node<T> root) {
        if (root != null) {
            inOderRec(root.leftNode);
            System.out.println(root.data);
            inOderRec(root.rightNode);
        }
    }

    public static void main(String[] args) {
        Lesson1<Integer> tree = new Lesson1<>();
//        tree.add(6);
//        tree.add(5);
//        tree.add(4);
        tree.addNodeUsingLoop(3);
        tree.addNodeUsingLoop(2);
        tree.addNodeUsingLoop(1);
        tree.inOrder();
    }

}
