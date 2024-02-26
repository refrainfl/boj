import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static int N;
    static char[][] board;
    static boolean[][][] visited;
    static int[] result = new int[2];
    static int[][] dxdy = {{0, 0, -1, 1}, {-1, 1, 0, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        visited = new boolean[2][N][N];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[0][i][j]) {
                    result[0]++;
                    dfs(i, j, false);
                }

                if (!visited[1][i][j]) {
                    result[1]++;
                    dfs(i, j, true);
                }

            }
        }

        System.out.println(result[0] + " " + result[1]);

    }

    private static void dfs(int y, int x, boolean hasBlindness) {
        if (!hasBlindness) {
            visited[0][y][x] = true;
        } else {
            visited[1][y][x] = true;
        }

        char currentColor = board[y][x];
        for (int i = 0; i < 4; i++) {
            int ry = y + dxdy[0][i];
            int rx = x + dxdy[1][i];

            if (rangeCheck(ry, rx)
                    && sameCheck(currentColor, board[ry][rx], hasBlindness)
                    && !visitedCheck(ry, rx, hasBlindness)) {
                dfs(ry, rx, hasBlindness);
            }
        }

    }

    private static boolean visitedCheck(int y, int x, boolean hasBlindness) {
        return hasBlindness ? visited[1][y][x] : visited[0][y][x];
    }

    private static boolean sameCheck(char currenColor, char nextColor, boolean hasBlindness) {
        return currenColor == nextColor
                || hasBlindness
                && currenColor != 'B'
                && nextColor != 'B';

    }

    private static boolean rangeCheck(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < N;
    }

}