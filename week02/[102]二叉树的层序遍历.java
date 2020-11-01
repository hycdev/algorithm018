//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
// 
// 解决思路:
// 1.首先根元素入队
// 2.当队列不为空的时候，求当前队列的长度size，依次从队列中取size个元素进行拓展，然后进入下一次迭代
// 
// 时间复杂度:O(n)，每个节点进出队列一次
// 
// 空间复杂度:O(n), 队列中元素的个数不超过n个

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();

        if (root != null) queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> levelValues = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                levelValues.add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            result.add(levelValues);
        }

        return result;
    }
}
