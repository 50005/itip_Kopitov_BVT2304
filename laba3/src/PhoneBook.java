import java.util.LinkedList;

public class PhoneBook {
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

    private LinkedList<Entry<String, Contact>>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public PhoneBook(int capacity) {
        table = new LinkedList[capacity];
        size = 0;
    }

    private int hash(String key) {
        return Math.abs(key.hashCode() % table.length);
    }

    public void addContact(String phoneNumber, Contact contact) {
        int index = hash(phoneNumber);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        for (Entry<String, Contact> entry : table[index]) {
            if (entry.getKey().equals(phoneNumber)) {
                entry.setValue(contact);
                return;
            }
        }
        table[index].add(new Entry<>(phoneNumber, contact));
        size++;
        printTable();
    }

    public Contact getContact(String phoneNumber) {
        int index = hash(phoneNumber);
        if (table[index] != null) {
            for (Entry<String, Contact> entry : table[index]) {
                if (entry.getKey().equals(phoneNumber)) {
                    printTable();
                    return entry.getValue();
                }
            }
        }
        printTable();
        return null;
    }

    public Contact removeContact(String phoneNumber) {
        int index = hash(phoneNumber);
        if (table[index] != null) {
            for (Entry<String, Contact> entry : table[index]) {
                if (entry.getKey().equals(phoneNumber)) {
                    Contact contact = entry.getValue();
                    table[index].remove(entry);
                    size--;
                    printTable();
                    return contact;
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
        System.out.println("Текущее состояние телефонной книги:");
        for (int i = 0; i < table.length; i++) {
            System.out.print(i + ": ");
            if (table[i] != null) {
                for (Entry<String, Contact> entry : table[i]) {
                    System.out.print("[" + entry.getKey() + "=" + entry.getValue() + "] ");
                }
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------");
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook(10);
        phoneBook.addContact("1234567890", new Contact("Миша", "mix@yandex.ru", "Друг"));
        phoneBook.addContact("0987654321", new Contact("Максим", "max@yandex.ru", "Я"));

        System.out.println("достать контакт для '1234567890': " + phoneBook.getContact("1234567890"));

        phoneBook.removeContact("0987654321");
        System.out.println("Размер после удаления '0987654321': " + phoneBook.size());
        System.out.println("Телефонная книга пуста? " + phoneBook.isEmpty());
    }
}