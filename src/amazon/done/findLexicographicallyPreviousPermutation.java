package amazon.done;

public class findLexicographicallyPreviousPermutation {


    // Function to compute
    // the previous permutation
    static boolean prevPermutation(char[] str)
    {

        // Find index of the last
        // element of the string
        int n = str.length - 1;

        // Find largest index i such
        // that str[i - 1] > str[i]
        int i = n;
        while (i > 0 && str[i - 1] <= str[i]) {
            i--;
        }

        // if string is sorted in
        // ascending order we're
        // at the last permutation
        if (i <= 0) {
            return false;
        }

        // Note - str[i..n] is sorted
        // in ascending order Find
        // rightmost element's index
        // that is less than str[i - 1]
        int j = i - 1;
        while (j + 1 <= n && str[j + 1] <= str[i - 1]) {
            j++;
        }

        // Swap character at i-1 with j
        swap(str, i - 1, j);

        // Reverse the substring [i..n]
        StringBuilder sb
                = new StringBuilder(String.valueOf(str));
        sb.reverse();
        str = sb.toString().toCharArray();

        return true;
    }

    static String swap(char[] ch, int i, int j)
    {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return String.valueOf(ch);
    }

    // Driver code
    public static void main(String[] args)
    {
        char[] str = "4321".toCharArray();
        if (prevPermutation(str)) {
            System.out.println("Previous permutation is "
                    + String.valueOf(str));
        }
        else {
            System.out.println("Previous permutation"
                    + "doesn't exist");
        }
    }
}
