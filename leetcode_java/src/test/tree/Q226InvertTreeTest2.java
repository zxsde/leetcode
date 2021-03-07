
package test.tree;


import main.java.solutions.tree.Q226InvertTree2;
import main.java.common.TreeNode;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;


public class Q226InvertTreeTest2 {

    @Test
    public void invertTreeTest() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode1.setLeft(treeNode2);
        treeNode1.setRight(treeNode3);
        treeNode2.setLeft(treeNode4);
        treeNode2.setRight(treeNode5);
        treeNode3.setLeft(treeNode6);
        treeNode3.setRight(treeNode7);

        Q226InvertTree2 invertTree = new Q226InvertTree2();
        TreeNode res1 = invertTree.invertTree(treeNode1);
        ArrayList<Integer> expected1 = new ArrayList<>(Arrays.asList(1, 3, 2, 7, 6, 5, 4));
        assertEquals(expected1, getNode(res1));
    }

    // 按层次遍历输出二叉树，方便直观的判断是否正确
    private ArrayList<Integer> getNode(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            res.add(temp.getVal());
            if (temp.getLeft() != null) {
                queue.offer(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.offer(temp.getRight());
            }
        }
        return res;
    }
}