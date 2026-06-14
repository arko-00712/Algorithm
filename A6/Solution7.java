import java.io.*;
import java.util.*;

public class Solution7{
    static ArrayList<Integer>[] g;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String A = st.nextToken();
        String B = st.nextToken();

        String[] words = new String[n];

        g = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            g[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            words[i] = st.nextToken();
            int first = words[i].charAt(0) - 'A';
            g[first].add(i);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<Integer>();

        for (int i = 0; i < n; i++) {
            if (words[i].equals(A)) {
                q.add(i);
                visited[i] = true;
            }
        }

        boolean found = false;

        while (!q.isEmpty()) {
            int x = q.poll();

            if (words[x].equals(B)) {
                found = true;
                break;
            }

            char lastChar = words[x].charAt(words[x].length() - 1);
            int idx = lastChar - 'A';

            for (int nbr : g[idx]) {
                if (!visited[nbr]) {
                    visited[nbr] = true;
                    q.add(nbr);
                }
            }
            
            g[idx].clear();
        }

        if(found) pw.println("YES");
        else pw.println("NO");
        pw.flush();
    }
}