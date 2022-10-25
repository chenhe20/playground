import java.util.HashMap;

/**
 * @author He Chen
 * @university King's College London
 * @ID 21044375
 */
public class BuildTree {
    HashMap<Integer, Integer> valToIndex = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int preLo, int preHi, int inLo, int inHi) {


        if (preLo > preHi) return null;

        TreeNode root = new TreeNode(preorder[preLo]);

        int val = preorder[preLo];
        int inRootIdx = valToIndex.get(val);


        int size = inRootIdx - inLo;
        root.left = build(preorder, inorder, preLo+1, preLo+size, inLo, inRootIdx-1);
        root.right = build(preorder, inorder, preLo+size+1, preHi, inRootIdx+1, inHi);


        return root;


    }

    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        buildTree.buildTree(new int[]{4,2,1,3}, new int[]{1,2,3,4});
    }
}
