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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> n = new HashMap<>();
        Set<Integer> ch = new HashSet<>();
        for(int[] d:descriptions) {
            int p = d[0];
            int c = d[1];
            boolean l = d[2]==1;
            n.putIfAbsent(p, new TreeNode(p));
            n.putIfAbsent(c, new TreeNode(c));
            TreeNode par = n.get(p);
            TreeNode child = n.get(c);
            if(l) {
                par.left = child;
            }
            else {
                par.right = child;
            }
            ch.add(c);
        }
        TreeNode r = null;
        for(int k:n.keySet()) {
            if(!ch.contains(k)) {
                r = n.get(k);
                break;
            }
        }
        return r;
    }
}