package hash_table;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MyHashTable<K, V> {
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private int count;
    private int threshold;
    private float loadFactor;
    private int modCount = 0;   // changes
    private Entry<?, ?>[] table;

    public MyHashTable(int capacity, float loadFactor) {
        if (capacity < 0) throw new IllegalArgumentException("Illegal capacity: " + capacity);
        if (loadFactor <= 0) throw new IllegalArgumentException("Illegal loadFactor: " + loadFactor);
        if (capacity == 0) {
            capacity = 1;
        }
        this.loadFactor = loadFactor;
        this.table = new Entry<?, ?>[capacity];
        this.threshold = (int) Math.min(capacity * loadFactor, MAX_ARRAY_SIZE + 1);
    }

    public MyHashTable(int capacity) {
        this(capacity, 0.75f);
    }

    public MyHashTable() {
        this(11, 0.75f);
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private boolean contains(Object value) {
        if (value == null) throw new NullPointerException("value is null");
        Entry<?, ?> tab[] = table;
        for (int i = tab.length - 1; i >= 0; i--) {
            for (var e = tab[i]; e != null; e = e.next) {
                if (e.value.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsKey(Object key) {
        Entry<?, ?> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7ffffff) % tab.length;
        for (var e = tab[index]; e != null; e = e.next) {
            if ((e.hash == hash) && (e.key.equals(key))) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Object value) {
        return contains(value);
    }

    public V get(Object key) {
        Entry<?, ?> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7ffffff) % tab.length;
        for (var e = tab[index]; e != null; e = e.next) {
            if ((e.hash == hash) && (e.key.equals(key))) {
                return (V) e.value;
            }
        }
        return null;
    }

    public V put(K key, V value) {
        if (value == null) throw new NullPointerException("value is null");
        Entry<?, ?> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7ffffff) % tab.length;
        var entry = (Entry<K, V>) tab[index];
        for (; entry != null; entry = entry.next) {
            if (entry.hash == hash && entry.equals(key)) {
                V old = entry.value;
                entry.value = value;
                return old;
            }
        }
        addEntry(hash, key, value, index);
        return null;
    }

    private void addEntry(int hash, K key, V value, int index) {
        Entry<?, ?> tab[] = table;
        if (count >= threshold) {
            rehash();
            tab = table;
            hash = key.hashCode();
            index = (hash & 0x7ffffff) % tab.length;
        }
        var e = (Entry<K, V>) tab[index];
        tab[index] = new Entry<>(hash, key, value, e);
        count++;
        modCount++;
    }

    protected void rehash() {
        int oldCapacity = table.length;
        Entry<?, ?>[] oldMap = table;
        // nhân đôi kích thước bảng băm, sử dụng phép dịch trái bít
        int newCapacity = (oldCapacity << 1) + 1;
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            if (oldCapacity == MAX_ARRAY_SIZE)
                return;
            newCapacity = MAX_ARRAY_SIZE;
        }
        Entry<?, ?>[] newMap = new Entry<?, ?>[newCapacity];
        modCount++;
        // tính toán lại ngưỡng mới
        threshold = (int) Math.min(newCapacity * loadFactor, MAX_ARRAY_SIZE + 1);
        table = newMap;

        for (int i = oldCapacity; i > 0; i--) {
            // cập nhật tất cả các phần tử trong danh sách các phần tử tại vị trí đang xét
            for (Entry<K, V> old = (Entry<K, V>) oldMap[i]; old != null; ) {
                Entry<K, V> e = old;
                old = old.next;

                int index = (e.hash & 0x7FFFFFFF) % newCapacity;
                e.next = (Entry<K, V>) newMap[index];
                newMap[index] = e;
            }
        }
    }

    public V remove(Object key) {
        if (key == null) {
            throw new NullPointerException("key is null");
        }
        Entry<?, ?> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7fffffff) % tab.length;
        var e = (Entry<K, V>) tab[index];
        for (Entry<K, V> prev = null; e != null; e = e.next) {
            if (e.hash == hash && e.key.equals(key)) {
                if (prev == null) {
                    tab[index] = e.next;
                } else {
                    prev.next = e.next;
                }
                modCount++;
                count--;
                V oldValue = e.value;
                e.value = null;
                return oldValue;
            }
            prev = e;
        }
        return null;
    }

    public V replace(K key, V newValue) {
        Objects.requireNonNull(newValue);
        var tab = table;
        var hash = key.hashCode();
        var index = (hash & 0x7FFFFFFF) % tab.length;
        var e = (Entry<K, V>) tab[index];
        for (; e != null; e = e.next) {
            if ((e.hash == hash) && e.key.equals(key)) {
                var oldValue = e.value;
                e.value = newValue;
                return oldValue;
            }
        }
        return null;
    }

    public List<K> keys() {
        if (count > 0) {
            List<K> keyList = new ArrayList<>();
            for (var e : table) {
                var current = e;
                while (current != null) {
                    keyList.add((K) current.getKey());
                    current = current.next;
                }
            }
            return keyList;
        }
        return null;
    }

    public List<V> values() {
        if (count > 0) {
            List<V> valueList = new ArrayList<>();
            for (var e : table) {
                var current = e;
                while (current != null) {
                    valueList.add((V) current.getValue());
                    current = current.next;
                }
            }
            return valueList;
        }
        return null;
    }

    public List<Entry<K, V>> elements() {
        if (count > 0) {
            List<Entry<K, V>> entries = new ArrayList<>();
            for (var e : table) {
                var current = e;
                while (current != null) {
                    entries.add((Entry<K, V>) current);
                    current = current.next;
                }
            }
            return entries;
        }
        return null;
    }

    private static class Entry<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        V value;
        Entry<K, V> next;

        protected Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.value = value;
            this.key = key;
            this.next = next;
        }

        protected Entry<K, V> clone() {
            return new Entry<K, V>(hash, key, value, next);
        }


        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            if (value == null) {
                throw new NullPointerException("value is null");
            }
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) return false;
            Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
            return (key == null ? e.getKey() == null : e.equals(e.getKey())) &&
                    (value == null ? e.getValue() == null : e.equals(e.getValue()));
        }

        @Override
        public int hashCode() {
            return hash ^ Objects.hash(value);
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "hash=" + hash +
                    ", key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

}
