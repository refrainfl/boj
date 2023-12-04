import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {

    //0-1 BFS

    static final int MAX_SIZE = 100000;
    static final int NOT_VISITED = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        System.out.println(bfs(N, K));

    }

    private static int bfs(int n, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int[] distance = new int[MAX_SIZE + 1];
        Arrays.fill(distance, NOT_VISITED);
        distance[n] = 0;
        dq.add(n);

        while (!dq.isEmpty()) {
            int current = dq.poll();
            int currentDistance = distance[current];

            if (current == k) {
                return currentDistance;
            }

            int teleport = current * 2;
            if (isPositionAvailable(teleport) && distance[teleport] == NOT_VISITED) {
                distance[teleport] = currentDistance;
                dq.addFirst(teleport);
            }

            int left = current - 1;
            if (isPositionAvailable(left) && distance[left] == NOT_VISITED) {
                distance[left] = currentDistance + 1;
                dq.add(left);
            }

            int right = current + 1;
            if (isPositionAvailable(right) && distance[right] == NOT_VISITED) {
                distance[right] = currentDistance + 1;
                dq.add(right);
            }

        }

        return distance[k];
    }

    private static boolean isPositionAvailable(int position) {
        if (position < 0 || MAX_SIZE < position) return false;
        return true;
    }

}