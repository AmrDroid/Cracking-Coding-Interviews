package amazon;

public class CountSetBits {
    static int[] num_to_bits = new int[] { 0, 1, 1, 2, 1, 2, 2,
            3, 1, 2, 2, 3, 2, 3, 3, 4 };

    /* Recursively get nibble of a given number
and map them in the array */
    static int countSetBitsRec(int num)
    {
        //Time Complexity: O(log n), because we have log(16, n) levels of recursion.
        //Storage Complexity: O(1) Whether the given number is short, int, long, or long long we require an array of 16 sizes only, which is constant.

        int nibble = 0;
        if (0 == num)
            return num_to_bits[0];

        // Find last nibble
        nibble = num & 0xf;

        // Use pre-stored values to find count
        // in last nibble plus recursively add
        // remaining nibbles.
        return num_to_bits[nibble] + countSetBitsRec(num >> 4);
    }






    // Check each bit in a number is set or not
    // and return the total count of the set bits.
    static int countSetBits(int N)
    {
        int count = 0;
        // (1 << i) = pow(2, i)
        for (int i = 0; i < 4 * 8; i++)
        {
            if ((N & (1 << i)) != 0)
                count++;
        }
        return count;
    }

    // Driver code
    public static void main(String[] args)
    {
        int N = 15;
        System.out.println(countSetBits(N));

        System.out.println(countSetBitsRec(N));

    }

}
