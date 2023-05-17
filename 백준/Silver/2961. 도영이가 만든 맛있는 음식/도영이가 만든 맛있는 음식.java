import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int[][] material;
    static int N;
    static int dif = Integer.MAX_VALUE;

    static void bt(int depth, int sour, int bitter) {
        if (depth == N && sour != 0) dif = Math.min(dif, Math.abs(bitter - sour));

        if (depth < N) {
            bt(depth + 1, sour, bitter);
            if (sour == 0) bt(depth + 1, material[depth][0], material[depth][1]);
            else bt(depth + 1, sour * material[depth][0], bitter + material[depth][1]);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        material = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            material[i][0] = Integer.parseInt(st.nextToken());
            material[i][1] = Integer.parseInt(st.nextToken());
        }

        bt(0, 0, 0);
        System.out.println(dif);

    }
}