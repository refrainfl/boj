import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int[] arr;
    static int[] cnt;

    static void union(int a, int b) {
        a = find_parent(a);
        b = find_parent(b);
        arr[b] = a;
    }

    static int find_parent(int a) {
        if (arr[a] == a) return a;
        return find_parent(arr[a]);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            HashMap<String, Integer> map = new HashMap<>();
            Queue<Edge> q = new LinkedList<>();
            int N = Integer.parseInt(br.readLine());

            int id = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String p1 = st.nextToken();
                if (!map.containsKey(p1)) map.put(p1, id++);
                String p2 = st.nextToken();
                if (!map.containsKey(p2)) map.put(p2, id++);
                q.add(new Edge(map.get(p1), map.get(p2)));
            }
            arr = new int[map.size()];
            cnt = new int[map.size()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
                cnt[i] = 1;
            }

            for (int i = 0; i < N; i++) {
                Edge line = q.poll();
                if (find_parent(line.x) != find_parent(line.y)) {
                    cnt[find_parent(line.x)] += cnt[find_parent(line.y)];
                    union(line.x, line.y);
                }
                sb.append(cnt[find_parent(line.x)]).append("\n");
            }

        } //testcase end
        System.out.println(sb);


    }
}

class Edge {
    int x;
    int y;

    Edge(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
