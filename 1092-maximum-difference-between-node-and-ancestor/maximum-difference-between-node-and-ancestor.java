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
    int max;
    public int maxAncestorDiff(TreeNode root) {
        max=0;
        dfs(root, root.val, root.val);
        return max;
    }
    private void dfs(TreeNode node, int minimum, int maximum) {
        if(node==null) {
            return;
        }
        int diff1=Math.abs(node.val-minimum);
        int diff2=Math.abs(node.val-maximum);
        max=Math.max(max,Math.max(diff1,diff2));
        minimum=Math.min(minimum,node.val);
        maximum=Math.max(maximum,node.val);
        dfs(node.left,minimum,maximum);
        dfs(node.right,minimum,maximum);
    }
}