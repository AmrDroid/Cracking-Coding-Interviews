package amazon.done;

public class ZigZagSubsequence {
    public static void main(String[] args) {
        int[] sequence1 = {1, 3, 6, 2};
        int[] sequence2 = {5, 0, 3, 1, 0, 1, 0, 2, 1};

        int n1 = sequence1.length; // size of sequences
        int n2 = sequence2.length;

        int maxLength1 = maxZigZag(sequence1, n1);
        int maxLength2 = maxZigZag(sequence2, n2); // function call

        System.out.println("The maximum length of zig-zag sub-sequence in first sequence is: " + maxLength1);
        System.out.println("The maximum length of zig-zag sub-sequence in second sequence is: " + maxLength2);
       }

    /* Function to calculate maximum length of zig-zag
    sub-sequence in given sequence.
    */

    static int maxZigZag(int[] seq, int n) {
        if (n == 0) {
            return 0;
        }

        int lastSign = 0, length = 1;
        // length is initialized to 1 as that is minimum
        // value for arbitrary sequence.

        for (int i = 1; i < n; ++i) {
            int Sign = signum(seq[i] - seq[i - 1]);

            if (Sign != 0 && Sign != lastSign) // it qualifies
            {
                lastSign = Sign; // updating lastSign
                length++;
            }
        }

        return length;
    }

    /* Signum function :
    Returns 1 when passed a positive integer
    Returns -1 when passed a negative integer
    Returns 0 when passed 0. */
    static int signum(int n) {
        if (n != 0) {
            return n > 0 ? 1 : -1;
        } else {
            return 0;
        }
    }

}
//
//
//    static int maxZigZag2(int[] seq, int n) {
//        int len = 2;
//        for (int i = 1; i < n - 1; i++) {
//            if ((seq[i - 1] > seq[i] && seq[i] < seq[i + 1]) || (seq[i - 1] < seq[i] && seq[i] > seq[i + 1]))
//                len++;
//        }
//        if (len > 2)
//            return len;
//        else
//            return 0;
//    }
