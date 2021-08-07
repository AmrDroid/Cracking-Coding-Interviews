package amazon;

public class ReverseWords {
    public static String[] RevString(String[] s,
                                     int l)
    {

        // Check if number of words is even
        if (l % 2 == 0)
        {

            // Find the middle word
            int j = l / 2;

            // Starting from the middle
            // start swapping words at
            // jth position and l-1-j position
            while (j <= l - 1)
            {
                String temp;
                temp = s[l - j - 1];
                s[l - j - 1] = s[j];
                s[j] = temp;
                j += 1;
            }
        }

        // Check if number of words is odd
        else
        {

            // Find the middle word
            int j = (l / 2) + 1;

            // Starting from the middle start
            // swapping the words at jth
            // position and l-1-j position
            while (j <= l - 1)
            {
                String temp;
                temp = s[l - j - 1];
                s[l - j - 1] = s[j];
                s[j] = temp;
                j += 1;
            }
        }

        // Return the reversed sentence
        return s;
    }

    // Driver Code
    public static void main(String[] args)
    {
        String s = "getting good at coding " +
                "needs a lot of practice";
        String[] words = s.split("\\s");

        words = RevString(words, words.length);

        s = String.join(" ", words);

        System.out.println(s);
    }
}
