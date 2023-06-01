import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//https://www.acmicpc.net/submit/9370

class Main {
    static final int INF = Integer.MAX_VALUE;
    static int V;
    static int E;
    static PriorityQueue<Edge> q = new PriorityQueue<>();
    static ArrayList<ArrayList<Edge>> list;

    static int dijkstra(int start, int end) {
        if (start == end) return 0;

        int[] distance = new int[V + 1];
        Arrays.fill(distance, INF);

        q.offer(new Edge(start, 0));
        distance[start] = 0;

        while (!q.isEmpty()) {
            Edge now = q.poll();
            int nowVertex = now.getVertex();
            int nowWeight = now.getWeight();
            if (nowWeight > distance[nowVertex]) continue;

            for (Edge Next : list.get(nowVertex)) {
                if (distance[Next.getVertex()] > nowWeight + Next.getWeight()) {
                    distance[Next.getVertex()] = nowWeight + Next.getWeight();
                    q.add(new Edge(Next.getVertex(), nowWeight + Next.getWeight()));
                }
            }
        }
        if (distance[end] == INF) return INF;
        return distance[end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken()); //n
            E = Integer.parseInt(st.nextToken()); //M
            int[] destCandidate = new int[Integer.parseInt(st.nextToken())];

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int through1 = Integer.parseInt(st.nextToken());
            int through2 = Integer.parseInt(st.nextToken());

            list = new ArrayList<ArrayList<Edge>>();
            for (int i = 0; i < V + 1; i++) {
                list.add(new ArrayList<Edge>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                list.get(u).add(new Edge(w, v));
                list.get(w).add(new Edge(u, v));
            }

            for (int i = 0; i < destCandidate.length; i++) {
                destCandidate[i] = Integer.parseInt(br.readLine());

                long direct = dijkstra(start, destCandidate[i]);
                int startToThrough1 = dijkstra(start, through1);
                int startToThrough2 = dijkstra(start, through2);
                int through1ToThrough2 = dijkstra(through1, through2);
                int through1ToDest = dijkstra(through1, destCandidate[i]);
                int through2ToDest = dijkstra(through2, destCandidate[i]);

                int route1, route2;
                if (startToThrough1 != INF && through1ToThrough2 != INF && through2ToDest != INF) {
                    route1 = dijkstra(start, through1) + dijkstra(through1, through2) + dijkstra(through2, destCandidate[i]);
                } else route1 = INF;

                if (startToThrough2 != INF && through1ToThrough2 != INF && through1ToDest != INF) {
                    route2 = dijkstra(start, through2) + dijkstra(through2, through1) + dijkstra(through1, destCandidate[i]);
                } else route2 = INF;

                int minRoute = Math.min(route1, route2);
                if (direct == INF || direct < minRoute) destCandidate[i] = 0;
            }
            Arrays.sort(destCandidate);

            for (int i : destCandidate) {
                if (i > 0) sb.append(i).append(" ");
            }
            sb.append("\n");

            list.clear();
            q.clear();
        }
        System.out.println(sb);
    }
}


class Edge implements Comparable<Edge> {
    private int vertex, weight;

    Edge(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public int getVertex() {
        return vertex;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}