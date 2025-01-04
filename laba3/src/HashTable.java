import java.util.LinkedList;

public class HashTable<K, V> {
    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private LinkedList<Entry<K, V>>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        table = new LinkedList[capacity];
        size = 0;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % table.length);
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        table[index].add(new Entry<>(key, value));
        size++;
        printTable();
    }

    public V get(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    printTable();
                    return entry.getValue();
                }
            }
        }
        printTable();
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    V value = entry.getValue();
                    table[index].remove(entry);
                    size--;
                    printTable();
                    return value;
                }
            }
        }
        printTable();
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void printTable() {
        System.out.println("Текущее состояние хэш-таблицы:");
        for (int i = 0; i < table.length; i++) {
            System.out.print(i + ": ");
            if (table[i] != null) {
                for (Entry<K, V> entry : table[i]) {
                    System.out.print("[" + entry.getKey() + "=" + entry.getValue() + "] ");
                }
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------");
    }

    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>(10);
        hashTable.put("один", 1);
        hashTable.put("два", 2);
        hashTable.put("три", 3);

        System.out.println("достать 'два': " + hashTable.get("два"));

        hashTable.remove("два");
        System.out.println("Размер после удаления 'два': " + hashTable.size());
        System.out.println("Таблица пуста? " + hashTable.isEmpty());
    }
}