import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    static String add(String str, int index) {
        return str.substring(0, index) + "1" + str.substring(index + 1);
    }

    static String del(String str, int index) {
        return str.substring(0, index) + "0" + str.substring(index + 1);
    }

    static String shiftRight(String str) {
        return "0" + str.substring(0, str.length() - 1);
    }

    static String shiftLeft(String str) {
        return str.substring(1) + "0";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, String> map = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] train = new String[N];

        for (int i = 0; i < N; i++) {
            train[i] = "00000000000000000000";
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int trainNum = Integer.parseInt(st.nextToken());

            if (q == 1) {
                int seatIdx = Integer.parseInt(st.nextToken());
                train[trainNum - 1] = add(train[trainNum - 1], seatIdx - 1);

            } else if (q == 2) {
                int seatIdx = Integer.parseInt(st.nextToken());
                train[trainNum - 1] = del(train[trainNum - 1], seatIdx - 1);

            } else if (q == 3) {
                train[trainNum - 1] = shiftRight(train[trainNum - 1]);

            } else train[trainNum - 1] = shiftLeft(train[trainNum - 1]);
        }

        for (String str : train) {
            map.put(str, str);
        }

        System.out.println(map.size());
    }
}