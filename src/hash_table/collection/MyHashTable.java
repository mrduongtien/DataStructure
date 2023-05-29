package hash_table.collection;

import java.util.Hashtable;

public class MyHashTable {
    public static void main(String[] args) {
        Hashtable<String, Integer> hashtable = new Hashtable();
        hashtable.put("One", 1);
        hashtable.put("Two", 2);
        hashtable.put("Three", 3);
        hashtable.put("Four", 4);
        hashtable.put("Five", 5);
        hashtable.put("Six", 6);
        hashtable.put("Seven", 7);

        System.out.println("Key list: " + hashtable.keySet());
        System.out.println("Value list: " + hashtable.values());
        System.out.println("Key-Value: " + hashtable.entrySet());
        System.out.println("Foreach: -> ");
        hashtable.forEach((key, value) -> System.out.printf("%s-%d ", key, value));

        System.out.println();
        hashtable.remove("One");
        hashtable.forEach((key, value) -> System.out.printf("%s-%d ", key, value));
    }
}
