package phonebook;

public interface Algorithm {

    void start();

    static String convertToRegularTime(long durationInMilliseconds) {
        long minutes = (durationInMilliseconds / 1000) / 60;
        long seconds = (durationInMilliseconds / 1000) % 60;
        long millis = durationInMilliseconds - seconds * 1000;
        return String.format("%2d min. %2d sec. %2d ms.", minutes, seconds, millis);
    }

    static void printStats(int phoneNumbersFound, long timeTakenToSort, long timeTakenToSearch, boolean isNextSearch, boolean isSortingTakingTooMuchTime) {
        if (!isNextSearch) {
            System.out.printf("Found %d / %d entries. ", phoneNumbersFound, 500);
            System.out.println("Time taken: " + convertToRegularTime(timeTakenToSearch) + "\n");
        } else {
            System.out.printf("Found %d / %d entries. ", phoneNumbersFound, 500);
            System.out.println("Time taken: " + convertToRegularTime(timeTakenToSort + timeTakenToSearch));
            System.out.println("Sorting time: " + convertToRegularTime(timeTakenToSort) +
                    (isSortingTakingTooMuchTime ? " - STOPPED, moved to linear search" : ""));
            System.out.println("Searching time: " + convertToRegularTime(timeTakenToSearch) + "\n");
        }
    }

    static void printStats(int phoneNumbersFound, long timeTakenToCreate, long timeTakenToSearch) {
        System.out.println("Start searching (hash table)...");
        System.out.printf("Found %d / %d entries.", phoneNumbersFound, 500);
        System.out.println("Time taken: " + convertToRegularTime(timeTakenToCreate + timeTakenToSearch));
        System.out.println("Creating time: " + convertToRegularTime(timeTakenToCreate));
        System.out.println("Searching time: " + convertToRegularTime(timeTakenToSearch));
    }
}
