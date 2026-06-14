import java.io.*;
import java.util.*;

public class Solution6 {

    static ArrayList<Integer>[] graph;
    static int[] subtree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
 
        graph = new ArrayList[n + 1];
        subtree = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u); 
        }

        dfs(r, -1);
   
        int q = Integer.parseInt(br.readLine());

        for (int i = 0; i < q; i++) {
            int x = Integer.parseInt(br.readLine());
            pw.println(subtree[x]);
        }

        pw.flush();
    }

    static void dfs(int x, int parent) {
        subtree[x] = 1; 

        for (int nbr : graph[x]) {
            if (nbr != parent) {  
                dfs(nbr, x); 
                subtree[x] += subtree[nbr];
            }
        }
    }
}