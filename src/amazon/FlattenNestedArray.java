package amazon;

import java.util.*;
import java.util.stream.Stream;

public class FlattenNestedArray {
    // Function to flatten a Stream of Arrays
    public static <T> Stream<T> flattenStream(T[][] arrays)
    {

        // Create an empty list to collect the stream
        List<T> list = new ArrayList<>();

        // Using forEach loop
        // convert the array into stream
        // and add the stream into list
        for (T[] array : arrays) {
            Arrays.stream(array)
                    .forEach(list::add);
        }

        // Convert the list into Stream and return it
        return list.stream();
    }

    public static void main(String[] args)
    {

        // Get the arrays to be flattened.
        Character[][] arr = {
                { 'G', 'e', 'e', 'k', 's' },
                { 'F', 'o', 'r' },
                { 'G', 'e', 'e', 'k', 's' }
        };

        // Flatten the Stream
        Character[] flatArray = flattenStream(arr)
                .toArray(Character[] ::new);

        // Print the flattened array
        System.out.println(Arrays.toString(flatArray));
    }

}
