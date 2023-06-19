import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        TreeMap<String, String> map = new TreeMap<>(Collections.reverseOrder());
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            String exec = st.nextToken();

            if (exec.equals("enter")) map.put(str, str);
            else map.remove(map.remove(str));
        }

        for (String i : map.keySet()) sb.append(i).append("\n");

        System.out.println(sb);
    }
}