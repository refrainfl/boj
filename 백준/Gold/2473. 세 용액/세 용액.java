import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Long.parseLong(st.nextToken());
        Arrays.sort(arr);

        long[] result = new long[3];
        long minCost = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int pinned_idx = i;
            int start = 0;
            int end = arr.length - 1;

            while (true) {
                if (start == pinned_idx) start++;
                if (end == pinned_idx) end--;
                if (start >= end) break;


                long currentCost = arr[start] + arr[end] + arr[i];
                if (Math.abs(minCost) > Math.abs(currentCost)) {
                    minCost = currentCost;
                    result[0] = arr[start];
                    result[1] = arr[end];
                    result[2] = arr[i];
                }
                if (minCost == 0) break;

                else if (arr[start] + arr[end] + arr[i] < 0) start++;
                else end--;
            }
        }

        Arrays.sort(result);
        for (long i : result) sb.append(i + " ");
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}