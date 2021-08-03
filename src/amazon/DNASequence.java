package amazon;

public class DNASequence {

    static void printUpperHalf(String str)
    {
        char first, second;
        int pos = 0;

        // Each half of the DNA is made of
        // combination of two compounds
        for (int i = 1; i <= 4; i++) {

            // Taking the two carbon
            // compounds from the string
            first = str.charAt(pos);
            second = str.charAt(pos+1);
            pos += 2;

            for (int j = 4 - i; j >= 1; j--)
                System.out.print(" ");
            System.out.print(first);
            for (int j = 1; j < i; j++)
                System.out.print("--");
            System.out.println(second);
        }
    }

    // Function to print lower half
// of the DNA or the lower lobe
    static void printLowerHalf(String str)
    {
        char first, second;
        int pos = 0;
        for (int i = 1; i <= 4; i++) {

            first = str.charAt(pos);
            second = str.charAt(pos+1);
            pos += 2;

            for (int j = 1; j < i; j++)
                System.out.print(" ");
            System.out.print(first);
            for (int j = 4 - i; j >= 1; j--)
                System.out.print("--");
            System.out.println(second);
        }
    }

    // Function to print 'n' parts of DNA
    static void printDNA(String str[], int n)
    {
        for (int i = 0; i < n; i++) {

            int x = i % 6;

            // Calling for upperhalf
            if (x % 2 == 0)
                printUpperHalf(str[x]);
            else

                // Calling for lowerhalf
                printLowerHalf(str[x]);
        }
    }
    public static void main (String[] args) {
        int n = 8;

        // combinations stored in the array
        String DNA[] = { "ATTAATTA", "TAGCTAGC", "CGCGATAT",
                "TAATATGC", "ATCGTACG", "CGTAGCAT" };
        printDNA(DNA, n);

    }

}
