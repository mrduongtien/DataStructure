package hash_table;

public class Main {
    public static void main(String[] args) {
        MyHashTable<String, String> myHashTable = new MyHashTable<>(10);
        myHashTable.put("Hello", "Xin Chao");
        myHashTable.put("Bye", "Tam Biet");
        myHashTable.put("What", "Cai Gi Co");

        System.out.println("Size of hash table: " + myHashTable.size());
        System.out.println("Hash table is empty: " + myHashTable.isEmpty());

        System.out.println(myHashTable.containsKey("What") ? "Exist" : "Not found");
        var key = "Hello";
        System.out.printf("(%s - %s)\n", key, myHashTable.get(key));
        var key1 = "Bye";
        var removeValue = myHashTable.remove(key1);
        System.out.println("Remove success " + removeValue);


    }
}
