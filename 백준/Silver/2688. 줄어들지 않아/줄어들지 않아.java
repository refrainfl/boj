import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static int MAX_SIZE = 74;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        long[][] dp = new long[MAX_SIZE][MAX_SIZE];
        dp[0][0] = 1;
        dp[1][0] = 1;

        for (int i = 1; i < MAX_SIZE; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) dp[i][j] = 1;
                else dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(dp[num + 9][9]).append("\n");
        }
        System.out.println(sb);

    }
}