import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static long calc(long X, long Y) {
        return Y * 100 / X;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());

        long result = -1;
        long left = 1;
        long right = 1000000000;
        long defaultWinRate = calc(X, Y);

        while (defaultWinRate < 99 && left <= right) {
            long mid = (left + right) / 2;
            if (defaultWinRate < calc(X + mid, Y + mid)) {
                right = mid - 1;
                result = mid;
            } else left = mid + 1;
        }

        System.out.println(result);
    }
}