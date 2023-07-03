import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        TreeMap<String, Integer> map = new TreeMap<>((o1, o2) -> {
            if (o1.length() != o2.length()) return -(o1.length() - o2.length());
            else return o1.compareTo(o2);
        });

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() < M) continue;
            if (map.containsKey(word)) map.put(word, map.get(word) + 1);
            else map.put(word, 0);
        }

        List<String> result = new ArrayList<>(map.keySet());
        result.sort((o1, o2) -> -(map.get(o1) - map.get(o2)));

        for (String s : result) sb.append(s).append("\n");
        System.out.println(sb);
    }
}