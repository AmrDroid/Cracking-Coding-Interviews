class Solution {
    public int[][] merge(int[][] intervals) {
        
        int index=0;
        int n=intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for(int i=0;i<n;i++)
        {
            if(intervals[index][1]>=intervals[i][0])
            {
                intervals[index][1]=Math.max(intervals[index][1],intervals[i][1]);
                intervals[index][0]=Math.min(intervals[index][0],intervals[i][0]);
            }
            else
            {
                index++;
                intervals[index][0]=intervals[i][0];
                intervals[index][1]=intervals[i][1];                    
            }
    }
        int res[][]=new int[index+1][2];
        for(int i=0;i<=index;i++){
            res[i][0]=intervals[i][0];
            res[i][1]=intervals[i][1];
        }
        return res;
}}