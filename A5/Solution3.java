import java.util.*;
import java.io.*;

public class Solution3{
  
  static ArrayList<Integer>[] g;
  
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int s = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());
    g = new ArrayList[n+1]; 
    for(int i=0; i<=n; i++){
      g[i] = new ArrayList<Integer>();
    }
    if (m == 0){
      if(s == d){
       pw.println(0);
       pw.println(s);
      }
      else{
       pw.println(-1);
      }
       pw.flush();
       return;
    }
    
    int[] u = new int[m];
    int[] v = new int[m];
    
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<m; i++){
      u[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<m; i++){
      v[i] = Integer.parseInt(st.nextToken());
    }
    
    for(int i=0; i<m; i++){
      g[u[i]].add(v[i]);
      g[v[i]].add(u[i]);
    }
    
    for (int i = 0; i <= n; i++) {
      Collections.sort(g[i]);
    }
    
    int[] parent = new int[n + 1];
    boolean[] visited = new boolean[n + 1];
    Arrays.fill(parent, -1);
    
    Queue<Integer> q = new ArrayDeque<Integer>();
    q.add(s);
    boolean found = false;
    
    while(!q.isEmpty()){
      int x = q.poll();
      if(x == d){
        found = true;
        break;
      }
      if(!visited[x]){
        visited[x] = true;
      } 
      for (int nbr : g[x]){
        if (!visited[nbr]) {
          visited[nbr] = true;
          parent[nbr] = x;
          q.add(nbr);
        }
      }
    }
    
    if(!found){
      pw.println(-1);
      pw.flush();
      return;
    }
 
    Stack<Integer> path = new Stack<Integer>();
    int node = d;
    while(node != -1){
      path.push(node);
      node = parent[node];
    }
    pw.println(path.size()-1);
    
    while(!path.isEmpty()){
      pw.print(path.pop()+" ");
    }
    
    pw.flush();
  }
}