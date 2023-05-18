import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static final int MAX = 20000001;
    static int N;
    static int[] arr;
    static int[] cnt = new int[MAX];
    
    static void bt(int depth, int sum) {
        if (depth == N) {
            cnt[sum]++;
            return;
        } else {
            bt(depth + 1, sum);
            bt(depth + 1, sum + arr[depth]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bt(0, 0);
        int result = -1;
        for (int i = 1; i < MAX; i++) {
            if (cnt[i] == 0) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}