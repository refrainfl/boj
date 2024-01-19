import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        final int MAX_HP = 99;
        int[] dp = new int[MAX_HP + 1];
        int N = Integer.parseInt(br.readLine());

        StringTokenizer weightToken = new StringTokenizer(br.readLine());
        StringTokenizer valueToken = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int w = Integer.parseInt(weightToken.nextToken());
            int v = Integer.parseInt(valueToken.nextToken());
            knapsack(dp, w, v);
        }

        System.out.println(dp[MAX_HP]);
    }

    private static void knapsack(int[] dp, int w, int v) {
        for (int i = dp.length - 1; w <= i; i--) {
            dp[i] = Math.max(dp[i - w] + v, dp[i]);
        }
    }
}