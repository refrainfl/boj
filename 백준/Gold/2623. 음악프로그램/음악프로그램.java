import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {

    static Stack<Integer> stack;
    static List<List<Integer>> nodeList;
    static boolean[] visited;
    static boolean[] finished;
    static boolean hasCycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        finished = new boolean[N + 1];
        nodeList = new ArrayList<>();
        stack = new Stack<>();

        for (int i = 0; i < N + 1; i++) {
            nodeList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();

            int currentNode = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int nextNode = Integer.parseInt(st.nextToken());
                nodeList.get(currentNode).add(nextNode);
                currentNode = nextNode;
            }
        }

        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) dfs(i);
        }


        if (hasCycle) {
            sb.append(0);
        } else {
            while (!stack.isEmpty()) {
                sb.append(stack.pop() + "\n");
            }
        }

        System.out.println(sb);

    }

    private static void dfs(int position) {
        visited[position] = true;
        List<Integer> currentNode = nodeList.get(position);

        for (Integer nextNode : currentNode) {
            if (!visited[nextNode]) {
                dfs(nextNode);
            }

            if (visited[nextNode] && !finished[nextNode]) {
                hasCycle = true;
            }
        }
        stack.add(position);
        finished[position] = true;
    }

}