import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        char[] chars = br.readLine().toCharArray();

        int BCnt = 1;
        int RCnt = 1;

        char prev = ' ';
        for (char aChar : chars) {
            char current = aChar;
            if (prev != current) {
                if (current == 'B') BCnt++;
                else RCnt++;
            }
            prev = current;

        }

        System.out.println(Math.min(BCnt, RCnt));
    }
}