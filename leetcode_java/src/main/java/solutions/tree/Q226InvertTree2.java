
package main.java.solutions.tree;

import main.java.common.TreeNode;

/**
 * 226. Invert Binary Tree -- 翻转二叉树。
 * 这里用另一种方法实现，把 TreeNode 抽离成一个单独的模块。
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * @author zx
 * @since 2021-03-03
 */
public class Q226InvertTree2 {

    /**
     * 递归实现
     *
     * @param root 二叉树根节点，如 {1, 2, 3, 4, 5, 6, 7}
     * @return TreeNode 翻转后的二叉树根节点，{1, 3, 2, 7, 6, 5, 4}，每个节点的左右孩子互换
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.getLeft());
        TreeNode right = invertTree(root.getRight());
        root.setLeft(right);
        root.setRight(left);
        return root;
    }
}
