import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int MAX_COST = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] apps = new int[N][2];

        st = new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            apps[i][0] = Integer.parseInt(st.nextToken());
            apps[i][1] = Integer.parseInt(st2.nextToken());
        }

        System.out.println(calc(apps, M));
    }

    private static int calc(int[][] apps, int M) {
        int[] dp = new int[MAX_COST + 1];

        for (int[] app : apps) {
            int memory = app[0];
            int cost = app[1];

            for (int i = MAX_COST; i >= cost; i--) {
                dp[i] = Math.max(dp[i], dp[i - cost] + memory);
            }
        }

        for (int i = 0; i <= MAX_COST; i++) {
            if (dp[i] >= M) return i;
        }

        return -1;
    }
}