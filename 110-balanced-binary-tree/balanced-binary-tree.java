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
    public boolean isBalanced(TreeNode root) {
        if(root==null) {
            return true;
        }
        return recur(root)>0;
    }
    private int recur(TreeNode root) {
        if(root==null) {
            return 0;
        }
        int left = recur(root.left);
        int right = recur(root.right);
        if(left==-1||right==-1||Math.abs(left-right)>1) {
            return -1;
        }
        return Math.max(left, right)+1;
    }
}