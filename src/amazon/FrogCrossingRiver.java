package amazon;

public class FrogCrossingRiver {
    public boolean canCross(int[] stones) {
        int i = 0, j = 0, n = stones.length, step = 0;
        boolean[][] dp = new boolean[1100][1100];
        dp[0][1] = true;
        for (i=1; i<n; ++i) {
            for (j=0; j<i; ++j) {
                step = stones[i] - stones[j];
                if (step >= n) {
                    continue;
                }
                if (dp[j][step]) {
                    dp[i][step] = true;
                    dp[i][step - 1] = true;
                    dp[i][step + 1] = true;
                }
            }
        }
        for (i=0; i<n; ++i) {
            if (dp[n-1][i]) {
                return true;
            }
        }
        return false;
    }

}
