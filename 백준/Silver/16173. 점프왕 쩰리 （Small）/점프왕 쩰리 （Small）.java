import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int N;
    static int[][] board;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        if (flag) System.out.println("HaruHaru");
        else System.out.println("Hing");
    }

    private static void dfs(int x, int y) {
        if (flag) return;
        if (board[x][y] == -1) {
            flag = true;
            return;
        }

        int jump = board[x][y];
        int dx = x + jump;
        int dy = y + jump;

        if (dx != x && dx < N) dfs(dx, y);
        if (dy != y && dy < N) dfs(x, dy);
    }
}