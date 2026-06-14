import java.io.*;
import java.util.*;

public class Solution7{

    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        int[] in = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            in[v]++;
        }

        Queue<Integer> q = new ArrayDeque<Integer>();

        for (int i = 1; i <= n; i++) {
            if (in[i] == 0) {
                q.add(i);
            }
        }

        int c = 0;

        while (!q.isEmpty()) {
            int x = q.poll();
            c++;

            for (int nbr : graph[x]) {
                in[nbr]--;
                if (in[nbr] == 0) {
                    q.add(nbr);
                }
            }
        }

        if (c == n) {
            pw.println("NO");
        } else {
            pw.println("YES");
        }

        pw.flush();
    }
}