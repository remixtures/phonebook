package phonebook;

import java.util.ArrayList;
import java.util.List;

public class HashTableSearch implements Algorithm {

    private final List<String> phoneBook;
    private final List<String> namesToSearch;
    int phoneNumbersFound = 0;
    long timeTakenToCreate;
    long timeTakenToSearch;

    HashTableSearch(List<String> phoneBook, List<String> namesToSearch) {
        this.phoneBook = new ArrayList<>(phoneBook);
        this.namesToSearch = new ArrayList<>(namesToSearch);
    }

    public void start() {

        PhoneBookHashTable<String> phoneBookHashTable = new PhoneBookHashTable<>(10000);

        long startTime = System.currentTimeMillis();
        for (String phoneBookEntry : phoneBook) {
            phoneBookHashTable.put(phoneBookEntry, phoneBookEntry);
        }

        timeTakenToCreate = System.currentTimeMillis() - startTime;

        startTime = System.currentTimeMillis();
        for (String name : namesToSearch) {
            if (phoneBookHashTable.get(name) != null) {
                phoneNumbersFound++;
            }
        }
        timeTakenToSearch = System.currentTimeMillis() - startTime;

        Algorithm.printStats(phoneNumbersFound, timeTakenToCreate, timeTakenToSearch);

    }
}