import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int Y, X, cnt;
    static char[][] arr;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static void dfs(int y, int x) {
        arr[y][x] = '.';

        for (int i = 0; i < 4; i++) {
            int ry = y + dy[i];
            int rx = x + dx[i];
            if (0 <= ry && ry < Y && 0 <= rx && rx < X && arr[ry][rx] == '#') dfs(ry, rx);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            Y = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            arr = new char[Y][X];

            for (int i = 0; i < Y; i++) {
                arr[i] = br.readLine().toCharArray();
            }

            cnt = 0;
            for (int i = 0; i < Y; i++) {
                for (int j = 0; j < X; j++) {
                    if (arr[i][j] == '#') {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}