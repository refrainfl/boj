import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) pq.add(Long.parseLong(br.readLine()));
        long sum = 0;
        while (pq.size() > 1) {
            long temp = pq.poll() + pq.poll();
            sum += temp;
            pq.add(temp);
        }
        System.out.println(sum);
    }
}