import java.io.*;
import java.util.*;

public class Solution6{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());


        int T = Integer.parseInt(st.nextToken());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] task = new int[n][2];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                task[i][0] = Integer.parseInt(st.nextToken());
                task[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(task, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return a[1] - b[1];
                }
            });

            TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

            map.put(-1, m);

            int ans = 0;

            for (int i = 0; i < n; i++) {
                int start = task[i][0];
                int end = task[i][1];

                Integer freeTime = map.lowerKey(start);

                if (freeTime != null) {
                    ans++;

                    int count = map.get(freeTime);

                    if (count == 1) {
                        map.remove(freeTime);
                    } else {
                        map.put(freeTime, count - 1);
                    }

                    map.put(end, map.getOrDefault(end, 0) + 1);
                }
            }

            pw.println(ans);
        }

        pw.flush();
    }
}