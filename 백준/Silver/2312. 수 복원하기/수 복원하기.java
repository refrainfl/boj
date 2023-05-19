import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    static final int MAX = 100000;
    static boolean[] isPrime = new boolean[MAX + 1];
    
    static int nextPrime(int a) {
        int div = a + 1;
        while (!isPrime[div]) {
            div++;
        }
        return div;
    }


    static void eratos() {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i < MAX; i++) {
            for (int j = 2; i * j <= MAX; j++) {
                isPrime[i * j] = false;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        eratos();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int div = 1;
            while (N > 1) {
                if (isPrime[N]) {
                    sb.append(N).append(" ").append(1).append("\n");
                    break;
                }

                div = nextPrime(div);

                if (N % div == 0) {
                    int cnt = 0;
                    while (N % div == 0) {
                        N /= div;
                        cnt++;
                    }
                    sb.append(div).append(" ").append(cnt).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}