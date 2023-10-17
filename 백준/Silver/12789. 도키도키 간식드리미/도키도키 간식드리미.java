import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int target = 1;
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());

            if (num == target) target++;
            else stack.add(num);

            while (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                target++;
            }
        }

        if (stack.isEmpty()) System.out.println("Nice");
        else System.out.println("Sad");
    }
}