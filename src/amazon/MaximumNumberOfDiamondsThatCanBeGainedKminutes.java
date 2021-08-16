package amazon;

import java.util.PriorityQueue;

public class MaximumNumberOfDiamondsThatCanBeGainedKminutes {



    // Function to find the maximum number
// of diamonds that can be gained in
// exactly K minutes
    static void maxDiamonds(int A[], int N, int K)
    {

        // Stores all the array elements
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> b - a);

        // Push all the elements to the
        // priority queue
        for(int i = 0; i < N; i++)
        {
            pq.add(A[i]);
        }

        // Stores the required result
        int ans = 0;

        // Loop while the queue is not
        // empty and K is positive
        while (!pq.isEmpty() && K-- > 0)
        {

            // Store the top element
            // from the pq
            int top = pq.peek();

            // Pop it from the pq
            pq.remove();

            // Add it to the answer
            ans += top;

            // Divide it by 2 and push it
            // back to the pq
            top = top / 2;
            pq.add(top);
        }

        // Print the answer
        System.out.print(ans);
    }

    // Driver Code
    public static void main(String[] args)
    {
        int A[] = { 2, 1, 7, 4, 2 };
        int K = 3;
        int N = A.length;

        maxDiamonds(A, N, K);
    }
}
