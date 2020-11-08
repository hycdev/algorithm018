//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 

class Solution {
    private Map<Integer, Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++)
            inorderMap.put(inorder[i], i);

        return doBuild(preorder, inorder, 0, inorder.length - 1, 0, inorder.length -1 );
    }

    private TreeNode doBuild(int[] preorder, int[] inorder, int pre_start, int pre_end, int in_start, int in_end) {
        if (pre_start > pre_end)
            return null;

        int preorder_root = pre_start;
        int inorder_root = inorderMap.get(preorder[preorder_root]);

        TreeNode root = new TreeNode(preorder[preorder_root]);

        // 左子树节点数目
        int left_num = inorder_root - in_start;

        // build left subtree
        root.left = doBuild(preorder, inorder, pre_start + 1, pre_start + left_num, in_start, inorder_root - 1);

        // build right subtree
        root.right = doBuild(preorder, inorder, pre_start + left_num + 1, pre_end, inorder_root + 1, in_end);

        return  root;
    }
}