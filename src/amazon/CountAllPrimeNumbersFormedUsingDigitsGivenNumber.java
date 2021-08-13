package amazon;

import java.util.HashSet;

public class CountAllPrimeNumbersFormedUsingDigitsGivenNumber {
    static HashSet<String> H = new HashSet<>();

    // Function to check whether the
    // number is prime or not
    static boolean check(String number)
    {
        if (number.length() == 0) {
            return false;
        }
        number = number.trim();
        long num = Long.parseLong(number);

        // Condition for prime number
        if (num == 1) {
            return false;
        }
        if (num % 2 == 0 && num != 2) {
            return false;
        }
        if (num % 3 == 0 && num != 3) {
            return false;
        }

        // Iterate over the range [6, num]
        for (int i = 6; i * i <= num; i += 6) {
            if (num % (i - 1) == 0 || num % (i + 1) == 0) {
                return false;
            }
        }

        // Otherwisem return true
        return true;
    }

    // Function to count the total number
    // of prime numbers
    static void DFS(int arr[], String ans)
    {
        // Add it in the HashSet
        if (check(ans) == true) {
            H.add(ans);
        }

        for (int i = 0; i <= 9; ++i) {
            if (arr[i] == 0) {
                continue;
            }

            // Use the number
            ans += i;

            // Decrease the number
            arr[i]--;

            // Perform the DFS Call
            DFS(arr, ans);
            ans = ans.substring(
                    0, ans.length() - 1);

            // Backtracking the frequency
            arr[i]++;
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        String number = "123";

        int count[] = new int[10];
        for (int i = 0; i < number.length(); ++i) {
            count[number.charAt(i) - 48]++;
        }

        // Perform the DFS Traversal
        DFS(count, "");

        // Print the result
        System.out.println(H.size());
    }

}
