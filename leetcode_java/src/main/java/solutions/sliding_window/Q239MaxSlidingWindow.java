
package main.java.solutions.sliding_window;

import java.util.LinkedList;

/**
 * 239.
 * https://leetcode.com/problems/sliding-window-maximum
 *
 * @author zx
 * @since 2020-12-24
 */
public class Q239MaxSlidingWindow {

    /**
     * 遍历 nums 时，用一个双端队列保存下标，要确保队首元素始终是队列中的最大值，每个下标入队列前先把小于它的弹出去，
     * 通过比较队列的 first 和当前遍历的 i，可以判断窗口的大小，大于窗口时移除队列的 first，符合条件时返回队首元素。
     *
     * @param nums 数组，如 {1, 3, -1, -3, 5, 3, 6, 7}
     * @param k    目标值，如 3
     * @return int[] 长度为 3 的窗口，滑动过程中出现的最大值，如 {3, 3, 5, 5, 6, 7}
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }

        int[] res = new int[n - k + 1];
        LinkedList<Integer> q = new LinkedList<>(); // 双向队列，用来存放下标
        for (int i = 0; i < n; i++) {
            // 遍历 nums 过程中，q 只保存递增的元素下标，q[0] 始终是符合要求的元素
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
                q.pollLast();
            }
            q.addLast(i);
            // q 中长度超出 k 的话滑出
            if (i - q.peekFirst() == k) {
                q.pollFirst();
            }
            // 保存符合要求的最大值
            if (i >= k - 1) {
                res[i - k + 1] = nums[q.peekFirst()];
            }
        }
        return res;
    }
}
