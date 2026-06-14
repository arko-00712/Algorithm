import java.util.*;
import java.io.*;

public class Solution1{
  
  static ArrayList<Integer>[] graph;
  
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    graph = new ArrayList[n+1];
    
    for(int i=0; i<=n; i++){
      graph[i] = new ArrayList<Integer>();
    }
    
    for(int i=0; i<m; i++){
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      graph[u].add(v);
      graph[v].add(u);
    }
    
    int source = 1;
    boolean[] visited = new boolean[n+1];
    Queue<Integer> q = new ArrayDeque<Integer>();
    q.add(source);
    
    while(!q.isEmpty()){
      int x = q.poll();
      if(!visited[x]){
        visited[x] = true;
        pw.print(x);
        pw.print(" ");
      } 
      for(int nbr : graph[x]){
        if(!visited[nbr]){
          q.add(nbr);
        }
      }
    }
    
    pw.flush();
  }
}