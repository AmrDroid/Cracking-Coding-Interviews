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































//    Check if all enemies are killed with bombs placed in a matrix
// Function to find Enemies killed or not
static int Kill_Enemy(char [][]s, int row, int col)
{

    int i, j, x, y;

    // Loop to evaluate the Bomb
    for (i = 0; i < row; i++)
    {
        for (j = 0; j < col; j++)
        {

            // Check if this index is a bomb
            if (s[i][j] == 'B')
            {

                // Kill all enemies
                // in horizontal direction
                for (x = 0; x < row; x++)
                {
                    if (s[x][j] != 'B')
                        s[x][j] = 'X';
                }

                // Kill all enemies
                // in vertical direction
                for (y = 0; y < col; y++)
                {
                    if (s[i][y] != 'B')
                        s[i][y] = 'X';
                }
            }
        }
    }

    // All bombs have been found

    // Check if any enemy is still present
    for (i = 0; i < row; i++)
    {
        for (j = 0; j < col; j++)
        {

            if (s[i][j] == 'E')

                // Since an enemy is present
                // Return 0 denoting No as output
                return 0;
        }
    }

    // Since all enemies are killed
    // Return 1 denoting Yes as output
    return 1;
}

    // Driver Code
    public static void main(String[] args)
    {
        // Get the input matrix
        char [][]s = { "XXEX".toCharArray(),
                "XBXX".toCharArray(),
                "XEXX".toCharArray(),
                "XXBX".toCharArray() };

        // Calculate Rows and columns of the String
        int row = s.length,
                col = s[0].length;

        // Check if all enemies will be killed or not
        if (Kill_Enemy(s, row, col) == 1)
            System.out.print("Yes");
        else
            System.out.print("No");
    }


}
