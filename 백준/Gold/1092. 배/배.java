import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<Integer> crane = new ArrayList<>();
        List<Integer> box = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (N-- > 0) {
            crane.add(Integer.parseInt(st.nextToken()));
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            box.add(Integer.parseInt(st.nextToken()));
        }

        crane.sort(Comparator.reverseOrder());
        Collections.sort(box);

        if (crane.get(0) < box.get(box.size() - 1)) {
            System.out.println(-1);
            return;
        }

        int cnt = 0;
        while (!box.isEmpty()) {
            for (Integer currentCrane : crane) {
                int idx = binarySearch(currentCrane, box);

                if (idx != -1) {
                    box.remove(idx);
                }
            }
            cnt++;
        }
        System.out.println(cnt);

    }

    private static int binarySearch(Integer target, List<Integer> box) {
        if (box.size() == 1 && target >= box.get(0)) return 0;
        if (box.isEmpty() || target < box.get(0)) return -1;

        int start = 0;
        int end = box.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (box.get(mid) > target) {
                end = mid - 1;
            } else start = mid + 1;
        }

        return start - 1;

    }

}
