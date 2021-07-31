package amazon;

import java.util.*;

public class StringsAccordingFrequency {

    static Integer[] arr = { 2, 5, 2, 8, 5, 6, 8, 8 };

    // Driver Code
    public static void main(String[] args)
    {
        List<Integer> list = Arrays.asList(arr);
        sortBasedOnFrequencyAndValue(list);
    }
    // Compare Function
    public static void
    sortBasedOnFrequencyAndValue(List<Integer> list)
    {
        int n = arr.length;
        final HashMap<Integer, Integer> mapCount
                = new HashMap<Integer, Integer>();
        final HashMap<Integer, Integer> mapIndex
                = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            if (mapCount.containsKey(arr[i])) {
                mapCount.put(arr[i],
                        mapCount.get(arr[i]) + 1);
            }
            else {
                mapCount.put(arr[i],1); // Map to capture Count of elements
                mapIndex.put(arr[i],i); // Map to capture 1st occurrence of elements
            }
        }

        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer n1, Integer n2)
            {
                int freq1 = mapCount.get(n1);
                int freq2 = mapCount.get(n2);
                if (freq1 != freq2) {
                    return freq2 - freq1;
                }
                else {
                    return mapIndex.get(n1)
                            - mapIndex.get(
                            n2); // Elements with Lesser
                    // Index gets Higher
                    // Priority
                }
            }
        });
        System.out.println(list);
    }


}
