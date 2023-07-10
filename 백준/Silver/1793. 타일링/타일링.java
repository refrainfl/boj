import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int MAX_SIZE = 251;

        BigInteger[] dp = new BigInteger[MAX_SIZE];
        dp[0] = BigInteger.valueOf(1);
        dp[1] = BigInteger.valueOf(1);

        for (int i = 2; i < MAX_SIZE; i++) {
            dp[i] = (dp[i - 2].multiply(BigInteger.valueOf(2))).add(dp[i - 1]);
        }


        String input;
        while ((input = br.readLine()) != null) {
            sb.append(dp[Integer.parseInt(input)]).append("\n");
        }
        System.out.println(sb);

    }
}