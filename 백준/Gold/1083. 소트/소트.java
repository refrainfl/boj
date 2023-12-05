import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int limit;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        limit = Integer.parseInt(br.readLine());

        for (int i = 0; i < N - 1; i++) {
            int partialMaxIdx = findPartialMaxIdx(i);
            moveLeft(partialMaxIdx, i);
        }

        for (int num : arr) {
            sb.append(num +" ");
        }
        System.out.println(sb);

    }

    private static void moveLeft(int partialMaxIdx, int targetIdx) {
        if (partialMaxIdx == targetIdx) return;
        int temp;
        for (int i = partialMaxIdx; i > targetIdx; i--) {
            temp = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = temp;
            limit--;
        }
    }

    private static int findPartialMaxIdx(int startIdx) {
        if (limit == 0) return startIdx;
        int endIdx = startIdx + limit;

        if (endIdx >= arr.length) {
            endIdx = arr.length - 1;
        }

        int maxIdx = startIdx;
        for (int i = startIdx; i <= endIdx; i++) {
            if (arr[maxIdx] < arr[i]) maxIdx = i;
        }
        return maxIdx;
    }
}