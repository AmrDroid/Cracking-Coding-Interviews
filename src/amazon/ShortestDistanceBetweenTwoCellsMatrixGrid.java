package amazon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// QItems for current location and distance
// from source location
class QItems {
    int row;
    int col;
    int dist;

    public QItems(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

 class Maze2 {
    private static int minDistance(char[][] grid) {
        QItems source = new QItems(0, 0, 0);

        // To keep track of visited QItemss. Marking
        // blocked cells as visited.
//        firstLoop:
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//
//                // Finding source
//                if (grid[i][j] == '1') {
////                    source.row = i;
////                    source.col = j;
//              //      break firstLoop;
//                }
//            }
//        }

        source.row = 0;
        source.col = 3;
        // applying BFS on matrix cells starting from source
        Queue<QItems> queue = new LinkedList<>();
        queue.add(new QItems(source.row, source.col, 0));

        boolean[][] visited
                = new boolean[grid.length][grid[0].length];
        visited[source.row][source.col] = true;

        while (queue.isEmpty() == false) {
            QItems p = queue.remove();

            // Destination found;
            if (grid[p.row][p.col] == '9')
                return p.dist;

            // moving up
            if (isValid(p.row - 1, p.col, grid, visited)) {
                queue.add(new QItems(p.row - 1, p.col,
                        p.dist + 1));
                visited[p.row - 1][p.col] = true;
            }

            // moving down
            if (isValid(p.row + 1, p.col, grid, visited)) {
                queue.add(new QItems(p.row + 1, p.col,
                        p.dist + 1));
                visited[p.row + 1][p.col] = true;
            }

            // moving left
            if (isValid(p.row, p.col - 1, grid, visited)) {
                queue.add(new QItems(p.row, p.col - 1,
                        p.dist + 1));
                visited[p.row][p.col - 1] = true;
            }

            // moving right
            if (isValid(p.row - 1, p.col + 1, grid,
                    visited)) {
                queue.add(new QItems(p.row, p.col + 1,
                        p.dist + 1));
                visited[p.row][p.col + 1] = true;
            }
        }
        return -1;
    }

    // checking where it's valid or not
    private static boolean isValid(int x, int y,
                                   char[][] grid,
                                   boolean[][] visited) {
        if (x >= 0 && y >= 0 && x < grid.length
                && y < grid[0].length && grid[x][y] != '0'
                && visited[x][y] == false) {
            return true;
        }
        return false;
    }

    // Driver code
    public static void main(String[] args) {
        char[][] grid = {
                {'0', '1', '0', '1'},
                {'1', '0', '1', '1'},
                {'0', '1', '1', '1'},
                {'9', '1', '1', '1'}};

        System.out.println(minDistance(grid));
    }
}