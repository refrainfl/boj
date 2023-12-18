import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {

    static final int boardSize = 5;
    static final int[] dx = new int[]{0, 1, 0, -1};
    static final int[] dy = new int[]{1, 0, -1, 0};
    static int[][] board = new int[boardSize][boardSize];
    static HashSet<String> resultMap = new HashSet<>();


    public static void main(String[] args) throws IOException {

        input();
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                makeString(i, j, 0, "");
            }
        }
        System.out.println(resultMap.size());

    }

    private static void makeString(int x, int y, int depth, String result) {
        if (depth == 6) {
            resultMap.add(result);
            return;
        }

        result += board[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < boardSize && 0 <= ny && ny < boardSize) {
                makeString(nx, ny, depth + 1, result);
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