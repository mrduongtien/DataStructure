package tree.binary;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    public class Node<T> {
        private T data;
        private Node<T> leftNode;
        private Node<T> rightNode;

        public Node(T data) {
            this.data = data;
            this.leftNode = null;
            this.rightNode = null;
        }
    }

    public BinarySearchTree() {
        this.root = null;
    }

    public void add(T t) {
        root = insert(root, t);
    }

    private Node<T> insert(Node<T> root, T t) {
        if (root == null) {
            return new Node<>(t);
        } else if (root.data.compareTo(t) > 0) {
            root.leftNode = insert(root.leftNode, t);
        } else if (root.data.compareTo(t) < 0) {
            root.rightNode = insert(root.rightNode, t);
        }
        return root;
    }

    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node<T> root) {
        if (root != null) {
            inOrderRec(root.leftNode);
            System.out.print(root.data + " ");
            inOrderRec(root.rightNode);
        }
    }


}
