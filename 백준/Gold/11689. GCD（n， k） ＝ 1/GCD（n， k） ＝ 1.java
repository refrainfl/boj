import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    static boolean[] arr;
    static void eratos(boolean[] arr) {
        arr[0] = arr[1] = false;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i]) {
                for (int j = i + i; j < arr.length; j += i) {
                    arr[j] = false;
                }
            }
        }
    }

    static long eulerPi(Long N) {
        long result = 1;
        long div = 2;
        while (N != 1) {
            if (N % div == 0) {
                N /= div;
                result *= (div - 1);
                while (N % div == 0) {
                    result *= div;
                    N /= div;
                }
            } else {
                div++;
                while (!arr[(int) div]) {
                    div++;
                    if (div > 1000000) {
                        div = N;
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        arr = new boolean[10000001];
        Arrays.fill(arr, true);
        eratos(arr);
        System.out.println(eulerPi(N));
    }
}