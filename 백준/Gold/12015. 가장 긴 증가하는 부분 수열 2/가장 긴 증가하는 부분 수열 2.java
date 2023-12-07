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

        System.out.println(findLIS(arr));

    }

    private static int findLIS(int[] arr) {
        int maxLen = arr.length;
        int[] dp = new int[maxLen];
        dp[0] = arr[0];

        int LIS = 1;
        for (int i = 1; i < arr.length; i++) {
            if (dp[LIS - 1] < arr[i]) {
                dp[LIS++] = arr[i];
            } else {
                int idx = LowerBound(dp, arr[i], 0, LIS);
                dp[idx] = arr[i];
            }

        }

        return LIS;
    }

    private static int LowerBound(int[] dp, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (dp[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end + 1;
    }
}