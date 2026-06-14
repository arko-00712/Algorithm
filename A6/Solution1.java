import java.io.*;
import java.util.*;

public class Solution1{
    static ArrayList<Integer>[] g;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        while(t-- > 0){
          st = new StringTokenizer(br.readLine());
          int n = Integer.parseInt(st.nextToken());
          int m = Integer.parseInt(st.nextToken());
          g = new ArrayList[n+1];
          
          for(int i = 0; i <= n; i++){
            g[i] = new ArrayList<Integer>();
          }
          
          int[] in = new int[n+1];
          
          for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            g[u].add(v);
            in[v]++;
          }
          
          Queue<Integer> q = new ArrayDeque<Integer>();
          for(int i = 1; i <= n; i++){
            if(in[i] == 0){
              q.add(i);
            }
          }
          
          ArrayList<Integer> ans = new ArrayList<Integer>();
          while(!q.isEmpty()){
            int x = q.poll();
            ans.add(x);
            
            for(int nbr : g[x]){
              in[nbr]--;
              if(in[nbr] == 0){
                q.add(nbr);
              }
            }
          }
          
          if(ans.size() != n){
            pw.println(-1);
          }
          else{
            for(int i = 0; i < n; i++) pw.print(ans.get(i)+ " ");
          }
        }
        pw.flush();
        }
    }
