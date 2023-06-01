import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static long[] arr;
    static long[] tree;
    static long[] lazy;


    static void lazy_update(int start, int end, int idx) {
        if (lazy[idx] != 0) {
            if ((end - start + 1) % 2 == 1) tree[idx] ^= lazy[idx];
            if (start != end) {
                lazy[idx * 2] ^= lazy[idx];
                lazy[idx * 2 + 1] ^= lazy[idx];
            }
            lazy[idx] = 0;
        }
    }

    static void update(int start, int end, int idx, int left, int right, long dif) {
        lazy_update(start, end, idx);
        if (left > end || right < start) return;
        if (left <= start && end <= right) {
            if ((end - start + 1) % 2 == 1) tree[idx] ^= dif;
            if (start != end) {
                lazy[idx * 2] ^= dif;
                lazy[idx * 2 + 1] ^= dif;
            }
            return;
        }
        int mid = (start + end) / 2;
        update(start, mid, idx * 2, left, right, dif);
        update(mid + 1, end, idx * 2 + 1, left, right, dif);
        tree[idx] = tree[idx * 2] ^ tree[idx * 2 + 1];
    }


    static long init(int start, int end, int idx) {
        if (start == end) return tree[idx] = arr[start];
        int mid = (start + end) / 2;
        return tree[idx] = init(start, mid, idx * 2) ^ init(mid + 1, end, idx * 2 + 1);
    }

    static long xor_sum(int start, int end, int idx, int left, int right) {
        lazy_update(start, end, idx);
        if (left > end || right < start) return 0; //범위 밖
        if (left <= start && end <= right) return tree[idx]; //범위 안
        int mid = (start + end) / 2;
        return xor_sum(start, mid, idx * 2, left, right) ^ xor_sum(mid + 1, end, idx * 2 + 1, left, right);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new long[N];
        tree = new long[N * 4];
        lazy = new long[N * 4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Long.parseLong(st.nextToken());
        init(0, N - 1, 1);

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                long d = Long.parseLong(st.nextToken());
                update(0, N - 1, 1, b, c, d);
            } else {
                sb.append(xor_sum(0, N - 1, 1, b, c) + "\n");
            }
        }
        System.out.println(sb);
    }
}