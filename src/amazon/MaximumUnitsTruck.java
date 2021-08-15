package amazon;

import java.util.PriorityQueue;

//https://justanothergeek.hashnode.dev/maximum-units-on-a-truck
public class MaximumUnitsTruck {
  static   public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> Integer.compare(y[1], x[1]));
        // Store boxTypes array in the priority queue in descending order.
        for (int[] boxType : boxTypes) {
            queue.add(boxType);
        }
        int maximumUnits = 0;
        // Continue operation till the queue is empty or till there is no space left in the truck
        while ((!queue.isEmpty()) && (truckSize > 0)) {
            int[] item = queue.poll();
            int spaceToFill = Math.min(truckSize, item[0]);
            maximumUnits += spaceToFill * item[1];
            truckSize -= spaceToFill;
        }
        return maximumUnits;
    }


    public static void main(String[] args) {
        int [][] boxTypes = {{1,3},{2,2}, {3,1}};
        int truckSize =4;
        System.out.println(maximumUnits(boxTypes,truckSize));


    }
}
