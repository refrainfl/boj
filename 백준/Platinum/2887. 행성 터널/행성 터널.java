import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
    static int[] parent;
    static ArrayList<Edge> list = new ArrayList<>();

    public static int find_parent(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find_parent(parent[x]);
    }

    public static void union(int x, int y) {
        x = find_parent(x);
        y = find_parent(y);
        if (x != y) parent[y] = x;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Planet[] planets = new Planet[N];
        parent = new int[N];
        for (int i = 0; i < N; i++) parent[i] = i;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            planets[i] = new Planet(i, x, y, z);
        }

        Arrays.sort(planets, (o1, o2) -> o1.x - o2.x);
        for (int i = 0; i < N - 1; i++) {
            int weight = Math.abs(planets[i].x - planets[i + 1].x);
            list.add(new Edge(planets[i].id, planets[i + 1].id, weight));
        }

        Arrays.sort(planets, (o1, o2) -> o1.y - o2.y);
        for (int i = 0; i < N - 1; i++) {
            int weight = Math.abs(planets[i].y - planets[i + 1].y);
            list.add(new Edge(planets[i].id, planets[i + 1].id, weight));
        }

        Arrays.sort(planets, (o1, o2) -> o1.z - o2.z);
        for (int i = 0; i < N - 1; i++) {
            int weight = Math.abs(planets[i].z - planets[i + 1].z);
            list.add(new Edge(planets[i].id, planets[i + 1].id, weight));
        }

        Collections.sort(list);
        int ans = 0;
        for (Edge e : list) {
            if (find_parent(e.u) != find_parent(e.v)) {
                ans += e.w;
                union(e.u, e.v);
            }
        }

        bw.write(ans + "");
        bw.flush();

    }
}

class Planet {
    int id;
    int x;
    int y;
    int z;

    Planet(int id, int x, int y, int z) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

class Edge implements Comparable<Edge> {
    int u;
    int v;
    int w;

    Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return this.w - o.w;
    }
}