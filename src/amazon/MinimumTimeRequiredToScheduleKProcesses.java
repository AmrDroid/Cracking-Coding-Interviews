package amazon;

///https://www.geeksforgeeks.org/minimum-time-required-to-schedule-k-processes/
public class MinimumTimeRequiredToScheduleKProcesses
{

    // Function to find minimum required
    // time to schedule all process
    static int minTime(int[] A, int n, int K)
    {
        // Stores max element from A[]
        int max_ability = A[0];

        // Find the maximum element
        for (int i = 1; i < n; i++) {
            max_ability = Math.max(
                    max_ability, A[i]);
        }

        // Stores frequency of each element
        int tmp[] = new int[max_ability + 1];

        // Stores minimum time required
        // to schedule all process
        int count = 0;

        // Count frequencies of elements
        for (int i = 0; i < n; i++) {
            tmp[A[i]]++;
        }

        // Find the minimum time
        for (int i = max_ability;
             i >= 0; i--) {

            if (tmp[i] != 0) {

                if (tmp[i] * i < K) {

                    // Decrease the value
                    // of K
                    K -= (i * tmp[i]);

                    // Increment tmp[i/2]
                    tmp[i / 2] += tmp[i];

                    // Increment the count
                    count += tmp[i];

                    // Return count, if all
                    // process are scheduled
                    if (K <= 0) {
                        return count;
                    }
                }

                else {

                    // Increment count
                    if (K % i != 0) {
                        count += (K / i) + 1;
                    }
                    else {
                        count += (K / i);
                    }

                    // Return the count
                    return count;
                }
            }
        }

        // If it is not possible to
        // schedule all process
        return -1;
    }

    // Driver Code
    public static void main(String[] args)
    {
        int arr[] = { 3, 1, 7, 2, 4 };
        int N = arr.length;
        int K = 15;
        System.out.println(
                minTime(arr, N, K));
    }
}
