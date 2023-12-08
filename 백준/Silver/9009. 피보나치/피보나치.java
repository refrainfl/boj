import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {

    static int MAX = 43;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] fibonacciTable = makeFibonacciTable();

        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(br.readLine());
            Stack<Integer> resultStack = find(target, fibonacciTable);
            while (!resultStack.isEmpty()) {
                sb.append(resultStack.pop() + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static Stack<Integer> find(int target, int[] fibonacciTable) {
        Stack<Integer> stack = new Stack<>();

        int idx = fibonacciTable.length - 1;
        while (target > 0) {
            while (target < fibonacciTable[idx]) {
                idx--;
            }
            target -= fibonacciTable[idx];
            stack.add(fibonacciTable[idx]);
        }

        return stack;

    }

    private static int[] makeFibonacciTable() {
        int[] fibonacciTable = new int[MAX + 1];
        fibonacciTable[0] = 1;
        fibonacciTable[1] = 1;
        for (int i = 2; i < fibonacciTable.length; i++) {
            fibonacciTable[i] = fibonacciTable[i - 1] + fibonacciTable[i - 2];
        }

        return fibonacciTable;
    }
}