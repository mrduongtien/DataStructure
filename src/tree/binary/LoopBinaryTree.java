package tree.binary;

public class LoopBinaryTree<T extends Comparable<T>> {
    private Node<T> root;

    public LoopBinaryTree() {
        this.root = null;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void add(T data) {
        this.root = insert(root, data);
    }

    private Node<T> insert(Node<T> root, T data) {
        Node<T> newNode = new Node<>(data);
        if (root == null) {
            root = newNode;
        } else if (root.data.compareTo(data) > 0) {
            root.leftNode = insert(root.leftNode, data);
        } else if (root.data.compareTo(data) < 0) {
            root.rightNode = insert(root.rightNode, data);
        }
        return root;
    }

    // display
    public void preOrder() {         // NLR
        preOrder(root);
    }

    private void preOrder(Node<T> root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.leftNode);
            preOrder(root.rightNode);
        }
    }

    public void inOrder() {     // LNR
        inOrder(root);
    }

    private void inOrder(Node<T> root) {
        if (root != null) {
            inOrder(root.leftNode);
            System.out.print(root.data + " ");
            inOrder(root.rightNode);
        }
    }

    public void postOrder() {   // LRN
        postOrder(root);
    }

    private void postOrder(Node<T> root) {
        if (root != null) {
            inOrder(root.leftNode);
            inOrder(root.rightNode);
            System.out.print(root.data + " ");
        }
    }

    public boolean search(T data) {
        return search(root, data);
    }

    private boolean search(Node<T> root, T data) {
        if (root == null) {
            return false;
        }
        if (root.data == data) {
            return true;
        } else if (root.data.compareTo(data) < 0) {
            return search(root.rightNode, data);
        } else if (root.data.compareTo(data) > 0) {
           return search(root.leftNode, data);
        }
        return false;
    }

    public static class Node<T> {
        private T data;
        private Node<T> leftNode;
        private Node<T> rightNode;

        public Node(T data) {
            this.data = data;
            this.leftNode = null;
            this.rightNode = null;
        }

        public T getData() {
            return data;
        }
    }

    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.leftNode) + countNodes(node.rightNode);
    }

    public int countLeftNodes() {
        return countLeftNodes(root);
    }

    private int countLeftNodes(Node<T> node) {
        if (node == null) {
            return 0;
        }
        if (node.leftNode == null && node.rightNode == null) {
            return  1;
        }
        return countLeftNodes(node.leftNode) + countLeftNodes(node.rightNode);
    }
}
