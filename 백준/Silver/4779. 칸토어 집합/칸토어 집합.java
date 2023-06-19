import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static String cantor(int depth) {
        if (depth == 0) return "-";
        if (depth == 1) return "- -";

        String str = " ";
        for (int i = 0; i < depth - 1; i++) {
            str = str.repeat(3);
        }

        String fix = cantor(depth - 1);
        return fix + str + fix;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = "";
        while ((input = br.readLine()) != null) {
            int N = Integer.parseInt(input);
            sb.append(cantor(N)).append("\n");
        }

        System.out.println(sb);
    }
}