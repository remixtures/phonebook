package phonebook;

public class PhoneBookEntry<T> {
    private final String key;
    private final T value;

    public PhoneBookEntry(String key, T value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }
}
