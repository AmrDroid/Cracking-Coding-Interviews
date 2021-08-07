package amazon;

public class PrimeNumbers {
    static int i = 2;

    // Function check whether a number
// is prime or not
    static boolean isPrime2(int n)
    {

        // Check if number is less than
        // equal to 1
        if (n <= 1)
            return false;

            // Check if number is 2
        else if (n == 2)
            return true;

            // Check if n is a multiple of 2
        else if (n % 2 == 0)
            return false;

        // If not, then just check the odds
        for (int i = 3; i <= Math.sqrt(n); i += 2)
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static boolean isPrime(int n)
    {

        // Corner cases
        if (n == 0 || n == 1)
        {
            return false;
        }

        // Checking Prime
        if (n == i)
            return true;

        // Base cases
        if (n % i == 0)
        {
            return false;
        }
        i++;
        return isPrime(n);
    }

    // Driver Code
    public static void main(String[] args)
    {
        if (isPrime(35))
        {
            System.out.println("true");
        }
        else
        {
            System.out.println("false");
        }
    }

}
