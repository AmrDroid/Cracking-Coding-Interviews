package ocado;

import java.util.Arrays;
import java.util.HashSet;

public class ThreeSum {
    static boolean fin2Sum(int A[], int arr_size, int sum) {
        Arrays.sort(A);
        int l = 0, r = arr_size - 1;
        while (l < r) {
            int res = A[l] + A[r];
            if (res == sum) {
                System.out.println(A[l] + "  " + A[r]);
                return true;
            } else if (res < sum)
                l++;
            else
                r--;
        }
        return false;
    }


    static void find3(int arr[], int n, int s) {
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            int l = i + 1, h = n - 1;
            while (l < h) {
                if (arr[i] + arr[l] + arr[h] == s) {
                    System.out.println(arr[i] + "," + arr[l] + "," + arr[h]);
                return;
                }
                else if (arr[i] + arr[l] + arr[h] < s)
                    l++;
                else
                    h++;
            }
        }
    }

    /* Driver code */
    public static void main(String[] args) {
        int A[] = {2, 4, 12, 6, 10, 8};
        int sum = 22;
        int arr_size = A.length;

        find3Numbers(A, arr_size, sum);
        fin2Sum(A, arr_size, sum);
        find3(A, arr_size, sum);
    }

    //    Time complexity: O(N^2)
//    Auxiliary Space: O(N)
    static boolean find3Numbers(int A[], int arr_size, int sum) {
        // Fix the first element as A[i]
        for (int i = 0; i < arr_size - 2; i++) {

            // Find pair in subarray A[i+1..n-1]
            // with sum equal to sum - A[i]
            HashSet<Integer> s = new HashSet<Integer>();
            int curr_sum = sum - A[i];
            for (int j = i + 1; j < arr_size; j++) {
                if (s.contains(curr_sum - A[j])) {
                    System.out.printf("Triplet is %d, %d, %d", A[i], A[j], curr_sum - A[j]);
                    return true;
                }
                s.add(A[j]);
            }
        }

        // If we reach here, then no triplet was found
        return false;
    }
}
