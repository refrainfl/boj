import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static int Y, X, check;
    static int arr[][];
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {-1, 1, 0, 0};

    static void paintSquare(int y1, int x1, int y2, int x2) {
        for (int i = y1; i < y2; i++) {
            for (int j = x1; j < x2; j++) {
                arr[i][j] = -1;
            }
        }
    }

    static void dfs(int y, int x, int v) {
        if (y >= Y || y < 0 || x >= X || x < 0 || arr[y][x] != 0) return;
        arr[y][x] = v;
        check++;

        for (int i = 0; i < 4; i++) {
            dfs(y + dy[i], x + dx[i], v + 1);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> resultQ = new PriorityQueue<>();
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new int[Y][X];
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            paintSquare(y1, x1, y2, x2);
        }


        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (arr[i][j] == 0) {
                    check = 0;
                    dfs(i, j, 1);
                    resultQ.add(check);
                }
            }
        }

        sb.append(resultQ.size()).append("\n");
        
        while (!resultQ.isEmpty()) {
            sb.append(resultQ.poll()).append(" ");
        }
        
        System.out.println(sb);
    }
}