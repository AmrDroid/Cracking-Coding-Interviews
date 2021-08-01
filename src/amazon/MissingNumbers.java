package amazon;

public class MissingNumbers {
  static   String FindMissing(int[] a) {
        if (a.length == 0)
            return "0-99";
        int start = 0, end = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if (a[i] != start) {
                end = a[i] - 1;
                if (start == end)
                    result.append(start + ",");
                else
                    result.append(start + "-" + end + ",");
            }
            start = a[i] + 1;
        }
        if (start != 100) {
            end = 99;
            if (start - 1 == end)
                result.append(end);
            else
                result.append(start + "-" + end);
        }

        return result.toString();
    }

    public static void main(String args[]) {

        int arr[]=new int[]{0, 1, 4, 50, 52, 75};
        System.out.println(FindMissing(arr));
    }

}
