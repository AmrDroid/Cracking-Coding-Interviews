package amazon;

public class Atoi {

//    Time Complexity: O(n).
//    Only one traversal of string is needed.
//    Space Complexity: O(1).

    static int myAtoi(char[] str) {
        int sign = 1, base = 0, i = 0;

        // if whitespaces then ignore.
        while (str[i] == ' ') {
            i++;
        }

        // sign of number
        if (str[i] == '-' || str[i] == '+') {
            sign = 1 - 2 * (str[i++] == '-' ? 1 : 0);
        }

        // checking for valid input
        while (i < str.length
                && str[i] >= '0'
                && str[i] <= '9') {

            // handling overflow test case
            if (base > Integer.MAX_VALUE / 10
                    || (base == Integer.MAX_VALUE / 10
                    && str[i] - '0' > 7)) {
                if (sign == 1)
                    return Integer.MAX_VALUE;
                else
                    return Integer.MIN_VALUE;
            }
            base = 10 * base + (str[i++] - '0');
        }
        return base * sign;
    }

    // Driver code
    public static void main(String[] args) {
        char str[] = "aa-123".toCharArray();

        // Function call
        int val = myAtoi(str);
        System.out.printf("%d ", val);
    }

}
