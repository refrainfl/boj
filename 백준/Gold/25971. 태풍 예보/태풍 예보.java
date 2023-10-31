import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};

    static final int MOVE_EAST = 0;
    static final int MOVE_SOUTH = 1;
    static final int MOVE_WEST = 2;
    static final int MOVE_NORTH = 3;

    static List<Typhoon> tExpandList;
    static int[] directions;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); //마지막 날
        int K = Integer.parseInt(st.nextToken()); // 관측 태풍 수
        int R = Integer.parseInt(st.nextToken());  // 태풍의 반지름
        int Q = Integer.parseInt(st.nextToken()); // 사람의 위치

        List<Typhoon> tList = new ArrayList<>();
        directions = new int[N + 1];
        Arrays.fill(directions, -1);


        int prevDir = -1;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Typhoon currentT = new Typhoon(day, x, y);
            tList.add(currentT);

            if (0 < i) {
                Typhoon prevT = tList.get(i - 1);
                int dayDif = currentT.day - prevT.day;

                for (int j = 0; j < 4; j++) {
                    int rx = dx[j] * dayDif;
                    int ry = dy[j] * dayDif;
                    if (prevT.x + rx == currentT.x && prevT.y + ry == currentT.y) {
                        directions[prevT.day] = j;
                        prevDir = directions[prevT.day];
                        break;
                    }
                }
            }
        }
        directions[N] = prevDir;


        prevDir = directions[1];
        for (int i = 2; i < N + 1; i++) {
            if (directions[i] == -1) {
                directions[i] = prevDir;
            } else {
                prevDir = directions[i];
            }
        }

        tExpandList = new ArrayList<>();
        tExpandList.add(0, new Typhoon(0, -1, -1));
        tExpandList.add(1, tList.get(0));

        for (int i = 2; i < N + 1; i++) {
            Typhoon tempT = tExpandList.get(i - 1);
            int x = tempT.x + dx[directions[i - 1]];
            int y = tempT.y + dy[directions[i - 1]];
            tExpandList.add(i, new Typhoon(i, x, y));
        }


        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(isPersonSafe(R, day, x, y)).append("\n");
        }
        System.out.println(sb);

    }


    static String isPersonSafe(int r, int day, double x, double y) {
        Typhoon t = tExpandList.get(day);
        int dir = directions[day];
        double typhoon_x = t.x;
        double typhoon_y = t.y;


        double dis_x = (typhoon_x - x) * (typhoon_x - x);
        double dis_y = (typhoon_y - y) * (typhoon_y - y);
        double distance = Math.sqrt(dis_x + dis_y);
        if (r < distance) return "gori";

        switch (dir) {
            case MOVE_EAST: {
                if (x < typhoon_x) return "safe";
                else if (x == typhoon_x) return "gori";
                return "unsafe";
            }
            case MOVE_WEST: {
                if (x > typhoon_x) return "safe";
                else if (x == typhoon_x) return "gori";
                return "unsafe";
            }
            case MOVE_SOUTH: {
                if (y > typhoon_y) return "safe";
                else if (y == typhoon_y) return "gori";
                return "unsafe";
            }
            case MOVE_NORTH: {
                if (y < typhoon_y) return "safe";
                else if (y == typhoon_y) return "gori";
                return "unsafe";
            }
            default:
                return "gori";
        }
    }
}

class Typhoon {
    int day;
    int x;
    int y;

    public Typhoon(int day, int x, int y) {
        this.day = day;
        this.x = x;
        this.y = y;
    }

}