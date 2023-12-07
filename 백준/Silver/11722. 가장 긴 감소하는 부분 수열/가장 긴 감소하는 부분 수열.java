import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(findLDS(arr));

    }

    private static int findLDS(int[] arr) {
        int maxLen = arr.length;
        int[] dp = new int[maxLen];
        int LDS = 1;

        for (int i = 0; i < maxLen; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    LDS = Math.max(dp[i], LDS);
                }
            }
        }
        return LDS;
    }
}