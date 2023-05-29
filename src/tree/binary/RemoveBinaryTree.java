package tree.binary;

public class RemoveBinaryTree<T extends Comparable<T>> {
    private Node<T> root;

    public RemoveBinaryTree() {
        this.root = null;
    }

    public void add(T data) {
        root = insert(root, data);
    }

    private Node<T> insert(Node<T> root, T data) {
        if (root == null) {
            root = new Node<>(data);
        } else if (root.data.compareTo(data) < 0) {
            root.rightNode = insert(root.rightNode, data);
        } else if (root.data.compareTo(data) > 0) {
            root.leftNode = insert(root.leftNode, data);
        }
        return root;
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node<T> root) {
        if (root != null) {
            inOrder(root.leftNode);
            System.out.print(root.data + " ");
            inOrder(root.rightNode);
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

    public void remove(T data) {
        root = remove(root, data);
    }

    private Node<T> remove(Node<T> root, T data) {
        if (root == null) {
            return null;
        }
        if (data.compareTo(root.data) < 0) {
            root.leftNode = remove(root.leftNode, data);
        } else if (data.compareTo(root.data) > 0) {
            root.rightNode = remove(root.rightNode, data);
        } else {
            if (root.leftNode == null) {
                root = root.rightNode;
            } else if (root.rightNode == null) {
                root = root.leftNode;
            } else {
                root.data = findMinNode(root.rightNode, data);
                root.rightNode = remove(root.rightNode, root.data);
            }
        }
        return root;
    }

    private T findMinNode(Node<T> root, T data) {
        while (root.leftNode != null) {
            root = root.leftNode;
        }
        return root.data;
    }

    public class Node<T> {
        private T data;
        private Node<T> leftNode;
        private Node<T> rightNode;

        public Node(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        RemoveBinaryTree<Integer> tree = new RemoveBinaryTree<>();
        tree.add(40);
        tree.add(20);
        tree.add(60);
        tree.add(10);
        tree.add(30);
        tree.add(70);
        tree.add(99);
        tree.add(50);
        tree.inOrder();
        tree.remove(40);
        System.out.println();
        tree.inOrder();
        System.out.println();
        tree.remove(20);
        tree.inOrder();
        System.out.println();
        tree.remove(70);
        tree.inOrder();
    }


}
