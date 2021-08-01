package amazon;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class GFG2
{
    int val;
    int steps;

    public GFG2(int val, int steps)
    {
        this.val = val;
        this.steps = steps;
    }
}

public class MinNumOpConvert {
    private static int minOperations(int src,
                                     int target) {

        Set<GFG2> visited = new HashSet<>(1000);
        LinkedList<GFG2> queue = new LinkedList<>();

        GFG2 node = new GFG2(src, 0);

        queue.offer(node);
        visited.add(node);

        while (!queue.isEmpty()) {
            GFG2 temp = queue.poll();
            visited.add(temp);

            if (temp.val == target) {
                return temp.steps;
            }

            int mul = temp.val * 2;
            int sub = temp.val - 1;

            // given constraints
            if (mul > 0 && mul < 1000) {
                GFG2 nodeMul = new GFG2(mul, temp.steps + 1);
                queue.offer(nodeMul);
            }
            if (sub > 0 && sub < 1000) {
                GFG2 nodeSub = new GFG2(sub, temp.steps + 1);
                queue.offer(nodeSub);
            }
        }
        return -1;
    }

    // Driver code
    public static void main(String[] args) {
        // int x = 2, y = 5;
        int x = 4, y = 7;
        GFG2 src = new GFG2(x, y);
        System.out.println(minOperations(x, y));
    }
}