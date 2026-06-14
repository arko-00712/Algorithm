import java.util.Scanner;
 
public class Solution3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int a = sc.nextInt();
        long b = sc.nextLong();
 
        long mod = 107;
        long result = 1;
        long base = a % mod;
 
        while (b > 0) {
            if (b % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            b /= 2;
        }
 
        System.out.println(result);
    }
}