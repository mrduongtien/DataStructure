package tree.ex;

import java.util.Scanner;

public class Lesson2<T extends Comparable<T>> {
    private Node<T> root;

    public void add(T data) {
        root = insert(root, data);
    }

    private Node<T> insert(Node<T> root, T data) {
        Node<T> newNode = new Node<T>(data);
        if (root == null) {
            root = newNode;
        } else if (root.data.compareTo(data) > 0) {
            root.leftNode = insert(root.leftNode, data);
        } else if (root.data.compareTo(data) < 0) {
            root.rightNode = insert(root.rightNode, data);
        }
        return root;
    }

    private void addNodeUsingLoop(T data) {
        Node<T> newNode = new Node<>(data);
        if (root == null) {
            root = newNode;
        } else {
            Node<T> currentNode = root;
            while (true) {
                if (currentNode.data.compareTo(data) > 0) {
                    if (currentNode.leftNode != null) {
                        currentNode = currentNode.leftNode;
                    } else {
                        currentNode.leftNode = newNode;
                        break;
                    }
                } else {
                    if (currentNode.rightNode != null) {
                        currentNode = currentNode.rightNode;
                    } else {
                        currentNode.rightNode = newNode;
                    }
                }
            }
        }
    }

    private void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node<T> root) {
        if (root != null) {
            inOrder(root.leftNode);
            System.out.println(root.data);
            inOrder(root.rightNode);
        }
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
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input content: ");
        String content = scanner.nextLine();
        String[] elementOfContent = content.split("\\s+");

        Lesson2<String> tree = new Lesson2<>();
        for (var e : elementOfContent) {
            tree.add(e);
        }
        System.out.println("Sort: ");
        tree.inOrder();
    }

}
