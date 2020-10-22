package phonebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BubbleSortJumpSearch implements Algorithm {

    private final List<String> phoneBook;
    private final List<String> namesToSearch;
    long timeTakenToSearch;
    long timeTakenToSort;
    int phoneNumbersFound = 0;
    static boolean isSortingTakingTooMuchTime = false;

    BubbleSortJumpSearch(List<String> phoneBook, List<String> namesToSearch) {
        this.phoneBook = new ArrayList<>(phoneBook);
        this.namesToSearch = new ArrayList<>(namesToSearch);
    }

    @Override
    public void start() {
        bubbleSort();
        if (isSortingTakingTooMuchTime) {
            long startingTime = System.currentTimeMillis();
            new LinearSearch(phoneBook, namesToSearch).linearSearch();
            phoneNumbersFound = LinearSearch.phoneNumbersFound;
            timeTakenToSearch = System.currentTimeMillis() - startingTime;
        } else {
            jumpSearch();
        }
        Algorithm.printStats(phoneNumbersFound, timeTakenToSort, timeTakenToSearch, true, isSortingTakingTooMuchTime);
    }

    private void bubbleSort() {
        long startingTime = System.currentTimeMillis();
        System.out.println("Start searching (bubble sort + jump search)...");

        for (int i = 0; i < phoneBook.size() - 1; i++) {
            for (int j = 0; j < phoneBook.size() - i - 1; j++) {
                if (phoneBook.get(j).compareTo(phoneBook.get(j + 1)) > 0) {
                    Collections.swap(phoneBook, j, j + 1);
                    timeTakenToSort = System.currentTimeMillis() - startingTime;

                    if (timeTakenToSort > LinearSearch.timeTakenToSearch * 10) {
                        isSortingTakingTooMuchTime = true;
                        return;
                    }
                }
            }
        }
    }

    private void jumpSearch() {
        long startingTime = System.currentTimeMillis();

        int currentRight = 0;
        int prevRight = 0;
        int jumpLength = (int) Math.sqrt(phoneBook.size());
        boolean isFound = false;

        if (phoneBook.size() == 0 || namesToSearch.size() == 0) {
            timeTakenToSearch = 0;
            return;
        }

        for (String name : namesToSearch) {
            if (phoneBook.get(0).contains(name)) {
                phoneNumbersFound++;
            }
            while (currentRight < phoneBook.size() - 1) {

                currentRight = Math.min(phoneBook.size() - 1, currentRight + jumpLength);

                if (phoneBook.get(currentRight).compareTo(name) > 0) {
                    isFound = true;
                    break;
                }
                prevRight = currentRight;
            }

            if (isFound) {
                for (int j = currentRight; j > prevRight; j--) {
                    if (phoneBook.get(j).contains(name)) {
                        phoneNumbersFound++;
                    }
                }
            }
        }
        timeTakenToSearch = System.currentTimeMillis() - startingTime;
    }
}