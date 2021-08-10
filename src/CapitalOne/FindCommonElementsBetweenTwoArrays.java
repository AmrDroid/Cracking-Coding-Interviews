package CapitalOne;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindCommonElementsBetweenTwoArrays
{


    // function to create hashsets
    // from arrays and find
    // their common element
    public static void FindCommonElements(int[] arr1,
                                          int[] arr2)
    {
        // create hashsets
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Adding elements from array1
        for (int i : arr1) {
            set1.add(i);
        }

        // Adding elements from array2
        for (int i : arr2) {
            set2.add(i);
        }

        // use retainAll() method to
        // find common elements
        set1.retainAll(set2);
        System.out.println("Common elements- " + set1);
    }

    // main method
    public static void main(String[] args)
    {
        // create Array 1
        int[] arr1
                = { 1, 4, 9, 16, 25, 36, 49, 64, 81, 100 };

        // create Array 2
        int[] arr2 = { 100, 9, 64, 7, 36, 5, 16, 3, 4, 1 };

        // print Array 1
        System.out.println("Array 1: "
                + Arrays.toString(arr1));
        // print Array 2
        System.out.println("Array 2: "
                + Arrays.toString(arr2));
        FindCommonElements(arr1, arr2);
    }


    private static void findCommonElements(int[] arr1,
                                           int[] arr2)
    {

        // Check if length of arr1 is greater than 0
        // and length of arr2 is greater than 0
        if (arr1.length > 0 && arr2.length > 0) {
            Set<Integer> firstSet = new HashSet<Integer>();
            for (int i = 0; i < arr1.length; i++) {
                firstSet.add(arr1[i]);
            }

            // Iterate the elements of the arr2
            for (int j = 0; j < arr2.length; j++) {
                if (firstSet.contains(arr2[j])) {
                    System.out.println(arr2[j]);
                }
            }
        }
    }
}
