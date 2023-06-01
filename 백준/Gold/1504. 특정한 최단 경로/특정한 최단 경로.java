import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//https://www.acmicpc.net/problem/1753

class Main {
    static final int INF = Integer.MAX_VALUE;
    static int V;
    static int E;
    static PriorityQueue<Edge> q = new PriorityQueue<>();
    static ArrayList<ArrayList<Edge>> list;

    static int dijkstra(int start, int end) {
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int R = 1;

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
        st = new StringTokenizer(br.readLine());
        int throughVertex1 = Integer.parseInt(st.nextToken());
        int throughVertex2 = Integer.parseInt(st.nextToken());


        int StartToVertex1 = dijkstra(R, throughVertex1);
        int StartToVertex2 = dijkstra(R, throughVertex2);
        int Vertex1ToVertex2 = dijkstra(throughVertex1, throughVertex2);
        int Vertex1ToEnd = dijkstra(throughVertex1, V);
        int Vertex2ToEnd = dijkstra(throughVertex2, V);

        long route1 = INF;
        long route2 = INF;

        if (StartToVertex1 != INF && Vertex1ToVertex2 != INF && Vertex2ToEnd != INF) {
            route1 = dijkstra(R, throughVertex1) + dijkstra(throughVertex1, throughVertex2) + dijkstra(throughVertex2, V);
        }
        if (StartToVertex2 != INF && Vertex1ToVertex2 != INF && Vertex1ToEnd != INF) {
            route2 = dijkstra(R, throughVertex2) + dijkstra(throughVertex2, throughVertex1) + dijkstra(throughVertex1, V);
        }

        long result = Math.min(route1, route2);
        if (result == INF) System.out.println(-1);
        else System.out.println(result);
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