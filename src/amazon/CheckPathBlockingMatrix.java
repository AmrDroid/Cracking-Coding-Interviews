package amazon;

import java.util.LinkedList;
import java.util.Queue;

public class CheckPathBlockingMatrix {

    static boolean isPath(int arr[][]) {
        // set arr[0][0] = 1
        arr[0][0] = 1;

        // Mark reachable (from top left) nodes
        // in first row and first column.
        for (int i = 1; i < 5; i++)
            if (arr[0][i] != -1)
                arr[0][i] = arr[0][i - 1];
        for (int j = 1; j < 5; j++)
            if (arr[j][0] != -1)
                arr[j][0] = arr[j - 1][0];

        // Mark reachable nodes in
        //  remaining matrix.
        for (int i = 1; i < 5; i++)
            for (int j = 1; j < 5; j++)
                if (arr[i][j] != -1)
                    arr[i][j] = Math.max(arr[i][j - 1],
                            arr[i - 1][j]);

        // return yes if right
        // bottom index is 1
        return (arr[5 - 1][5 - 1] == 1);
    }

    //Driver code
    public static void main(String[] args) {
        // Given array
        int arr[][] = {{0, 0, 0, -1, 0},
                {-1, 0, 0, -1, -1},
                {0, 0, 0, -1, 0},
                {-1, 0, 0, 0, 0},
                {0, 0, -1, 0, 0}};

        // path from arr[0][0]
        // to arr[row][col]
        if (isPath(arr))
            System.out.println("Yes");
        else
            System.out.println("No");


        int M[][] =
              { { 0, 3, 0, 1 },
                { 3, 0, 3, 3 },
                { 2, 3, 3, 3 },
                { 0, 3, 3, 3 } };



        if (findPath(M) == true)
            System.out.println("Yes");
        else
            System.out.println("No");
    }









    static int R = 4, C = 4;
    BFSElement b;

    static boolean findPath(int M[][])
    {

        // 1) Create BFS queue q
        Queue<BFSElement> q = new LinkedList<>();

        // 2)scan the matrix
        for (int i = 0; i < R; ++i)
        {
            for (int j = 0; j < C; ++j)
            {

                // if there exists a cell in the matrix such
                // that its value is 1 then push it to q
                if (M[i][j] == 1) {
                    q.add(new BFSElement(i, j));
                    break;
                }
            }

        }

        // 3) run BFS algorithm with q.
        while (q.size() != 0)
        {
            BFSElement x = q.peek();
            q.remove();
            int i = x.i;
            int j = x.j;

            // skipping cells which are not valid.
            // if outside the matrix bounds
            if (i < 0 || i >= R || j < 0 || j >= C)
                continue;

            // if they are walls (value is 0).
            if (M[i][j] == 0)
                continue;

            // 3.1) if in the BFS algorithm process there was a
            // vertex x=(i,j) such that M[i][j] is 2 stop and
            // return true
            if (M[i][j] == 2)
                return true;

            // marking as wall upon successful visitation
            M[i][j] = 0;

            // pushing to queue u=(i,j+1),u=(i,j-1)
            // u=(i+1,j),u=(i-1,j)
            for (int k = -1; k <= 1; k += 2)
            {
                q.add(new BFSElement(i + k, j));
                q.add(new BFSElement(i, j + k));
            }
        }

        // BFS algorithm terminated without returning true
        // then there was no element M[i][j] which is 2, then
        // return false
        return false;

    }


}











class BFSElement
{
    int i, j;
    BFSElement(int i, int j)
    {
        this.i = i;
        this.j = j;
    }
}

