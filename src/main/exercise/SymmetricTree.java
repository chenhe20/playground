/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compare(root.left, root.right);
    }

    public static boolean compare(TreeNode p, TreeNode q) {
        if (p != null && q!= null) {
            if (p.val == q.val) {
                return compare(p.left, q.right) && compare(p.right, q.left);
            } else {
                return false;
            }
        } else if (p == null && q == null) {
            return true;
        } else {
            return false;
        }
    }
}
