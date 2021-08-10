package CapitalOne;

public class checkingnumbersfrom1tondivide3or5orboth {
    // function to return sum of
// digits of a number
    static int SumOfDigits(String str,
                           int n)
    {
        int sum = 0;

        for (int i = 0; i < n; i++)
            sum += (int)(str.charAt(i) - '0');

        return sum;
    }

    // function to Check if a large number
// is divisible by 2, 3 and 5 or not
    static boolean Divisible(String str,
                             int n)
    {
        if (SumOfDigits(str, n) % 3 == 0 &&
                str.charAt(n - 1) == '0')
            return true;

        return false;
    }

    // Driver code
    public static void main(String []args)
    {
        String str = "263730746028908374890";

        int n = str.length();

        if (Divisible(str, n))
            System.out.println("YES");
        else
            System.out.println("NO");
    }

}
