import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int targetMoney = Integer.parseInt(br.readLine());
        int coinTypes = Integer.parseInt(br.readLine());
        int dp[] = new int[targetMoney + 1];
        dp[0] = 1;

        for (int i = 0; i < coinTypes; i++) {
            st = new StringTokenizer(br.readLine());
            int coin = Integer.parseInt(st.nextToken());
            int coinCount = Integer.parseInt(st.nextToken());

            for (int j = targetMoney - coin; j >= 0; j--) {
                for (int k = 1; k <= coinCount; k++) {
                    int targetIdx = j + coin * k;
                    if (targetIdx <= targetMoney)
                        dp[targetIdx] += dp[j];
                }
            }
        }
        System.out.println(dp[targetMoney]);
    }
}