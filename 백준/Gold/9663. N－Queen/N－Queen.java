import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int n;
    static int cnt;
    static int[] check;


    static boolean isPossible(int target) {
        if (target == 0) return true;
        for (int i = 0; i < target; i++) {
            if (check[target] == check[i]) return false;
            if (Math.abs(check[target] - check[i]) == Math.abs(target - i)) return false;
        }
        return true;
    }


    static void NQueen(int depth) {
        if (depth == n) {
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            check[depth] = i;
            if (isPossible(depth)) {
                NQueen(depth + 1);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // n-queen
        check = new int[n];
        cnt = 0;
        NQueen(0);
        System.out.println(cnt);
    }
}

