package amazon;

import java.util.Arrays;

public class Lexicographical {

    public static void printArray(String strArr[])
    {
        for (String string : strArr)
            System.out.print(string + " ");
        System.out.println();
    }
    public static void
    sortLexicographically(String strArr[])
    {
        for (int i = 0; i < strArr.length; i++) {
            for (int j = i + 1; j < strArr.length; j++) {
                if (strArr[i].compareToIgnoreCase(strArr[j])
                        > 0) {
                    String temp = strArr[i];
                    strArr[i] = strArr[j];
                    strArr[j] = temp;
                }
            }
        }
    }


    public static void main(String[] args)
    {
        // Initializing String array.
        String stringArray[]
                = { "Harit",    "Girish", "Gritav",
                "Lovenish", "Nikhil", "Harman" };

        // sorting String array in Lexicographical Order.
        // Ingonring the case of string.
        Arrays.sort(stringArray,
                String.CASE_INSENSITIVE_ORDER);

        // printing String array after sorting.
        printArray(stringArray);
    }

}
