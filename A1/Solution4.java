import java.util.Scanner;

public class Solution4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        if(T>=1 && T<=100){
          for(int i=0; i < T; i++){
            int N = sc.nextInt();
            if(N >=1 && N<=1000000){
              int[] arr = new int[N];
              for(int j=0; j < N; j++){
                arr[j] = sc.nextInt();
              }
              boolean b = check(arr);
              if(b) System.out.println("YES");
              else System.out.println("NO");
            }
          }
        }
    }
    public static boolean check(int[] a){
      for(int i=0; i < a.length-1; i++){
        if(a[i+1]<a[i]) return false;
      }
      return true;
    }
}