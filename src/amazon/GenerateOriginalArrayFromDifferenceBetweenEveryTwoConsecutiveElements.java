package amazon;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class GenerateOriginalArrayFromDifferenceBetweenEveryTwoConsecutiveElements {
    static void findPerm(int n, Vector<Integer> differences)
    {
        Vector<Integer> ans = new Vector<Integer>();
        ans.clear();
        ans.add(0);

        // Take x = 0 for simplicity
        int x = 0;

        // Calculate aint the differences
        // and store it in a vector
        for (int i = 0; i <= n - 2; ++i)
        {
            int diff = differences.get(i);
            x = x + diff;
            ans.add(x);
        }

        // Preserve the original array
        Vector<Integer> anss = new Vector<Integer>();
        for(Integer obj:ans)
            anss.add(obj);

        Collections.sort(ans);
        int flag = -1;

        // Check if aint the consecutive elements
        // have difference = 1
        for (int i = 1; i <= n - 1; ++i)
        {
            int res = ans.get(i) - ans.get(i - 1);
            if (res != 1)
            {
                flag = 0;
            }
        }

        // If consecutive elements don't have
        // difference 1 at any position then
        // the answer is impossible
        if (flag == 0)
        {
            System.out.print(-1);
            return;
        }

        // Else store the indices and values
        // at those indices in a map
        // and finainty print them
        else
        {
            Map<Integer,Integer> mpp = new HashMap<>();
            mpp.clear();
            int j = 1;
            Vector<Integer> value_at_index = new Vector<Integer>();
            for (Integer x1 : ans)
            {
                mpp.put(x1, j);
                ++j;
            }
            for (Integer x2 : anss)
            {
                value_at_index.add(mpp.get(x2));
            }
            for (Integer x3 : value_at_index)
            {
                System.out.print(x3 + " ");
            }
            System.out.println();
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        Vector<Integer> differences = new Vector<Integer>();
        differences.add(2);
        differences.add(-3);
        differences.add(2);
        int n = differences.size() + 1;
        findPerm(n, differences);
    }
}
