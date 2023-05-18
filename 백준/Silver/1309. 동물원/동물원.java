import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static final int C = 9901;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[100001];

        dp[0] = 1;
        dp[1] = 3;
        for (int i = 2; i < N + 1; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1] * 2) % C;
        }

        System.out.println(dp[N]);
    }
}