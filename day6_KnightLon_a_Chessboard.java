import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the knightlOnAChessboard function below.
    static int[][] knightlOnAChessboard(int n) {
        int[][] ret = new int[n - 1][n - 1];

        for (int r = 1; r < n; r++) {
            for (int c = 1; c < n; c++) {
                if (ret[c - 1][r - 1] != 0) {
                    ret[r-1][c-1] = ret[c-1][r-1];
                    continue;
                }
                if (ret[r-1][c-1] == 0) {
                    ret[r-1][c-1] = move(n, r, c);
                }
            }
        }
        return ret;


    }
    static int move(int n, int a, int b) {
        int[][] dirs = {{a, b}, {-a, -b}, {a, -b}, {-a, b},  {b, a}, {-b, -a}, {b, -a}, {-b, a}};

        boolean[][] visited = new boolean[n][n];
        int[][] dist = new int[n][n];

        int er = n - 1;
        int ec = n - 1;
        for (int[] row: dist) {
            Arrays.fill(row, - 1);
        }
        
        visited[0][0] = true;
        dist[0][0] = 0;

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.remove();
            if (cur[0] == er && cur[1] == ec) {
                return dist[er][ec];
            }

            for(int[] dir: dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];

                if (x >= 0 && y >= 0 && x < n && y < n && !visited[x][y]) {
                    visited[x][y] = true;
                    q.add(new int[]{x, y});
                    dist[x][y] = dist[cur[0]][cur[1]] + 1;
                }
            }
        }

        return -1;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] result = knightlOnAChessboard(n);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                bufferedWriter.write(String.valueOf(result[i][j]));

                if (j != result[i].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
