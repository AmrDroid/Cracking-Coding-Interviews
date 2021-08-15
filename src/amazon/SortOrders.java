package amazon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class SortOrders {


    public static int splitIntoTwo(List<Integer> arr) {
        if(arr.size()==0)return 0;
        int leftSum=0;
        int rightSum=0;
        int count =0;

        for(int i :arr)
        {
            leftSum+=i;
        }


        for(int i=arr.size()-1;i>=0;i--)
        {
            rightSum+=arr.get(i);
            leftSum-=arr.get(i);
            if(rightSum<leftSum&&(rightSum!=0&&leftSum!=0))
            {
                count++;
            }

        }
        return count;




    }
    static int noOfWays(List<Integer> arr){
        int count = 0;
        int n = arr.size();
        int prefix[] = new int[n];
        int suffix[] = new int[n];

        prefix[0] = arr.get(0);
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr.get(i);
        }

        suffix[n - 1] = arr.get(n-1);

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + arr.get(i);
        }

        for (int i = 0; i < n - 1; i++) {
            if (prefix[i] > suffix[i + 1]) {
                count++;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        int arr[] = {10, 4, -8, 7};
     //   System.out.println(noOfWays(arr));
    }
}

















//import java.io.*;
//        import java.math.*;
//        import java.security.*;
//        import java.text.*;
//        import java.util.*;
//        import java.util.concurrent.*;
//        import java.util.function.*;
//        import java.util.regex.*;
//        import java.util.stream.*;
//        import static java.util.stream.Collectors.joining;
//        import static java.util.stream.Collectors.toList;
//
//
//class Result {
//
//    /*
//     * Complete the 'splitIntoTwo' function below.
//     *
//     * The function is expected to return an INTEGER.
//     * The function accepts INTEGER_ARRAY arr as parameter.
//     */
////Time Complexity O(N)
////Space Complexity O(N)
//    public static int splitIntoTwo(List<Integer> arr) {
//        int count=0;
//        int n=arr.size();
//        int prefix[]=new int[n];
//        int suffix[]=new int[n];
//
//        prefix[0]=arr.get(0);
//
//        for(int i=1;i<n;i++)
//            prefix[i]=prefix[i-1]+arr.get(i);
//
//        suffix[n-1]=arr.get(n-1);
//
//        for(int i=n-2;i>=0;i--)
//            suffix[i]=suffix[i+1]+arr.get(i);
//
//        for(int i=0;i<n-1;i++)
//        {
//            if(prefix[i]>suffix[i+1])
//                count++;
//        }
//        return count;
//    }
//
//}
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
//            try {
//                return bufferedReader.readLine().replaceAll("\\s+$", "");
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        })
//                .map(String::trim)
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        int result = Result.splitIntoTwo(arr);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
//}

