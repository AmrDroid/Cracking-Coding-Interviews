package amazon;

public class SubArraysLeftGreaterThanRight {

    static int noOfWays(int arr[]) {
        int count = 0;
        int n = arr.length;
        int prefix[] = new int[n];
        int suffix[] = new int[n];

        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
            System.out.print(prefix[i]+" , ");
        }
        System.out.println();

        suffix[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + arr[i];
            System.out.print(suffix[i]+" , ");
        }
        System.out.println();

        for (int i = 0; i < n - 1; i++) {
            if (prefix[i] > suffix[i + 1]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int arr[] = {10, 4, -8, 7};
        System.out.println(noOfWays(arr));
    }
}
