import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static long fastXor(int x) {
        long result = x;

        switch (x % 4) {
            case 0: {
                result = x;
                break;
            }
            case 1: {
                result = 1;
                break;
            }
            case 2: {
                result = x + 1;
                break;
            }
            case 3: {
                result = 0;
                break;
            }
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int F = Integer.parseInt(st.nextToken());
            sb.append(fastXor(S - 1) ^ fastXor(F)).append("\n");
        }
        System.out.println(sb);
    }
}