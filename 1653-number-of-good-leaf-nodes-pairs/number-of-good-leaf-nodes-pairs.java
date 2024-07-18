/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countPairs(TreeNode root, int distance) {
        int[] res = new int[1];
        dfs(root, distance, res);
        return res[0];
    }

    private int[] dfs(TreeNode n, int d, int[] res) {
        if(n==null) {
            return new int[d+1];
        }
        if(n.left==null&&n.right==null) {
            int[] l = new int[d+1];
            l[1] = 1;
            return l;
        }
        int[] l = dfs(n.left, d, res);
        int[] r = dfs(n.right, d, res);
        for(int i=1;i<=d;i++) {
            for(int j=1;j<=d;j++) {
                if(i+j<=d) {
                    res[0]+=l[i]*r[j];
                }
            }
        }
        int[] c = new int[d+1];
        for(int i=1;i<d;i++) {
            c[i+1] = l[i]+r[i];
        }
        return c;
    }
}