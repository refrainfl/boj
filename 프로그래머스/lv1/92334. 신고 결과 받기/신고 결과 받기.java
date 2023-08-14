import java.util.*;

class Solution {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        StringTokenizer st;
        HashMap<String, List<String>> reportedMap = new HashMap<>();

        for (String id : id_list) {
            reportedMap.put(id, new ArrayList<>());
        }

        for (String rp : report) {
            st = new StringTokenizer(rp);
            String reporter = st.nextToken();
            String target = st.nextToken();

            if (reportedMap.get(target).contains(reporter)) continue;
            reportedMap.get(target).add(reporter);
        }


        for (String id : id_list) {
            if (reportedMap.get(id).size() >= k) {
                for (String toMail : reportedMap.get(id)) {
                    for (int i = 0; i < id_list.length; i++) {
                        if (id_list[i].equals(toMail)) {
                            answer[i]++;
                            break;
                        }
                    }
                }
            }
        }


        return answer;
    }
}