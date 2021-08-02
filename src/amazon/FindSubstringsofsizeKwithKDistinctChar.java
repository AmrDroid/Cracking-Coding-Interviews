package amazon;

import java.util.*;

public class FindSubstringsofsizeKwithKDistinctChar {
//Time Complexity: O(N)
    public static int countSubstrings(String str,
                                      int K)
    {
        int N = str.length();

        // Store the count
        int answer = 0;

        // Store the count of
        // distinct characters
        // in every window
        Map<Character,
                Integer> map = new HashMap<Character,
                Integer>();

        // Store the frequency of
        // the first K length substring
        for(int i = 0; i < K; i++)
        {

            // Increase frequency of
            // i-th character
            if (map.get(str.charAt(i)) == null)
            {
                map.put(str.charAt(i), 1);
            }
            else
            {
                map.put(str.charAt(i),
                        map.get(str.charAt(i)) + 1);
            }
        }

        // If K distinct characters
        // exist
        if (map.size() == K)
            answer++;

        // Traverse the rest of the
        // substring
        for(int i = K; i < N; i++)
        {

            // Increase the frequency
            // of the last character
            // of the current substring
            if (map.get(str.charAt(i)) == null)
            {
                map.put(str.charAt(i), 1);
            }
            else
            {
                map.put(str.charAt(i),
                        map.get(str.charAt(i)) + 1);
            }

            // Decrease the frequency
            // of the first character
            // of the previous substring
            map.put(str.charAt(i - K),
                    map.get(str.charAt(i - K)) - 1);

            // If the character is not present
            // in the current substring
            if (map.get(str.charAt(i - K)) == 0)
            {
                map.remove(str.charAt(i - K));
            }

            // If the count of distinct
            // characters is 0
            if (map.size() == K)
            {
                answer++;
            }
        }

        // Return the count
        return answer;
    }


    public static Set<String> uniqueSubstringSizeK(String s, int k) {
        Set<String> set = new HashSet<>();
        int[] ch = new int[26];
        int lo = 0;
        int hi = 0;
        while (lo <= hi && hi < s.length()) {
            ch[s.charAt(hi) - 'a']++;
            while (ch[s.charAt(hi) - 'a'] != 1) {
                ch[s.charAt(lo) - 'a']--;
                lo++;
            }
            if (hi - lo + 1 == k) {
                set.add(s.substring(lo, hi + 1));
                ch[s.charAt(lo) - 'a']--;
                lo++;
            }
            hi++;
        }
        System.out.println(set.size());
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        return set;
    }

    public static void main(String[] args) {
        uniqueSubstringSizeK("awaglknagawunagwkwagl", 4);
//        uniqueSubstringSizeK("abacab", 3);
//        uniqueSubstringSizeK("awaglknagawunagwkwagl", 4);

        // string str
        String str = "aabcdabbcdc";

        // integer K
        int K = 3;

        // Print the count of K length
        // substrings with k distinct characters
        System.out.println(countSubstrings(str, K));
    }


    //
//    Time:O(KN)  where  is the length of the string.
//            Space: Time:O(KN) since we need to store the result.
    public static List<String> kSubstring1(String s, int k) {
        int n = s.length();
        Set<String> result = new HashSet<>();
        for (int i = 0; i + k <= n; ++i) {
            String sub = s.substring(i, i + k);
            if (isDistinct(sub)) {
                result.add(sub);
            }
        }
        return new ArrayList<>(result);
    }

    private static boolean isDistinct(String s) {
        // Use hash set
        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            set.add(ch);
        }
        return set.size() == s.length();
    }











    public static List<String> kSubstring2(String s, int k) {
        int n = s.length();
        Set<Character> window = new HashSet<>();
        Set<String> result = new HashSet<>();
        for (int start = 0, end = 0; end < n; ++end) {
            char ch = s.charAt(end);
            // duplicate: remove all elements that is before the existing element (inclusive)
            while (window.contains(ch)) {
                window.remove(s.charAt(start));
                ++start; // update the lower bound of the sliding window
            }
            window.add(ch);
            // when size == k
            if (window.size() == k) { // guarantee no duplicates
                result.add(s.substring(start, end + 1)); // added
                window.remove(s.charAt(start));
                ++start; // guarantee the size is not larger than k
            }
        }
        return new ArrayList<>(result);
    }


}
