import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/1422
class Main {
    static String cmp(String str1, String str2) {
        String aStr = str1 + str2;
        String bStr = str2 + str1;
        if (aStr.compareTo(bStr) >= 1) return aStr;
        return bStr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); //K개의 자연수 중
        int N = Integer.parseInt(st.nextToken()); // N개를 뽑아 큰 수를 만든다.
        String[] arr = new String[N];
        long max = Long.MIN_VALUE;
        String str = "";

        for (int i = 0; i < K; i++) {
            arr[i] = br.readLine();
            max = Math.max(Long.parseLong(arr[i]), max);
        }

        for (int i = K; i < N ; i++) {
            arr[i] = Long.toString(max);
        } // 제일 큰 값을 배열에 남은칸에 더 추가

        Arrays.sort(arr, (s1, s2) -> (s2 + s1).compareTo(s1 + s2)); //정렬

        for (int i = 0; i < N; i++) {
            str = cmp(str, arr[i]);
        }
        System.out.println(str);
    }
}
