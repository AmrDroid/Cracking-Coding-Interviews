package amazon;

import java.util.Arrays;
import java.util.Vector;

public class ValidTriangle {
    public int triangleNumber(int[] nums) {
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


}
