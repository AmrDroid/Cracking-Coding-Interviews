package amazon;

import java.util.ArrayList;
import java.util.List;

public class OptimalUtilization {

    public static List<List<Integer>> optimalUtilization(int deviceCapacity,
                                                         List<List<Integer>> foregroundAppList,
                                                         List<List<Integer>> backgroundAppList) {
        List<List<Integer>> result = new ArrayList<>();
        int max = 0;
        for (List<Integer> fg : foregroundAppList) {

            for (List<Integer> bg : backgroundAppList) {
                int sum = bg.get(1) + fg.get(1);
                if (sum > deviceCapacity) continue;
                if (sum > max) {
                    max = sum;
                    result.clear();
                    List<Integer> list = new ArrayList<>();
                    list.add(fg.get(0));
                    list.add(bg.get(0));
                    result.add(list);
                } else if (sum == max) {
                    List<Integer> list = new ArrayList<>();
                    list.add(fg.get(0));
                    list.add(bg.get(0));
                    result.add(list);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int capacity = 10;
        List<List<Integer>> foregroundAppList = new ArrayList<>();

        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(3);

        List<Integer> l2 = new ArrayList<>();
        l2.add(2);
        l2.add(5);

        List<Integer> l3 = new ArrayList<>();
        l3.add(3);
        l3.add(7);
        List<Integer> l4 = new ArrayList<>();
        l4.add(4);
        l4.add(10);

        foregroundAppList.add(l1);
        foregroundAppList.add(l2);
        foregroundAppList.add(l3);
        foregroundAppList.add(l4);

        List<Integer> b1 = new ArrayList<>();
        b1.add(1);
        b1.add(2);

        List<Integer> b2 = new ArrayList<>();
        b2.add(2);
        b2.add(3);

        List<Integer> b3 = new ArrayList<>();
        b3.add(3);
        b3.add(4);

        List<Integer> b4 = new ArrayList<>();
        b4.add(4);
        b4.add(5);

        List<List<Integer>> backgroundAppList = new ArrayList<>();
        backgroundAppList.add(b1);
        backgroundAppList.add(b2);
        backgroundAppList.add(b3);
        backgroundAppList.add(b4);

        List<List<Integer>> res = optimalUtilization(capacity, foregroundAppList, backgroundAppList);

        for (List<Integer> list : res) {
            for (int i : list)
                System.out.print(i + " , ");
            System.out.println();
        }

    }
}
