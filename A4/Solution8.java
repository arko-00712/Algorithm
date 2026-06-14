//****
import java.util.*;

public class Solution8 {

    static int gcd(int a, int b) {
        while(b != 0){
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Q = sc.nextInt();

        ArrayList<Integer>[] adj = new ArrayList[N+1];

        for(int i=1;i<=N;i++){
            adj[i] = new ArrayList<Integer>();
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i!=j && gcd(i,j)==1){
                    adj[i].add(j);
                }
            }
        }

        for(int i=1;i<=N;i++){
            Collections.sort(adj[i]);
        }

        while(Q-- > 0){
            int X = sc.nextInt();
            int K = sc.nextInt();

            if(K <= adj[X].size())
                System.out.println(adj[X].get(K-1));
            else
                System.out.println(-1);
        }

        sc.close();
    }
}