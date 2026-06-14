import java.util.*;
import java.io.*;

public class Solution2{
  
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
      graph[u[i]].add(v[i]);
      graph[v[i]].add(u[i]);
    }
    
    int source = 1;
    boolean[] visited = new boolean[n+1];
    Stack<Integer> stk = new Stack<Integer>();
    stk.push(source);
    
     while(!stk.isEmpty()){
      int x = stk.pop();
      if(!visited[x]){
        visited[x] = true;
        pw.print(x);
        pw.print(" ");
      } 
      for(int nbr : graph[x]){
        if(!visited[nbr]){
          stk.push(nbr);
        }
      }
    }
 
    pw.flush();
  }
}