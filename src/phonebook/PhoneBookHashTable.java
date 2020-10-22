package phonebook;

public class PhoneBookHashTable<T> {

    private int size;
    private PhoneBookEntry[] table;

    public PhoneBookHashTable(int size) {
        this.size = size;
        table = new PhoneBookEntry[size];
    }

    public boolean put(String key, T value) {
        int index = findKey(key);

        if (index == -1) {
            return false;
        }

        table[index] = new PhoneBookEntry(key, value);
        return true;
    }

    public T get(String key) {
        int index = findKey(key);
        if (index == -1 || table[index] == null) {
            return null;
        }

        return (T) table[index].getValue();
    }

    private int findKey(String keyString) {
        int key = createKeyFromName(keyString);
        int hash = key % size;

        while (table[hash] != null && createKeyFromName(table[hash].getKey()) != key) {
            hash = (hash + 1) % size;

            if (hash == key % size) {
                return -1;
            }
        }

        return hash;
    }

    private int createKeyFromName(String keyString) {
        int sum = 0;
        char[] key = keyString.toCharArray();
        for (char c : key) {
            sum += (int) c;
        }
        sum += key[0] * key[key.length - 1];
        return sum;
    }
}