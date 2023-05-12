import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    static int N;
    static char[] arr;
    static boolean[] visited;
    static int result;

    static void find(int depth, char recentSelectedChar) {
        if (depth == N) {
            result++;
            return;
        }

        int prevItem = '\0';
        for (int i = 0; i < N; i++) {
            if (visited[i] || prevItem == arr[i]) continue;

            if (recentSelectedChar != arr[i]) {
                visited[i] = true;
                find(depth + 1, arr[i]);
                visited[i] = false;
                prevItem = arr[i];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = br.readLine().toCharArray();
        Arrays.sort(arr);
        N = arr.length;
        visited = new boolean[N];

        find(0, '\0');
        System.out.println(result);
    }
}