import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int N;
    static char[][] board;

    static boolean[][] visitedNormal;
    static boolean[][] visitedBlindness;

    static int normalSection;
    static int blindnessSection;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        visitedNormal = new boolean[N][N];
        visitedBlindness = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                if (!visitedNormal[i][j]) {
                    normalSection++;
                    dfs(i, j, false);
                }

                if (!visitedBlindness[i][j]) {
                    blindnessSection++;
                    dfs(i, j, true);
                }

            }
        }

        System.out.println(normalSection + " " + blindnessSection);

    }

    private static void dfs(int y, int x, boolean hasBlindness) {
        if (!hasBlindness) {
            visitedNormal[y][x] = true;
        } else {
            visitedBlindness[y][x] = true;
        }

        char currentColor = board[y][x];
        for (int i = 0; i < 4; i++) {
            
            int ry = y + dy[i];
            int rx = x + dx[i];

            if (rangeCheck(ry, rx)
                    && sameCheck(currentColor, board[ry][rx], hasBlindness)
                    && !visitedCheck(ry, rx, hasBlindness)) {
                dfs(ry, rx, hasBlindness);
            }
        }

    }

    private static boolean visitedCheck(int y, int x, boolean hasBlindness) {
        return hasBlindness ? visitedBlindness[y][x] : visitedNormal[y][x];
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