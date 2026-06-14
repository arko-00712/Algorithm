import java.util.*;

public class Solution8 {

    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    static int postIdx;
    static int[] inorder, postorder;
    static int[] pos; // pos[value] = index in inorder

    static Node buildTree(int inL, int inR) {
        if (inL > inR) return null;

        int rootVal = postorder[postIdx--];
        Node root = new Node(rootVal);

        int k = pos[rootVal]; // position of root in inorder

        // IMPORTANT: build right first, then left (because we read postorder from the end)
        root.right = buildTree(k + 1, inR);
        root.left  = buildTree(inL, k - 1);

        return root;
    }

    static void preorderPrint(Node root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorderPrint(root.left);
        preorderPrint(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        inorder = new int[n];
        postorder = new int[n];

        for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
        for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();

        // values are 1..N (given), so we can use an array for positions
        pos = new int[n + 1];
        for (int i = 0; i < n; i++) pos[inorder[i]] = i;

        postIdx = n - 1;

        Node root = buildTree(0, n - 1);
        preorderPrint(root);
    }
}