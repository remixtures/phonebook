package phonebook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        String phoneBookPath = "/home/miguel/Transferências/directory.txt";
        String namesToSearchPath = "/home/miguel/Transferências/find.txt";

        List<String> phoneBook = Files.readAllLines(Paths.get(phoneBookPath));
        List<String> namesToSearch = Files.readAllLines(Paths.get(namesToSearchPath));

        AlgorithmFactory algoFactory = new AlgorithmFactory(phoneBook, namesToSearch);
        Algorithm linearSearch = algoFactory.getAlgorithm("phonebook.LinearSearch");
        Algorithm bubbleSortJumpSearch = algoFactory.getAlgorithm("phonebook.BubbleSortJumpSearch");
        Algorithm quickSortBinarySearch = algoFactory.getAlgorithm("phonebook.QuickSortBinarySearch");
        Algorithm hashTableSearch = algoFactory.getAlgorithm("phonebook.HashTableSearch");

        linearSearch.start();
        bubbleSortJumpSearch.start();
        quickSortBinarySearch.start();
        hashTableSearch.start();
    }
}
