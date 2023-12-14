import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String pattern = "^[A-F]?A*F*C*[A-F]?$";

        while (N-- > 0) {
            String input = br.readLine();
            if (Pattern.matches(pattern, input)) {
                sb.append("Infected!").append("\n");
            } else sb.append("Good").append("\n");
        }

        System.out.println(sb);
    }
}