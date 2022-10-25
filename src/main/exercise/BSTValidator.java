import java.util.ArrayList;
import java.util.List;

/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class BSTValidator {

    static List<Integer> arr = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {

        Tree2Arr(root);

        if (arr.size() == 1) {
            arr.clear();
            return true;
        } else {
            for (int i = 0; i < arr.size()-1; i++) {
                if (arr.get(i) >= arr.get(i+1)) {
                    arr.clear();
                    return false;
                }
            }
            arr.clear();
            return true;
        }

    }

    public static void Tree2Arr(TreeNode root) {
        if (root != null) {
            Tree2Arr(root.left);
            arr.add(root.val);
            Tree2Arr(root.right);
        }
    }
}



