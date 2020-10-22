package phonebook;

import java.util.List;

public class AlgorithmFactory {

    private final List<String> phoneBook;
    private final List<String> namesToSearch;

    AlgorithmFactory(List<String> phoneBook, List<String> namesToSearch) {
        this.phoneBook = phoneBook;
        this.namesToSearch = namesToSearch;
    }

    public Algorithm getAlgorithm(String algorithmType) {
        switch (algorithmType) {
            case "phonebook.LinearSearch":
                return new LinearSearch(phoneBook, namesToSearch);
            case "phonebook.BubbleSortJumpSearch":
                return new BubbleSortJumpSearch(phoneBook, namesToSearch);
            case "phonebook.QuickSortBinarySearch":
                return new QuickSortBinarySearch(phoneBook, namesToSearch);
            case "phonebook.HashTableSearch":
                return new HashTableSearch(phoneBook, namesToSearch);
            default:
                return null;
        }
    }
}
