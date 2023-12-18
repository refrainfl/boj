import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static final int[] dx = new int[]{0, 1, 0, -1};
    static final int[] dy = new int[]{1, 0, -1, 0};
    static final int boardSize = 5;
    static final int[][] board = new int[boardSize][boardSize];
    static boolean[] visited = new boolean[1000000];
    static int cnt;


    public static void main(String[] args) throws IOException {
        input();
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                makeString(i, j, 0, 0);
            }
        }
        System.out.println(cnt);

    }

    private static void makeString(int x, int y, int depth, int val) {
        if (depth == 6) {
            if (!visited[val]) {
                visited[val] = true;
                cnt++;
            }
            return;
        }

        val += (int) (board[x][y] * (Math.pow(10,depth)));

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < boardSize && 0 <= ny && ny < boardSize) {
                makeString(nx, ny, depth + 1, val);
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < boardSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}