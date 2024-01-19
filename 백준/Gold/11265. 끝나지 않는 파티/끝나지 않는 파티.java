import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] distance = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                distance[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }

        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int current = Integer.parseInt(st.nextToken()) - 1;
            int next = Integer.parseInt(st.nextToken()) - 1;
            int time = Integer.parseInt(st.nextToken());
            if (distance[current][next] > time) sb.append("Stay here").append("\n");
            else sb.append("Enjoy other party").append("\n");
        }

        System.out.println(sb);

    }
}