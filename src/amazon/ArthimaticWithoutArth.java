package amazon;

public class ArthimaticWithoutArth {

    static int Add(int x, int y)
    {
        // Iterate till there is no carry
        while (y != 0)
        {
            // carry now contains common
            // set bits of x and y
            int carry = x & y;

            // Sum of bits of x and
            // y where at least one
            // of the bits is not set
            x = x ^ y;

            // Carry is shifted by
            // one so that adding it
            // to x gives the required sum
            y = carry << 1;
        }
        return x;
    }

    static int multiply(int x, int y) {

        /* 0 multiplied with anything gives 0 */
        if (y == 0)
            return 0;

        /* Add x one by one */
        if (y > 0)
            return (x + multiply(x, y - 1));

        /* the case where y is negative */
        if (y < 0)
            return -multiply(x, -y);

        return -1;
    }

    // Driver code
    public static void main(String arg[])
    {
        System.out.println(Add(15, 32));
        System.out.print("\n" + multiply(5, -11));

    }


}
