import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static int N;
    static List<List<Integer>> list;
    static boolean[] visited;
    static int result;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            list.get(node1).add(node2);
            list.get(node2).add(node1);
        }

        dfs(1, 0);

        if (result % 2 == 0) System.out.println("No");
        else System.out.println("Yes");

    }

    private static void dfs(int node, int depth) {
        visited[node] = true;
        if (node != 1 && list.get(node).size() == 1) {
            result += depth;
            return;
        }
        for (int nextNode : list.get(node)) {
            if (!visited[nextNode]) {
                dfs(nextNode, depth + 1);
            }
        }
    }
}