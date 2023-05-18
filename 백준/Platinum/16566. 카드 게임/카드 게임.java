import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int[] having;
    static int[] parent;

    static int find_parent(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find_parent(parent[x]);
    }

    static void union(int x, int y) {
        x = find_parent(x);
        y = find_parent(y);
        if (x != y) parent[y] = x;
    }

    static int binary_search(int s, int e, int x) {
        int mid = (s + e) / 2;
        if (having[mid] == x) return mid + 1;
        else if (x < having[0]) return 0;
        else if (mid > 0 && having[mid - 1] < x && x < having[mid]) return mid;
        else if (having[mid] < x) return binary_search(mid + 1, e, x);
        else return binary_search(s, mid - 1, x);
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        having = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) having[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(having);
        parent = new int[M + 1];
        for (int i = 0; i < M; i++) parent[i] = i;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int idx = binary_search(0, M - 1, Integer.parseInt(st.nextToken()));
            idx = find_parent(idx);
            sb.append(having[idx]).append("\n");
            union(idx + 1, idx);
        }
        System.out.println(sb);
    }
}
