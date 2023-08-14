import java.util.*;

class Solution {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, List<String>> reportedMap = new HashMap<>();

        for (String id : id_list) {
            reportedMap.put(id, new ArrayList<>());
        }

        StringTokenizer st;
        for (String rp : report) {
            st = new StringTokenizer(rp);
            String reporter = st.nextToken();
            String target = st.nextToken();
            if (!reportedMap.get(target).contains(reporter)) reportedMap.get(target).add(reporter);
        }

        for (String id : id_list) {
            if (reportedMap.get(id).size() >= k) {
                for (String toMail : reportedMap.get(id)) {
                    answer[Arrays.asList(id_list).indexOf(toMail)]++;
                }
            }
        }

        return answer;
    }
}