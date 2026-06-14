import java.io.*;
import java.util.*;

public class Solution5drjava{

    static class Edge {
        int to;
        long weight;
        int parity;

        Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
            this.parity = (int)(weight % 2);
        }
    }

    static class Pair {
        int node;
        int lastParity;
        long dist;

        Pair(int node, int lastParity, long dist) {
            this.node = node;
            this.lastParity = lastParity;
            this.dist = dist;
        }
    }

    static long INF = Long.MAX_VALUE / 4;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

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

        long[][] dist = new long[N + 1][2];

        for (int i = 1; i <= N; i++) {
            dist[i][0] = INF;
            dist[i][1] = INF;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(
            new Comparator<Pair>() {
                public int compare(Pair a, Pair b) {
                    if (a.dist < b.dist) {
                        return -1;
                    } else if (a.dist > b.dist) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        );

        dist[1][0] = 0;
        dist[1][1] = 0;

        pq.add(new Pair(1, 0, 0));
        pq.add(new Pair(1, 1, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();

            int node = current.node;
            int lastParity = current.lastParity;
            long currentDist = current.dist;

            if (currentDist == dist[node][lastParity]) {
                for (Edge edge : graph[node]) {
                    int next = edge.to;
                    int newParity = edge.parity;

                    if (newParity != lastParity) {
                        long newDist = dist[node][lastParity] + edge.weight;

                        if (newDist < dist[next][newParity]) {
                            dist[next][newParity] = newDist;
                            pq.add(new Pair(next, newParity, newDist));
                        }
                    }
                }
            }
        }

        long answer = Math.min(dist[N][0], dist[N][1]);

        if (answer == INF) {
            pw.println(-1);
        } else {
            pw.println(answer);
        }

        pw.flush();
    }
}