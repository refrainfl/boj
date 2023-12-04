import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static final int MAXSIZE = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        System.out.println(bfs(N, K));

    }

    private static int bfs(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        int[] distance = new int[MAXSIZE + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[n] = 0;
        q.add(n);

        while (!q.isEmpty()) {
            int current = q.poll();
            int currentDistance = distance[current];

            int left = current - 1;
            int right = current + 1;
            int teleport = current * 2;

            if (isPositionAvailable(left) && currentDistance + 1 < distance[left]) {
                distance[left] = currentDistance + 1;
                q.add(left);
            }

            if (isPositionAvailable(right) && currentDistance + 1 < distance[right]) {
                distance[right] = currentDistance + 1;
                q.add(right);
            }

            if (isPositionAvailable(teleport) && currentDistance < distance[teleport]) {
                distance[teleport] = currentDistance;
                q.add(teleport);
            }
        }

        return distance[k];
    }

    private static boolean isPositionAvailable(int position) {
        if (position < 0 || MAXSIZE < position) return false;
        return true;
    }
}