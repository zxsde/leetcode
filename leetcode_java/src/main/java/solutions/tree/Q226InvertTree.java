
package main.java.solutions.tree;

import org.junit.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * 226. Invert Binary Tree -- 翻转二叉树。
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * @author zx
 * @since 2021-03-03
 */
public class Q226InvertTree {
    /**
     * 递归实现
     *
     * @param root 二叉树根节点，如 {1, 2, 3, 4, 5, 6, 7}
     * @return TreeNode 翻转后的二叉树根节点，{1, 3, 2, 7, 6, 5, 4}，每个节点的左右孩子互换
     */
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree1(root.left);
        TreeNode right = invertTree1(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * 迭代，BFS
     *
     * @param root 二叉树根节点
     * @return TreeNode 翻转后的二叉树根节点
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }

    @Test
    public void invertTree1Test() {

        // 初始化二叉树
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        TreeNode res1 = invertTree1(treeNode1);
        ArrayList<Integer> expected1 = new ArrayList<>(Arrays.asList(1, 3, 2, 7, 6, 5, 4));
        assertEquals(expected1, getNode(res1));
    }

    @Test
    public void invertTree2Test() {

        // 初始化二叉树
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        TreeNode res2 = invertTree2(treeNode1);
        ArrayList<Integer> expected2 = new ArrayList<>(Arrays.asList(1, 3, 2, 7, 6, 5, 4));
        assertEquals(expected2, getNode(res2));
    }

    // 按层次遍历输出二叉树，方便直观的判断是否正确
    private List<Integer> getNode(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            res.add(temp.val);
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
        return res;
    }

}
