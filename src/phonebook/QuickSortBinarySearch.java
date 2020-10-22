package phonebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickSortBinarySearch implements Algorithm {
    private final List<String> phoneBook;
    private final List<String> namesToSearch;
    static int phoneNumbersFound = 0;
    long timeTakenToSort;
    long timeTakenToSearch;

    QuickSortBinarySearch(List<String> phoneBook, List<String> namesToSearch) {
        this.phoneBook = new ArrayList<>(phoneBook);
        this.namesToSearch = new ArrayList<>(namesToSearch);
    }

    @Override
    public void start() {
        System.out.println("Start searching (quick sort + binary search)...");

        long startTime = System.currentTimeMillis();
        quickSort(0, phoneBook.size() - 1);
        timeTakenToSort = System.currentTimeMillis() - startTime;

        startTime = System.currentTimeMillis();
        for (String value : namesToSearch) {
            if (binarySearch(value)) {
                phoneNumbersFound++;
            }
        }
        timeTakenToSearch = System.currentTimeMillis() - startTime;
        Algorithm.printStats(phoneNumbersFound, timeTakenToSort, timeTakenToSearch, true, false);
    }

    private void quickSort(int left, int right) {
        if (left < right) {
            int pivotIndex = partition(left, right);
            quickSort(left, pivotIndex - 1);
            quickSort(pivotIndex + 1, right);
        }
    }

    private int partition(int left, int right) {
        String pivot = phoneBook.get(right);
        int partitionIndex = left;
        for (int i = left; i < right; i++) {
            if (phoneBook.get(i).compareTo(pivot) < 0) {
                Collections.swap(phoneBook, i, partitionIndex);
                partitionIndex++;
            }
        }
        Collections.swap(phoneBook, partitionIndex, right);
        return partitionIndex;
    }

    private boolean binarySearch(String target) {
        int left = 0;
        int right = phoneBook.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String directoryValue = phoneBook.get(mid);

            if (directoryValue.contains(target)) {
                return true;
            } else if (phoneBook.get(mid).compareTo(target) > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}