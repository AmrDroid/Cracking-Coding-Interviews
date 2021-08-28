package amazon_lab126.done;

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
    static int subtract(int x, int y)
    {
        if (y == 0)
            return x;
        return subtract(x ^ y, (~x & y) << 1);
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


    static int divide(int dividend, int divisor)
    {

        // Calculate sign of divisor i.e.,
        // sign will be negative only iff
        // either one of them is negative
        // otherwise it will be positive
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        // Update both bdivisor and
        // dividend positive
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        // Initialize the quotient
        int quotient = 0;

        while (dividend >= divisor)
        {
            dividend -= divisor;
            ++quotient;
        }
        //if the sign value computed earlier is -1 then negate the value of quotient
        if(sign==-1) quotient=-quotient;

        return quotient;
    }



    // Driver code
    public static void main(String arg[])
    {
        System.out.println(Add(15, 32));
        System.out.print("\n" + multiply(5, -11));
        System.out.print("\n" + divide(5, -11));
        System.out.print("\n" + subtract(5, -11));



    }


}
