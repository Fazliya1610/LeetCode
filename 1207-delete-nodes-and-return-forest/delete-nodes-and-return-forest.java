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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> del = new HashSet<>();
        for(int v:to_delete) {
            del.add(v);
        }
        List<TreeNode> res = new ArrayList<>();
        if(root==null) {
            return res;
        }
        root = delete(root, del, res);
        if(root!=null) {
            res.add(root);
        }
        return res;
    }

    private TreeNode delete(TreeNode n, Set<Integer> del, List<TreeNode> res) {
        if(n==null) {
            return null;
        }
        n.left = delete(n.left, del, res);
        n.right = delete(n.right, del, res);
        if(del.contains(n.val)) {
            if(n.left!=null) {
                res.add(n.left);
            }
            if(n.right!=null) {
                res.add(n.right);
            }
            return null;
        }
        return n;
    }
}