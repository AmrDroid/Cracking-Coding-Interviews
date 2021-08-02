package amazon;

import java.util.*;

public class CamelCasePatternMatching {
    static void CamelCase(ArrayList<String> words,
                          String pattern)
    {

        // Map to store the hashing
        // of each words with every
        // uppercase letter found
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        // Traverse the words array
        // that contains all the
        // String
        for (int i = 0; i < words.size(); i++) {

            // Initialise str as
            // empty
            String str = "";

            // length of String words[i]
            int l = words.get(i).length();
            for (int j = 0; j < l; j++) {

                // For every uppercase
                // letter found map
                // that uppercase to
                // original words
                if (words.get(i).charAt(j) >= 'A'
                        && words.get(i).charAt(j) <= 'Z') {
                    str += words.get(i).charAt(j);
                    map.put(str,list(map.get(str),words.get(i)));
                }
            }
        }

        boolean wordFound = false;

        // Traverse the map for pattern
        // matching
        for (Map.Entry<String,List<String>> it : map.entrySet()) {

            // If pattern matches then
            // print the corresponding
            // mapped words
            if (it.getKey().equals(pattern)) {
                wordFound = true;
                for(String s : it.getValue())
                    System.out.print(s +"\n");

            }
        }

        // If word not found print
        // "No match found"
        if (!wordFound) {
            System.out.print("No match found");
        }
    }

    private static List<String> list(List<String> list, String str) {
        List<String> temp = new ArrayList<String>();
        if(list != null)
            temp.addAll(list);
        temp.add(str);
        return temp;
    }

    // Driver's Code
    public static void main(String[] args)
    {
        String arr[] = {"Hi", "Hello", "HelloWorld",
                "HiTech", "HiGeek", "HiTechWorld",
                "HiTechCity", "HiTechLab"
        };

        ArrayList<String> words = new ArrayList<String>(Arrays.asList(arr));

        // Pattern to be found
        String pattern = "HT";

        // Function call to find the
        // words that match to the
        // given pattern
        CamelCase(words, pattern);

    }

}
