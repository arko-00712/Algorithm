import java.util.*;

public class Solution7 {

    static int preIndex = 0;

    static void build(int[] inorder, int[] preorder, int l, int r) {
        if (l > r) return;

        int root = preorder[preIndex++];
        
        int pos = -1;
        for (int i = l; i <= r; i++) {
            if (inorder[i] == root) {
                pos = i;
                break;
            }
        }

        build(inorder, preorder, l, pos - 1);
        build(inorder, preorder, pos + 1, r);

        System.out.print(root + " ");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] inorder = new int[n];
        int[] preorder = new int[n];

        for (int i = 0; i < n; i++)
            inorder[i] = sc.nextInt();

        for (int i = 0; i < n; i++)
            preorder[i] = sc.nextInt();

        build(inorder, preorder, 0, n - 1);
    }
}