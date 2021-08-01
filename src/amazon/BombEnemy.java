package amazon;

public class BombEnemy {

    public int maxKilledEnemies(char[][] grid) {
        // Write your code here
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        int[] cols = new int[n];
        int max = 0;
        int row = 0;

        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                if(grid[i][j] == 'W')    continue;
                if(i == 0 || grid[i - 1][j] == 'W') {
                    cols[j] = countCol(grid, i, j);
                }
                if(j == 0 || grid[i][j - 1] == 'W') {
                    row = countRow(grid, i, j);
                }
                if(grid[i][j] == '0') {
                    max = Math.max(max, cols[j] + row);
                }
            }
        }

        return max;
    }

    private int countCol(char[][] grid, int i, int j) {
        int sum = 0;
        while(i < grid.length && grid[i][j] != 'W') {
            if(grid[i][j] == 'E')   sum ++;
            i ++;
        }
        return sum;
    }

    private int countRow(char[][] grid, int i, int j) {
        int sum = 0;
        while(j < grid[0].length && grid[i][j] != 'W') {
            if(grid[i][j] == 'E')   sum ++;
            j ++;
        }
        return sum;
    }

}
