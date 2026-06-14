import java.io.*;
import java.util.*;

public class Solution4 {

    static ArrayList<Integer>[] graph;

    static void bfs(int start, int[] dist, int[] parent) {
        Arrays.fill(dist, -1);  
        Arrays.fill(parent, -1); 
        Queue<Integer> q = new ArrayDeque<Integer>();
        q.add(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int x = q.poll();

            for (int nbr : graph[x]) {
                if (dist[nbr] == -1) {  
                    dist[nbr] = dist[x] + 1;
                    parent[nbr] = x;
                    q.add(nbr);
                }
            }
        }
    }

    static ArrayList<Integer> buildPath(int target, int[] parent) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        int cur = target;
        while (cur != -1) {
            path.add(cur);
            cur = parent[cur];
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
        }

        int[] distS = new int[N + 1];
        int[] parentS = new int[N + 1];
        int[] distK = new int[N + 1];
        int[] parentK = new int[N + 1];

        bfs(S, distS, parentS);
        bfs(K, distK, parentK);

        if (distS[K] == -1 || distK[D] == -1) {
            pw.println(-1);
            pw.close();
            return;
        }

        ArrayList<Integer> path1 = buildPath(K, parentS);
        ArrayList<Integer> path2 = buildPath(D, parentK);

        ArrayList<Integer> finalPath = new ArrayList<Integer>(path1);
        for (int i = 1; i < path2.size(); i++) {
            finalPath.add(path2.get(i));
        }

        pw.println(finalPath.size() - 1);
        for (int i = 0; i < finalPath.size(); i++) {
            pw.print(finalPath.get(i));
            pw.print(" ");
        }
        pw.println();
        pw.flush();
    }
}