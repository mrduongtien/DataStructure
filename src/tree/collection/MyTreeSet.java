package tree.collection;

import java.util.Comparator;
import java.util.TreeSet;

public class MyTreeSet {
    public static void main(String[] args) {
//        TreeSet<String> treeSet = new TreeSet<String>();
        TreeSet<String> treeSet = new TreeSet<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        treeSet.add("One");
        treeSet.add("Two");
        treeSet.add("Three");
        treeSet.add("Four");
        treeSet.add("Five");
        treeSet.add("Six");
        treeSet.add("Night");
        treeSet.add("Eight");
        treeSet.add("Six");
        System.out.println("Size: " + treeSet.size());
        System.out.println("Phan tu dau tien lon hon Fivn: " + treeSet.ceiling("Fivn"));
        System.out.println("Phan tu lon nhat nho hon Fivn: " + treeSet.floor("Fivn"));

        System.out.print("Cac phan tu trong treeset: ");
        for (var e: treeSet) {
            System.out.print(e + " ");
        }
        System.out.println();

        System.out.print("Display previous: ");
        var revIterator = treeSet.descendingIterator();
        revIterator.forEachRemaining(e -> System.out.print(e + " "));
    }
}
