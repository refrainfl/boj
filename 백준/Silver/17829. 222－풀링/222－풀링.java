import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int makeMatrix(int[][] arr, int y, int x) {
        int[] rank = new int[4];
        rank[0] = arr[y * 2][x * 2];
        rank[1] = arr[y * 2 + 1][x * 2];
        rank[2] = arr[y * 2][x * 2 + 1];
        rank[3] = arr[y * 2 + 1][x * 2 + 1];

        Arrays.sort(rank);
        return rank[2];
    }

    static int Dac(int[][] arr) {
        int N = arr.length;
        if (N == 1) return arr[0][0];
        
        int[][] subArr = new int[N / 2][N / 2];
        for (int i = 0; i < subArr.length; i++) {
            for (int j = 0; j < subArr.length; j++) {
                subArr[i][j] = makeMatrix(arr, i, j);
            }
        }
        return Dac(subArr);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(Dac(arr));
    }
}