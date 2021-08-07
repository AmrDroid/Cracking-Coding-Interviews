package amazon;

public class CheckWordsinString {
    // Function that returns true if the word is found
    static boolean isWordPresent(String sentence,
                                 String word)
    {
        // To convert the word in uppercase
        word = transform(word);

        // To convert the complete sentence in uppercase
        sentence = transform(sentence);

        // Both Strings are converted to the same case,
        // so that the search is not case-sensitive

        // To break the sentence in words
        String []s = sentence.split(" ");

        // To store the individual words of the sentence
        for ( String temp :s)
        {

            // Comparing the current word
            // with the word to be searched
            if (temp.compareTo(word) == 0)
            {
                return true;
            }
        }
        return false;
    }

    static String transform(String word)
    {
        return word.toUpperCase();
    }

    // Driver code
    public static void main(String[] args)
    {
        String s = "Geeks for Geeks";
        String word = "geeks";

        if (isWordPresent(s, word))
            System.out.print("Yes");
        else
            System.out.print("No");
    }


}
