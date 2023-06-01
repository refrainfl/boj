import java.io.*;
import java.util.*;

class Main {
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;

    static boolean dfs(int root, int node) {
        for (int next : list.get(node)) {
            if (next == root) continue;
            if (visited[next]) return false;
            visited[next] = true;
            if (!dfs(node, next)) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCase = 1;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); //정점 수
            int M = Integer.parseInt(st.nextToken()); // 간선 수
            if (N == 0 && M == 0) break;

            visited = new boolean[N];
            list = new ArrayList<>();
            for (int i = 0; i < N; i++) list.add(new ArrayList<>());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken()) - 1;
                list.get(u).add(v);
                list.get(v).add(u);
            }

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    if (dfs(-1, i)) cnt++;
                }
            }

            sb.append("Case " + testCase + ": ");
            if (cnt <= 0) sb.append("No trees.\n");
            else if (cnt == 1) sb.append("There is one tree.\n");
            else sb.append("A forest of " + cnt + " trees.\n");
            testCase++;
        }
        System.out.println(sb);
    }
}
