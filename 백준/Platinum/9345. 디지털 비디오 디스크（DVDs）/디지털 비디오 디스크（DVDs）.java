import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/9345

class Main {
    static int[] min_tree;
    static int[] max_tree;
    static int[] arr;

    static int init(int start, int end, int idx, int exec) {
        if (exec == 0) {
            if (start == end) return min_tree[idx] = arr[start];
            int mid = (start + end) / 2;
            return min_tree[idx] = Math.min(init(start, mid, idx * 2, 0), init(mid + 1, end, idx * 2 + 1, 0));
        } else {
            if (start == end) return max_tree[idx] = arr[start];
            int mid = (start + end) / 2;
            return max_tree[idx] = Math.max(init(start, mid, idx * 2, 1), init(mid + 1, end, idx * 2 + 1, 1));
        }
    }

    static int search(int start, int end, int idx, int left, int right, int exec) {
        if (exec == 0) {
            if (left > end || right < start) return Integer.MAX_VALUE;
            if (left <= start && end <= right) return min_tree[idx];
            int mid = (start + end) / 2;
            return Math.min(search(start, mid, idx * 2, left, right, exec), search(mid + 1, end, idx * 2 + 1, left, right, exec));
        } else {
            if (left > end || right < start) return Integer.MIN_VALUE;
            if (left <= start && end <= right) return max_tree[idx];
            int mid = (start + end) / 2;
            return Math.max(search(start, mid, idx * 2, left, right, exec), search(mid + 1, end, idx * 2 + 1, left, right, exec));
        }
    }

    static int update(int start, int end, int idx, int target, int value, int exec) {
        if (exec == 0) {
            if (target < start || target > end) return min_tree[idx];
            min_tree[idx] = Math.min(min_tree[idx], value);
            if (start == end) {
                min_tree[idx] = value;
                return min_tree[idx];
            }
            int mid = (start + end) / 2;
            return min_tree[idx] = Math.min(update(start, mid, idx * 2, target, value, exec), update(mid + 1, end, idx * 2 + 1, target, value, exec));
        } else {
            if (target < start || target > end) return max_tree[idx];
            max_tree[idx] = Math.max(max_tree[idx], value);
            if (start == end) {
                max_tree[idx] = value;
                return max_tree[idx];
            }
            int mid = (start + end) / 2;
            return max_tree[idx] = Math.max(update(start, mid, idx * 2, target, value, exec), update(mid + 1, end, idx * 2 + 1, target, value, exec));
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            arr = new int[N];
            min_tree = new int[N * 4];
            max_tree = new int[N * 4];
            for (int i = 0; i < N; i++) arr[i] = i;
            init(0, N - 1, 1, 0);
            init(0, N - 1, 1, 1);

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                if (a == 0) {
                    update(0, N - 1, 1, b, arr[c], 0);
                    update(0, N - 1, 1, c, arr[b], 0);
                    update(0, N - 1, 1, c, arr[b], 1);
                    update(0, N - 1, 1, b, arr[c], 1);
                    int temp = arr[b];
                    arr[b] = arr[c];
                    arr[c] = temp;
                } else {
                    int minSearchResult = search(0, N - 1, 1, b, c, 0);
                    int maxSearchResult = search(0, N - 1, 1, b, c, 1);
                    if (minSearchResult == b && maxSearchResult == c) sb.append("YES\n");
                    else sb.append("NO\n");
                }
            }
        }//testcase end
        System.out.println(sb);
    }
}