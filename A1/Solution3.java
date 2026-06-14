import java.util.Scanner;
 
public class Solution3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        while (T-- > 0) {
            long N = sc.nextLong();
            long sum = N * (N + 1) / 2;
            System.out.println(sum);
        }
        
        sc.close();
    }
}