import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = str.length();
        int[] arr = new int[41];
        int[] dp = new int[41];

        for (int i = 1; i <= N; i++) {
            arr[i] = Character.getNumericValue(str.charAt(i - 1));
            if (arr[i] == 0) arr[i - 1] *= 10;
        }

        dp[0] = 1;
        dp[1] = 1;
        int result = 1;
        for (int i = 2; i <= N; i++) {
            int check = arr[i - 1] * 10 + arr[i];
            if (arr[i] > 9 || arr[i] == 0 || arr[i - 1] == 0 || check > 34) {
                dp[i] = dp[i - 1];
                continue;
            }
            dp[i] = dp[i - 1] + dp[i - 2];
            result = Math.max(dp[i], result);
        }

        System.out.println(result);
    }
}