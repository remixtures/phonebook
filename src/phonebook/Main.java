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
        Algorithm linearSearch = algoFactory.getAlgorithm("LinearSearch");
        Algorithm bubbleSortJumpSearch = algoFactory.getAlgorithm("BubbleSortJumpSearch");
        Algorithm quickSortBinarySearch = algoFactory.getAlgorithm("QuickSortBinarySearch");
        Algorithm hashTableSearch = algoFactory.getAlgorithm("HashTableSearch");

        linearSearch.start();
        bubbleSortJumpSearch.start();
        quickSortBinarySearch.start();
        hashTableSearch.start();
    }
}
