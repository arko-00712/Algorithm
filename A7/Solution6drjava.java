import java.io.*;
import java.util.*;

public class Solution6drjava{

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

    static long INF = Long.MAX_VALUE / 4;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

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

        dist[S][0] = 0;
        pq.add(new Pair(S, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();

            int node = current.node;
            long currentDist = current.dist;

            if (currentDist <= dist[node][1]) {
                for (Edge edge : graph[node]) {
                    int next = edge.to;
                    long newDist = currentDist + edge.weight;

                    if (newDist < dist[next][0]) {
                        dist[next][1] = dist[next][0];
                        dist[next][0] = newDist;

                        pq.add(new Pair(next, newDist));
                    } 
                    else if (newDist > dist[next][0] && newDist < dist[next][1]) {
                        dist[next][1] = newDist;

                        pq.add(new Pair(next, newDist));
                    }
                }
            }
        }

        if (dist[D][1] == INF) {
            pw.println(-1);
        } else {
            pw.println(dist[D][1]);
        }

        pw.flush();
    }
}