package phonebook;

import java.util.ArrayList;
import java.util.List;

public class LinearSearch implements Algorithm {

    private final List<String> phoneBook;
    private final List<String> namesToSearch;
    static int phoneNumbersFound = 0;
    static long timeTakenToSearch;

    LinearSearch(List<String> phoneBook, List<String> namesToSearch) {
        this.phoneBook = new ArrayList<>(phoneBook);
        this.namesToSearch = new ArrayList<>(namesToSearch);
    }

    @Override
    public void start() {
        System.out.println("Start searching (linear search)...");
        linearSearch();
        Algorithm.printStats(phoneNumbersFound, 0, timeTakenToSearch, false, false);
    }

    protected void linearSearch() {
        phoneNumbersFound = 0;

        long startingTime = System.currentTimeMillis();

        for (String name : namesToSearch) {
            for (String phoneBookEntry : phoneBook) {
                if (phoneBookEntry.contains(name)) {
                    phoneNumbersFound++;
                    break;
                }
            }
        }

        timeTakenToSearch = System.currentTimeMillis() - startingTime;
    }
}