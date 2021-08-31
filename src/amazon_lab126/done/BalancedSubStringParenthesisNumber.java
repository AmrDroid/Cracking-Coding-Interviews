package amazon_lab126.done;

import java.util.Arrays;

public class BalancedSubStringParenthesisNumber {

    public static int Balanced_Substring(String str, int n)
    {
        // To store required answer
        int ans = 0;

        // Vector to stores the number of
        // balanced brackets at each depth.
        int[] arr = new int[n / 2 + 1];

        // d stores checks the depth of our sequence
        // For example level of () is 1
        // and that of ((s)) is 2.
        int d = 0;

        for (int i = 0; i < n; i++) {
            // If open bracket
            // increase depth
            if (str.charAt(i) == '(')
                d++;

                // If closing bracket
            else {
                if (d == 1) {
                    for (int j = 2; j <= n / 2 + 1 && arr[j] != 0; j++)
                        arr[j] = 0;
                }
                ++ans;
                ans += arr[d];
                arr[d]++;
                d--;
            }
//           System.out.println(d+"  "+ans+"  "+ Arrays.toString(arr));
        }

        // Return the required answer
        return ans;
    }

    // Driver code
    public static void main(String[] args)
    {
        String str = "(()()()";
        int n = str.length();

        // Function call
        System.out.println(Balanced_Substring(str, n));
    }

}
