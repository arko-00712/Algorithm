import java.util.*;
import java.io.*;

public class Solution5T{
  static ArrayList<Integer>[] g;
  
  public static void main(String[] args) throws IOException{
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     PrintWriter pw = new PrintWriter(System.out);
     StringTokenizer st = new StringTokenizer(br.readLine());
     int t = Integer.parseInt(st.nextToken());
     
     while(t-- > 0){
     st = new StringTokenizer(br.readLine());
     int n = Integer.parseInt(st.nextToken());
     int m = Integer.parseInt(st.nextToken());
     int s = Integer.parseInt(st.nextToken());
     int Q = Integer.parseInt(st.nextToken());
     g = new ArrayList[n+1];
     
     for(int i=0; i<=n; i++){
       g[i] = new ArrayList<Integer>();
     }
     
     for(int i=0; i<m; i++){
       st = new StringTokenizer(br.readLine());
       int u = Integer.parseInt(st.nextToken());
       int v = Integer.parseInt(st.nextToken());
       g[u].add(v);
       g[v].add(u);
     }
     
     Queue<Integer> q = new ArrayDeque<Integer>();
     int[] dist = new int[n+1];
     Arrays.fill(dist, -1);
     
     st = new StringTokenizer(br.readLine());
     for(int i=0; i<s; i++){
       int src = Integer.parseInt(st.nextToken());
       q.add(src);
       dist[src] = 0;
     }
     
     while(!q.isEmpty()){
       int x = q.poll();
       
       for(int nbr : g[x]){
         if(dist[nbr] == -1){
           dist[nbr] = dist[x] + 1;
           q.add(nbr);
         }
       }
     }
     
     st = new StringTokenizer(br.readLine());
     for(int i=0; i<Q; i++){
       int dest = Integer.parseInt(st.nextToken());
       pw.print(dist[dest]+" ");
     }
     }
     pw.flush();
  }
}


