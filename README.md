This Java program allows the user to compare the time efficiency of several of the most important sorting and searching algorithms. 

Originally based on a Hyperskill project (https://hyperskill.org/projects/63), the app uses a text file named directory.txt for demonstration purposes a text. The file contains about one million phonebook entries gathered from all around the world (phone number plus name of the phone owner). 

For demonstrations purposes of the strengths and flaws of the different algorithms implemented here, the program then searches for the phone numbers of the 500 persons included in the file find.txt. The time difference is measured with the help of System.currentTimeMillis().

Search Algorithms implemented:

1 - Linear search - "...a simple algorithm for searching a value in arrays or similar collections. The algorithm checks each element of an array until it finds one that matches the target value. If the algorithm reaches the end of an array, it terminates unsuccessfully. In the worst case, it performs exactly nn comparisons where nn is the length of the input array containing data." https://hyperskill.org/learn/step/3541.

2 - Jump search - "...an algorithm for finding the position of an element in a sorted array. Unlike the linear search, it doesn't compare each element of an array with the target value. It splits the given array into a sequence of blocks and then jumps over them to find a block that may contain the target element. To do that, the algorithm compares the right borders of blocks with the target element." https://hyperskill.org/learn/step/3548.

3 - Binary search - "Binary search is a fast algorithm for finding the position of an element in a sorted array. For an array of size nn, the running time of the algorithm is O(\log n)O(logn) in the worst case.

The algorithm begins by comparing the middle element of the array with a target value. If the target value matches the middle element, its position in the array is returned. If the target value is less than or greater than the middle element, the search continues in the left or right subarray, respectively, eliminating the other subarray from consideration. It repeats until the value is found or a new search interval is empty."

Sort algorithms implemented: 

1 - Bubble sort - "...one of the simplest sorting algorithms. It repeatedly steps through the array to be sorted, compares each pair of adjacent array elements and swaps them if they are in the wrong order.

The wrong and correct orders depend on the required sorting order. If an array must be sorted in the ascending order, the wrong order is the case when the previous element is greater than the next one. And if an array must be sorted in the descending order, the wrong order is the case when the previous element is less than the next one." https://hyperskill.org/learn/step/3547.

2 - Quick sort - "...an efficient in-place sorting algorithm that is often faster in practice comparing with other sorting algorithms (...) Quicksort can be implemented as a recursive or iterative algorithm." https://hyperskill.org/learn/step/3528

And last but not the least...: 

"A hash table is a structure that allows us to efficiently perform insert, find, and remove operations with data. In Java, this structure is represented by the Hashtable<K, V> class from the standard collections." https://hyperskill.org/learn/step/6945 
Do note that the hash table here included is an implementation of this type of data structure and not the one that comes with java.util.*. 



