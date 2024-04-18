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
    public int rangeSumBST(TreeNode root, int low, int high) {
        return dfs(root, low, high, 0);
    }
    int dfs(TreeNode node, int low, int high, int sum) {
        if (node.left != null && node.val >= low) {
            sum = dfs(node.left, low, high, sum);
        }
        if (node.right != null && node.val <= high) {
            sum = dfs(node.right, low, high, sum);
        }
        if (node.val >= low && node.val <= high)
            return sum + node.val;
        
        return sum;
    }
}
