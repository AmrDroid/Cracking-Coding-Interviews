package amazon;

public class SubstringThatContainsAllLowercaseAlphabetsAfterPerformingGivenOperation {

    // Function that returns true if every
// lowercase character appears atmost once
    static boolean valid(int []cnt)
    {
        // every character frequency must be not
        // greater than one
        for (int i = 0; i < 26; i++)
        {
            if (cnt[i] >= 2)
                return false;
        }

        return true;
    }

    // Function that returns the modified
// good string if possible
    static String getGoodString(String ss, int n)
    {
        char[] s=ss.toCharArray();

        // If the length of the string is less than n
        if (n < 26)
            return "-1";

        // To store frequency of each character
        int[] cnt = new int[27];

        // Sub-strings of length 26
        for (int i = 25; i < n; i++)
        {



            // Get the frequency of each character
            // in the current sub-string
            for (int j = i; j >= i - 25; j--)
            {
                if (s[j] != '?')
                    cnt[((int)s[j] - (int)'a')]++;
            }

            // Check if we can get sub-string containing all
            // the 26 characters
            if (valid(cnt))
            {

                // Find which character is missing
                int cur = 0;
                while (cnt[cur] > 0)
                    cur++;

                for (int j = i - 25; j <= i; j++)
                {

                    // Fill with missing characters
                    if (s[j] == '?')
                    {
                        s[j] = (char)(cur + (int)('a'));
                        cur++;

                        // Find the next missing character
                        while (cnt[cur] > 0)
                            cur++;
                    }
                }

                // Return the modified good string
                return new String(s);
            }
        }

        return "-1";
    }

    // Driver code
    public static void main (String[] args)
    {
        String s = "abcdefghijkl?nopqrstuvwxy?";
        int n = s.length();

        System.out.println(getGoodString(s, n));
    }
}
