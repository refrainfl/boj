import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            
            if (N > 0) {
                for (String s : map.keySet()) {
                    if (s.length() > temp.length() && s.startsWith(temp)) {
                        temp = s;
                        break;
                    } else if (temp.startsWith(s)) {
                        map.remove(s);
                        break;
                    }
                }
                
            }
            map.put(temp, temp);
        }
        System.out.println(map.size());
    }
}