import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pattern = "^((100+1+)|(01)+)+";

        String input = br.readLine();
        if (Pattern.matches(pattern, input)) {
            System.out.println("SUBMARINE");
        } else System.out.println("NOISE");

    }
}