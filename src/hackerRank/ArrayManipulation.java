package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayManipulation {

    public static long arrayManipulation2(int n, List<List<Integer>> queries) {
        long[] computation = new long[n];

        for (int i = 0; i < queries.size(); i++) {
            int a = queries.get(i).get(0) - 1;
            int b = queries.get(i).get(1) - 1;
            int k = queries.get(i).get(2);

            computation[a] += k;
            if (b + 1 < n) {
                computation[b + 1] -= k;
            }
            System.out.println(Arrays.toString(computation));

        }
        long max = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += computation[i];
            max = Math.max(max, sum);
        }

        return max;

    }

    public static long arrayManipulation(int n, List<List<Integer>> queries) {

        long[] list = new long[n + 1];

        for (int r = 0; r < queries.size(); r++) {
            int start = queries.get(r).get(0);
            int end = queries.get(r).get(1);
            int toAdd = queries.get(r).get(2);
            for (int i = start; i <= end; i++) {
                list[i] += toAdd;
            }
        }
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < list.length; i++)
            max = Math.max(max, list[i]);

        return max;
    }


    public static void main(String[] args) {

        List<List<Integer>> list = new ArrayList<>();

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = new ArrayList<>();
        List<Integer> l4 = new ArrayList<>();


        l2.addAll(Arrays.asList(1, 5, 3));
        l3.addAll(Arrays.asList(4, 8, 7));
        l4.addAll(Arrays.asList(6, 9, 1));
        list.add(l2);
        list.add(l3);
        list.add(l4);

        System.out.println(arrayManipulation(10, list));
        System.out.println(arrayManipulation2(10, list));
    }


}
