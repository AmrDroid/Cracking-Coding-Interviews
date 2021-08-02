package amazon;

public class GenerateAllBinaryPermutations {

    // ones & zeroes --> counts of 1's and 0's in current string 'str'
// len ---> desired length of every permutation
    static void generate(int ones, int zeroes, String str, int len) {
        // If length of current string becomes same as desired length
        if (len == str.length()) {
            System.out.print(str + " ");
            return;
        }

        // Append a 1 and recur
        generate(ones + 1, zeroes, str + "1", len);

        // If there are more 1's, append a 0 as well, and recur
        if (ones > zeroes) {
            generate(ones, zeroes + 1, str + "0", len);
        }
    }

    // Driver program to test above function
    public static void main(String[] args) {
        String str = "";
        generate(0, 0, str, 4);
    }

}
