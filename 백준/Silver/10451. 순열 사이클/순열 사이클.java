import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

class Main {

    static int[] arr;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N];
            visited = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken()) - 1;
            }

            for (int i = 0; i < N; i++) {
                if (visited[i] == 0) dfs(i, i);
            }

            int[] result = IntStream.of(visited).distinct().toArray();
            sb.append(result.length).append("\n");
        }

        System.out.println(sb);

    }

    private static void dfs(int start, int cur) {
        if (visited[cur] == start) return;
        visited[cur] = start;
        dfs(start, arr[cur]);
    }

}