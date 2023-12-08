import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] staff = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            staff[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(staff);
        long maximumTime = (long) M * (long) staff[0];

        System.out.println(binarySearch(staff, M, 0L, maximumTime));
    }


    private static long binarySearch(int[] staff, int need, long start, long end) {

        while (start <= end) {
            long mid = start + (end - start) / 2;

            if (amountCheck(staff, mid, need)) {
                end = mid - 1;
            } else start = mid + 1;
        }

        return start;
    }

    private static boolean amountCheck(int[] staff, long time, int need) {
        long amount = 0;
        for (int eachStaff : staff) {
            amount += (time / (long) eachStaff);
        }
        return need <= amount;
    }
}