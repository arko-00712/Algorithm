import java.util.*;
import java.io.*;

public class Solution8{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int n = Integer.parseInt(br.readLine().trim());
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            words[i] = st.nextToken();
        }

        ArrayList[] adj = new ArrayList[26];
        int[] inDegree = new int[26];
        boolean[] used = new boolean[26];

        for (int i = 0; i < 26; i++) {
            adj[i] = new ArrayList();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                used[words[i].charAt(j) - 'a'] = true;
            }
        }

        boolean invalid = false;

        for (int i = 0; i < n - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());
            boolean found = false;

            for (int j = 0; j < minLen; j++) {
                int c1 = w1.charAt(j) - 'a';
                int c2 = w2.charAt(j) - 'a';

                if (c1 != c2) {
                    adj[c1].add(new Integer(c2));
                    inDegree[c2]++;
                    found = true;
                    break;
                }
            }

            if (!found && w1.length() > w2.length()) {
                invalid = true;
                break;
            }
        }

        if (invalid) {
            pw.println(-1);
            pw.flush();
            return;
        }

        PriorityQueue pq = new PriorityQueue();

        for (int i = 0; i < 26; i++) {
            if (used[i] && inDegree[i] == 0) {
                pq.add(new Integer(i));
            }
        }

        int totalUsed = 0;
        for (int i = 0; i < 26; i++) {
            if (used[i]) totalUsed++;
        }

        String result = "";
        int count = 0;

        while (!pq.isEmpty()) {
            int curr = ((Integer) pq.poll()).intValue();
            result = result + (char)('a' + curr);
            count++;

            for (int k = 0; k < adj[curr].size(); k++) {
                int neighbor = ((Integer) adj[curr].get(k)).intValue();
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0 && used[neighbor]) {
                    pq.add(new Integer(neighbor));
                }
            }
        }
        if (count != totalUsed) {
            pw.println(-1);
        } else {
            pw.println(result);
        }

        pw.flush();
    }
}