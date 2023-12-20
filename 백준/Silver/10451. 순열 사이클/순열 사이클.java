import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N];
            visited = new boolean[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken()) - 1;
            }

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    dfs(i);
                    cnt++;
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);

    }

    private static void dfs(int cur) {
        if (visited[cur]) return;
        visited[cur] = true;
        dfs(arr[cur]);
    }

}