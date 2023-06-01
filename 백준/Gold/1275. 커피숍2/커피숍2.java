import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static long[] tree;
    static long[] arr;


    static long init(int start, int end, int idx) {
        if (start == end) return tree[idx] = arr[start];
        int mid = (start + end) / 2;
        return tree[idx] = init(start, mid, idx * 2) + init(mid + 1, end, idx * 2 + 1);
    }

    static long sum(int start, int end, int idx, int left, int right) {
        if (left > end || right < start) return 0; //범위 안
        if (left <= start && end <= right) return tree[idx]; //범위 밖

        int mid = (start + end) / 2;
        return sum(start, mid, idx * 2, left, right) + sum(mid + 1, end, idx * 2 + 1, left, right);
    }

    static void update(int start, int end, int idx, int target, long value) {
        if (target < start || target > end) return;
        tree[idx] += value;
        if (start == end) return;
        int mid = (start + end) / 2;
        update(start, mid, idx * 2, target, value);
        update(mid + 1, end, idx * 2 + 1, target, value);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new long[N];
        tree = new long[N * 4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Long.parseLong(st.nextToken());
        init(0, N - 1, 1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            sb.append(sum(0, N - 1, 1, Math.min(x, y), Math.max(x, y))).append("\n");

            int a = Integer.parseInt(st.nextToken()) - 1;
            long b = Long.parseLong(st.nextToken());
            long dif = b - arr[a];
            update(0, N - 1, 1, a, dif);
            arr[a] = b;
        }


        System.out.println(sb);
    }
}