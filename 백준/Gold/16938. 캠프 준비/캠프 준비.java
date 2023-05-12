import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    static int N, L, R, X;
    static int[] arr;
    static int result;


    static void bt(int depth, int first, int last, int sum) {
        if (depth == N && last - first >= X && L <= sum && sum <= R && first != -1 && last != -1) {
            result++;
            return;
        } else if (depth == N || R < sum) return;

        bt(depth + 1, first, last, sum);
        if (first == -1) bt(depth + 1, arr[depth], last, arr[depth]);
        else bt(depth + 1, first, arr[depth], sum + arr[depth]);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        bt(0, -1, -1, 0);
        System.out.println(result);
    }
}