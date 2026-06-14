import java.io.*;
import java.util.*;

public class Solution3{

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
        long danger;

        Pair(int node, long danger) {
            this.node = node;
            this.danger = danger;
        }
    }

    static long INF = Long.MAX_VALUE / 4;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Edge>[] graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());

            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        long[] danger = new long[N + 1];
        Arrays.fill(danger, INF);

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(
            (a,b) -> Long.compare(a.danger, b.danger)
        );

        danger[1] = 0;
        pq.add(new Pair(1, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();

            int node = current.node;
            long currentDanger = current.danger;

            if (currentDanger == danger[node]) {
                for (Edge edge : graph[node]) {
                    int next = edge.to;

                    long newDanger = Math.max(danger[node], edge.weight);

                    if (newDanger < danger[next]) {
                        danger[next] = newDanger;
                        pq.add(new Pair(next, newDanger));
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (danger[i] == INF) {
                pw.print(-1 + " ");
            } else {
                pw.print(danger[i] + " ");
            }
        }

        pw.println();
        pw.flush();
    }
}