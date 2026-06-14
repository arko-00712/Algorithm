import java.io.*;
import java.util.*;

public class Solution1 {

    static class Edge {
        int to;
        long weight;

        Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Pair {
        int node;
        long dist;

        Pair(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] u = new int[M];
        int[] v = new int[M];
        long[] w = new long[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            u[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            w[i] = Long.parseLong(st.nextToken());
        }

        ArrayList<Edge>[] graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < M; i++) {
            graph[u[i]].add(new Edge(v[i], w[i]));
        }

        long[] dist = new long[N + 1];
        int[] parent = new int[N + 1];

        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(parent, -1);

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a.dist, b.dist)
        );

        dist[S] = 0;
        pq.add(new Pair(S, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();

            int node = current.node;
            long currentDist = current.dist;

            if (currentDist == dist[node]) {
                for (Edge edge : graph[node]) {
                    int next = edge.to;
                    long newDist = dist[node] + edge.weight;

                    if (newDist < dist[next]) {
                        dist[next] = newDist;
                        parent[next] = node;
                        pq.add(new Pair(next, newDist));
                    }
                }
            }
        }

        if (dist[D] == Long.MAX_VALUE) {
            pw.println(-1);
        } 
        else {
            pw.println(dist[D]);

            ArrayList<Integer> path = new ArrayList<Integer>();
            int current = D;

            while (current != -1) {
                path.add(current);
                current = parent[current];
            }

            Collections.reverse(path);

            for (int i = 0; i < path.size(); i++) {
                pw.print(path.get(i) + " ");
            }

            pw.println();
        }

        pw.flush();
    }
}