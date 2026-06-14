import java.util.*;
import java.io.*;

public class Solution6{
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int s = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        boolean[] forbidden = new boolean[10000];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            forbidden[x] = true;
        }

        boolean[] visited = new boolean[10000];
        int[] dist = new int[10000];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new ArrayDeque<Integer>();
        q.add(s);
        visited[s] = true;
        dist[s] = 0;
       
        while (!q.isEmpty()) {
            int x = q.poll();

            if (x == c) {
                pw.println(dist[x]);
                pw.flush();
                return;
            }

            int d1 = x / 1000;
            int d2 = (x / 100) % 10;
            int d3 = (x / 10) % 10;
            int d4 = x % 10;

            int[] digits = {d1, d2, d3, d4};

            for (int i = 0; i < 4; i++) {

                // increase
                int[] temp = digits.clone();
                temp[i] = (temp[i] + 1) % 10;
                int next1 = temp[0]*1000 + temp[1]*100 + temp[2]*10 + temp[3];

                if (!visited[next1] && !forbidden[next1]) {
                    visited[next1] = true;
                    dist[next1] = dist[x] + 1;
                    q.add(next1);
                }

                // decrease
                temp = digits.clone();
                temp[i] = (temp[i] + 9) % 10;
                int next2 = temp[0]*1000 + temp[1]*100 + temp[2]*10 + temp[3];

                if (!visited[next2] && !forbidden[next2]) {
                    visited[next2] = true;
                    dist[next2] = dist[x] + 1;
                    q.add(next2);
                }
            }
        }

        pw.println(-1);
        pw.flush();
    }
}