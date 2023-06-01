import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int[] arr;
    static int[] tree;
    static int N;

    static int init_h(int start, int end, int idx) {
        if (start == end) return tree[idx] = start;
        int mid = (start + end) / 2;
        int left_idx = init_h(start, mid, idx * 2);
        int right_idx = init_h(mid + 1, end, idx * 2 + 1);
        if (arr[left_idx] > arr[right_idx]) return tree[idx] = right_idx;
        else return tree[idx] = left_idx;
    }

    static int getMinIdx(int start, int end, int idx, int left, int right) {
        if (left > end || right < start) return -1;
        if (left <= start && end <= right) return tree[idx];

        int mid = (start + end) / 2;
        int left_idx = getMinIdx(start, mid, idx * 2, left, right);
        int right_idx = getMinIdx(mid + 1, end, idx * 2 + 1, left, right);

        if (left_idx == -1 && right_idx != -1) return right_idx;
        else if (right_idx == -1 && left_idx != -1) return left_idx;
        else if (arr[left_idx] > arr[right_idx]) return right_idx;
        else return left_idx;
    }


    static int getMaxArea(int start, int end) {
        int maxArea;
        int leftArea = 0;
        int rightArea = 0;

        int minIdx = getMinIdx(0, N - 1, 1, start, end);
        maxArea = arr[minIdx] * (end - start + 1);
        if (minIdx - start > 0) leftArea = getMaxArea(start, minIdx - 1);
        if (end - minIdx > 0) rightArea = getMaxArea(minIdx + 1, end);
        maxArea = Math.max(maxArea, leftArea);
        maxArea = Math.max(maxArea, rightArea);
        return maxArea;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tree = new int[N * 4];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
        init_h(0, N - 1, 1);
        System.out.println(getMaxArea(0, N - 1));
    }
}
