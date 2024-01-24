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
    public int pseudoPalindromicPaths(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int count) {
        if (node == null)
            return 0;
        count ^= (1 << node.val);
        if (node.left == null && node.right == null) {
            return (count & (count - 1)) == 0 ? 1 : 0;
        }
        int leftCount = dfs(node.left, count);
        int rightCount = dfs(node.right, count);
        return leftCount + rightCount;
    }
}