import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
//https://www.acmicpc.net/problem/1013

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String pat = "^(((10)(0+)(1+))|(01))+$";
            String str = br.readLine();

            boolean result = Pattern.matches(pat, str);
            if (result) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb);
    }
}