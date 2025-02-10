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
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> pref = new HashMap<>();
        return count(root, targetSum, 0L, pref);
    }

    private int count(TreeNode root, int targetSum, long currSum, HashMap<Long, Integer> pref) {
        if(root==null) {
            return 0;
        }
        int path = 0;
        currSum+=root.val;
        if(currSum==targetSum) {
            path++;
        }
        path+=pref.getOrDefault(currSum-targetSum, 0);
        pref.put(currSum, pref.getOrDefault(currSum, 0)+1);
        path+=count(root.left, targetSum, currSum, pref);
        path+=count(root.right, targetSum, currSum, pref);
        pref.put(currSum, pref.get(currSum)-1);
        return path;
    }
}