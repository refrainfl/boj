import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static long[] arr;
    static long[] tree;
    static long[] lazy;

    static long init(int start, int end, int idx) {
        if (start == end) return tree[idx] = arr[start];
        int mid = (start + end) / 2;
        return tree[idx] = init(start, mid, idx * 2) + init(mid + 1, end, idx * 2 + 1);
    }


    static void lazy_update(int start, int end, int idx) {
        if (lazy[idx] != 0) {
            tree[idx] += (end - start + 1) * lazy[idx];
            if (start != end) {
                lazy[idx * 2] += lazy[idx];
                lazy[idx * 2 + 1] += lazy[idx];
            }
            lazy[idx] = 0;
        }
    }

    static void update(int start, int end, int idx, int left, int right, long dif) {
        lazy_update(start, end, idx);
        if (left > end || right < start) return;
        if (left <= start && end <= right) {
            tree[idx] += (end - start + 1) * dif;
            if (start != end) {
                lazy[idx * 2] += dif;
                lazy[idx * 2 + 1] += dif;
            }
            return;
        }
        int mid = (start + end) / 2;
        update(start, mid, idx * 2, left, right, dif);
        update(mid + 1, end, idx * 2 + 1, left, right, dif);
        tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
    }

    static long sum(int start, int end, int idx, int left, int right) {
        lazy_update(start, end, idx);
        if (left > end || right < start) return 0; //범위 밖
        if (left <= start && end <= right) return tree[idx]; //범위 안
        int mid = (start + end) / 2;
        return sum(start, mid, idx * 2, left, right) + sum(mid + 1, end, idx * 2 + 1, left, right);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        M += Integer.parseInt(st.nextToken());
        arr = new long[N];
        tree = new long[N * 4];
        lazy = new long[N * 4];

        for (int i = 0; i < N; i++) arr[i] = Long.parseLong(br.readLine());
        init(0, N - 1, 1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            if (a == 1) {
                long d = Long.parseLong(st.nextToken());
                update(0, N - 1, 1, b, c, d);

            } else sb.append(sum(0, N - 1, 1, b, c) + "\n");
        }
        System.out.println(sb);
    }
}