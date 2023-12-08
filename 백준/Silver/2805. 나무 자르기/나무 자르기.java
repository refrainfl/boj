import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] tree = new int[N];

        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[i]);
        }

        System.out.println(binarySearch(tree, M, 0, max));

    }


    private static int binarySearch(int[] tree, int need, int start, int end) {

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (amountCheck(tree, mid, need)) {
                start = mid + 1;
            } else end = mid - 1;
        }

        return end;
    }

    private static boolean amountCheck(int[] tree, int height, int need) {
        long amount = 0;
        for (int eachTree : tree) {
            if (eachTree > height) amount += (eachTree - height);
        }
        return amount >= need;
    }
}