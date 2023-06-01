import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[] list;

    static int binary_search(int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (target > list[mid]) start = mid + 1;
            else end = mid;
        }
        return end;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        list = new int[10000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        list[0] = arr[0];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] > list[idx]) list[++idx] = arr[i];
            else {
                if (i == N - 1) break;
                int header = binary_search(arr[i], 0, idx);
                list[header] = arr[i];
            }
        }
        System.out.println(idx + 1);
    }
}