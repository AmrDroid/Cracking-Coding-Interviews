package amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class MinimumPriorityRequired {

    static int[] minPriority(int arr[]) {
        int n = arr.length;
        TreeSet<Integer> ts = new TreeSet<>();
        for (int val : arr) {
            ts.add(val);
        }
        Map<Integer, Integer> mp = new HashMap<>();
        int priority = 1;
        for (int v : ts) {
            mp.put(v, priority);
            priority++;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = mp.get(arr[i]);
        }

        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {1, 4, 8, 4};
        int res[] = minPriority(arr);

        for (int r : res)
            System.out.println(r);
    }
}
