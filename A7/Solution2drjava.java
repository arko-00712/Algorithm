import java.io.*;
import java.util.*;

public class Solution2drjava {

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
    static ArrayList<Edge>[] graph;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());

            graph[u].add(new Edge(v, w));
        }

        long[] distAlice = dijkstra(S, N);
        long[] distBob = dijkstra(T, N);

        long minimumTime = INF;
        int meetingNode = -1;

        for (int i = 1; i <= N; i++) {
            if (distAlice[i] != INF && distBob[i] != INF) {
                long time = Math.max(distAlice[i], distBob[i]);

                if (time < minimumTime) {
                    minimumTime = time;
                    meetingNode = i;
                }
            }
        }

        if (meetingNode == -1) {
            pw.println(-1);
        } else {
            pw.println(minimumTime + " " + meetingNode);
        }

        pw.flush();
    }

    static long[] dijkstra(int start, int N) {
        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);

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

        dist[start] = 0;
        pq.add(new Pair(start, 0));

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
                        pq.add(new Pair(next, newDist));
                    }
                }
            }
        }

        return dist;
    }
}