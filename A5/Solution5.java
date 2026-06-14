import java.util.*;
import java.io.*;

public class Solution5 {

    static ArrayList<Integer>[] graph;
    static int[] visited;

    static void bfs(int start, int id) {
        Queue<Integer> q = new ArrayDeque<Integer>();
        q.add(start);
        visited[start] = id;

        while (!q.isEmpty()) {
            int x = q.poll();
            for (int nbr : graph[x]) {
                if (visited[nbr] == -1) {
                    visited[nbr] = id;
                    q.add(nbr);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());  
        int m = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        visited = new int[n + 1];  
        Arrays.fill(visited, -1); 

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u); 
        }

        int id = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i] == -1) { 
                bfs(i, id);  
                id++;  
            }
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if (visited[u] == visited[v]) {
                pw.println("YES");
            } 
            else {
                pw.println("NO");
            }
        }

        pw.flush();
    }
}