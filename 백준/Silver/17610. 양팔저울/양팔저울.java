import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int N, MAX, result;
    static int[] arr;
    static int[] cnt;

    static void bt(int depth, int sum) {
        if (sum < 0 && Math.abs(sum) > MAX + sum) return;
        if (depth == N && sum > 0 && cnt[sum] == 0) {
            cnt[sum] = 1;
            result++;
            return;
        }
        if (depth < N) {
            bt(depth + 1, sum);
            bt(depth + 1, sum - arr[depth]);
            bt(depth + 1, sum + arr[depth]);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        MAX = 0;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            MAX += arr[i];
        }
        
        cnt = new int[MAX + 1];
        
        bt(0, 0);
        System.out.println(MAX - result);
    }
}