import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int maxValue;
    static int[] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            knapsack(w, v);
        }

        System.out.println(maxValue);
    }


    private static void knapsack(int w, int v) {
        for (int i = dp.length - 1; w <= i; i--) {
            dp[i] = Math.max(dp[i - w] + v, dp[i]);
            maxValue = Math.max(dp[i], maxValue);
        }
    }
}