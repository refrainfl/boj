import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int[] list;

    static int binary_search(int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (target > list[mid]) start = mid + 1;
            else end = mid;
        }
        return end;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        list = new int[10000001];
        Arrays.fill(list, Integer.MIN_VALUE);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        list[0] = arr[0];
        int idx = 0;
        dp[0] = idx;
        for (int i = 0; i < N; i++) {
            if (arr[i] > list[idx]) {
                list[++idx] = arr[i];
                dp[i] = idx;
            } else {
                int header = binary_search(arr[i], 0, idx);
                list[header] = arr[i];
                dp[i] = header;
            }
        }

        sb.append(idx + 1 + "\n");

        int[] result = new int[idx + 1];
        int prev = Integer.MAX_VALUE;

        for (int i = N - 1; i >= 0; i--) {
            if (idx < 0) break;
            if (idx == dp[i] && arr[i] < prev) {
                result[idx] = arr[i];
                prev = result[idx];
                idx--;
            }
        }
        for (int i : result) sb.append(i + " ");
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);

    }
}