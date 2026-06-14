import java.io.*;
import java.util.*;

public class Solution4T{
    static ArrayList<Integer>[] g;
    static int farthestNode;
    static int maxD;

    public static void bfs(int start, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new ArrayDeque<Integer>();
        q.add(start);
        dist[start] = 0;

        farthestNode = start;
        maxD = 0;

        while (!q.isEmpty()) {
            int x = q.poll();

            for (int nbr : g[x]) {
                if (dist[nbr] == -1) {
                    dist[nbr] = dist[x] + 1;
                    q.add(nbr);

                    if (dist[nbr] > maxD) {
                        maxD = dist[nbr];
                        farthestNode = nbr;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int t = Integer.parseInt(st.nextToken());
        while(t-- > 0){
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        g = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            g[u].add(v);
            g[v].add(u);
        }

        bfs(1, n);
        int a = farthestNode;

        bfs(a, n);
        int b = farthestNode;

        pw.println(maxD);
        pw.println(a + " " + b);
        pw.flush();
        }
    }
}