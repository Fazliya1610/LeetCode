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
    public TreeNode sortedArrayToBST(int[] nums) {
        return recur(nums, 0, nums.length-1);
    }
    private TreeNode recur(int[] nums, int low, int high) {
        if(low>high) {
            return null;
        }
        int mid = (low+high)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = recur(nums, low, mid-1);
        root.right = recur(nums, mid+1, high);
        return root;
    }
}