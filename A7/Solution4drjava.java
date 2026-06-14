import java.io.*;
import java.util.*;

public class Solution4drjava {

    static class Edge {
        int to;

        Edge(int to) {
            this.to = to;
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

    static long inf = Long.MAX_VALUE / 4;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        long[] weight = new long[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            weight[i] = Long.parseLong(st.nextToken());
        }

        ArrayList<Edge>[] graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v));
        }

        long[] dist = new long[N + 1];
        Arrays.fill(dist, inf);

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

        dist[S] = weight[S];
        pq.add(new Pair(S, dist[S]));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();

            int node = current.node;
            long currentDist = current.dist;

            if (currentDist == dist[node]) {
                for (Edge edge : graph[node]) {
                    int next = edge.to;

                    long newDist = dist[node] + weight[next];

                    if (newDist < dist[next]) {
                        dist[next] = newDist;
                        pq.add(new Pair(next, newDist));
                    }
                }
            }
        }

        if (dist[D] == inf) {
            pw.println(-1);
        } else {
            pw.println(dist[D]);
        }

        pw.flush();
    }
}