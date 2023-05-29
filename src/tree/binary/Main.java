package tree.binary;

public class Main {
    public static void main(String[] args) {
        LoopBinaryTree<Integer> treeSearch = new LoopBinaryTree<>();
        treeSearch.add(8);
        treeSearch.add(10);
        treeSearch.add(3);
        treeSearch.add(6);
        treeSearch.add(14);
        treeSearch.add(4);
        treeSearch.add(7);
        treeSearch.add(13);

        System.out.print("In Oder: ");
        treeSearch.inOrder();
        System.out.println("Root of this: " + treeSearch.getRoot().getData() + "\n");

        System.out.print("Post Oder: ");
        treeSearch.postOrder();
        System.out.println("Root of this: " + treeSearch.getRoot().getData() + "\n");

        System.out.print("Pre Oder: ");
        treeSearch.preOrder();
        System.out.println("Root of this: " + treeSearch.getRoot().getData() + "\n");

        System.out.println(treeSearch.search(10));
        System.out.println(treeSearch.search(100));

        System.out.println(treeSearch.countNodes());
        System.out.println(treeSearch.countLeftNodes());
    }
}
