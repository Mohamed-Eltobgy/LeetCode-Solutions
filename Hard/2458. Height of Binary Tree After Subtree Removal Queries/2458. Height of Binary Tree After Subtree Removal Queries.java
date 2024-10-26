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
    public int[] treeQueries(TreeNode root, int[] queries) {
        int m = queries.length;
        int[] ans = new int[m];
        HashMap<Integer, Integer> heights = new HashMap<>();
        heights.put(root.val, dfs(root, heights, 0));
        HashMap<Integer, Integer> level = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int count = 0;
        level.put(root.val, count);
        int[] levelHeights = new int[heights.get(root.val) + 1];
        levelHeights[0] = heights.get(root.val);
        while (!q.isEmpty()) {
            count++;
            int size = q.size();
            boolean flag = false;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null) {
                    q.add(curr.left);
                    level.put(curr.left.val, count);
                    if (!flag && count + heights.get(curr.left.val) == heights.get(root.val)) {
                        flag = true;
                    } else {
                        levelHeights[count] = Math.max(levelHeights[count], count+ heights.get(curr.left.val));
                    }
                }
                if (curr.right != null) {
                    q.add(curr.right);
                    level.put(curr.right.val, count);
                    if (!flag && count + heights.get(curr.right.val) == heights.get(root.val)) {
                        flag = true;
                    } else {
                        levelHeights[count] = Math.max(levelHeights[count], count+ heights.get(curr.right.val));
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            int lvl = level.get(queries[i]);
            if (lvl + heights.get(queries[i]) == count - 1) {
                ans[i] = levelHeights[lvl];
            } else {
                ans[i] = count - 1;
            }
            if (ans[i] == 0)
                ans[i] = count-1 - heights.get(queries[i]) - 1;
        }
        return ans;
    }
    public int dfs(TreeNode node, HashMap<Integer, Integer> heights, int count) {
        int count1 = 0, count2 = 0;
        if (node.left != null) {
            count1 = dfs(node.left, heights, count);
            count1++;
        }
        if (node.right != null) {
            count2 = dfs(node.right, heights, count);
            count2++;
        }
        count = Math.max(count1, count2);
        heights.put(node.val, count);
        return count;
    }
}
