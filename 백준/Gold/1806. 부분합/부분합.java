import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int target;
    static int[] arr;

    static int calc() {
        int start = 0;
        int end = 1;
        int ans = Integer.MAX_VALUE;
        while (start < end && end <= N) {
            int temp = arr[end] - arr[start];
            if (target <= temp) {
                ans = Math.min(ans, end - start);
                start++;
            } else if (target > temp) end++;
            else start++;
        }

        if (ans == Integer.MAX_VALUE) return 0;
        else return ans;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        arr[0] = 0;
        st = new StringTokenizer(br.readLine());
        arr[1] = Integer.parseInt(st.nextToken());
        for (int i = 2; i <= N; i++) arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        System.out.println(calc());
    }
}