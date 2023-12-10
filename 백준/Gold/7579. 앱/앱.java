import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int maxMemorySize;
    static int maxCost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] memory = new int[N][2];

        st = new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            maxMemorySize += memory[i][0] = Integer.parseInt(st.nextToken());
            maxCost += memory[i][1] = Integer.parseInt(st2.nextToken());
        }

        System.out.println(calc(memory, M));
    }

    private static int calc(int[][] memory, int M) {
        int[] dp = new int[maxMemorySize + 1];
        Arrays.fill(dp, maxCost);
        dp[0] = 0;

        for (int[] app : memory) {
            int w = app[0];
            int v = app[1];

            for (int i = dp.length - 1; i >= w; i--) {
                dp[i] = Math.min(dp[i], dp[i - w] + v);
            }
        }

        for (int i = dp.length - 1; i > 0; i--) {
            dp[i - 1] = Math.min(dp[i], dp[i - 1]);

        }

        return dp[M];
    }
}