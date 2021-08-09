package amazon;

import java.util.Arrays;
import java.util.Vector;
//https://www.geeksforgeeks.org/find-number-of-triangles-possible/
public class ValidTriangle {
  static   public int triangleNumber(int[] nums) {
        if(nums == null || nums.length < 3)
            return 0;
        int ret = 0;
        Arrays.sort(nums);
        for(int right = nums.length - 1; right >= 2; right--) {
            int left = 0, medium = right - 1;
            while(left < medium) {
                if(nums[left] + nums[medium] > nums[right]) {
                    ret += medium - left;
                    medium --;
                }else {
                    left ++;
                }
            }
        }
        return ret;
    }
    // Function to count all possible
    // triangles with arr[] elements
    static int findNumberOfTriangles(int arr[], int n)
    {
        // Count of triangles
        int count = 0;

        // The three loops select three
        // different values from array
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                // The innermost loop checks for
                // the triangle property
                for (int k = j + 1; k < n; k++)

                    // Sum of two sides is greater
                    // than the third
                    if (
                            arr[i] + arr[j] > arr[k]
                                    && arr[i] + arr[k] > arr[j]
                                    && arr[k] + arr[j] > arr[i])
                        count++;
            }
        }
        return count;
    }

    // Driver code
    public static void main(String[] args)
    {
        int arr[] = { 10, 21, 22, 100, 101, 200, 300 };
        int size = arr.length;

        System.out.println( "Total number of triangles possible is "+
                findNumberOfTriangles(arr, size));


        System.out.println( "Total number of triangles possible is "+
                triangleNumber(arr));
    }

}
