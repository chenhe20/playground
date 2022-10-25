/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 *
 * Given the root of a binary tree, invert the tree, and return its root.
 */
public class InvertBinTree {

    public TreeNode invertTree(TreeNode root) {

        invert(root);

        return root;
    }

    public void invert(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        }

        return;

    }}
