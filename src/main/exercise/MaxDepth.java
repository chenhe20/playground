/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(findNewMaxDepth(root.left, 1), findNewMaxDepth(root.right, 1));
    }

    public int findNewMaxDepth(TreeNode root, int depth) {
        if (root != null) {
            return Math.max(findNewMaxDepth(root.left, depth + 1), findNewMaxDepth(root.right, depth + 1));
        } else {
            return depth;
        }
    }
}
