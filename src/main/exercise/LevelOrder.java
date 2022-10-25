import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 * (i.e., from left to right, level by level).
 */
public class LevelOrder {
    public List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return this.ans;
        }

        constructNewLevel(new ArrayList<TreeNode>(Arrays.asList(root)));
        return this.ans;
    }

    public void constructNewLevel(ArrayList<TreeNode> nodeList) {
        if (nodeList.isEmpty()) return;
        ArrayList<Integer> currentLevelValues = new ArrayList<>();
        ArrayList<TreeNode> nextLevelNode = new ArrayList<>();
        for (TreeNode node: nodeList
             ) {
            if (node != null) {
                currentLevelValues.add(node.val);
                if (node.left != null) nextLevelNode.add(node.left);
                if (node.right != null) nextLevelNode.add(node.right);
            }
        }
        this.ans.add(currentLevelValues);
        constructNewLevel(nextLevelNode);
    }
}
