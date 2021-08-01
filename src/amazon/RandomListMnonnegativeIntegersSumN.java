package amazon;

public class RandomListMnonnegativeIntegersSumN {
    static void printArr(int arr[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    // Function to generate a list of
// m random non-negative integers
// whose sum is n
    static void randomList(int m, int n) {

        // Create an array of size m where
        // every element is initialized to 0
        int arr[] = new int[m];

        // To make the sum of the final list as n
        for (int i = 0; i < n; i++) {

            // Increment any random element
            // from the array by 1
            arr[(int) (Math.random() * m)]++;
        }

        // Print the generated list
        printArr(arr, m);
    }

    // Driver code
    public static void main(String args[]) {
        int m = 4, n = 8;

        randomList(m, n);
    }

}
