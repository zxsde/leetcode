
package main.java.solutions.sliding_window;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 239. Sliding Window Maximum  -- 滑动窗口最大值
 * 题目：https://leetcode.com/problems/sliding-window-maximum
 * 参考：https://leetcode-cn.com/problems/sliding-window-maximum/solution/you-xian-dui-lie-zui-da-dui-dan-diao-dui-dbn9/
 *
 * @author zx
 * @since 2020-12-24
 */
public class Q239MaxSlidingWindow {

    /**
     * 方法一：单调队列（推荐），在队列中所有的元素都是单调的，要么单调增，要么单调减。
     * 遍历 nums 时，用一个双端队列保存下标，要确保队首元素始终是队列中的最大值，每个下标入队列前先把小于它的弹出去，
     * 通过比较队列的 first 和当前遍历的 i，可以判断窗口的大小，大于窗口时移除队列的 first，符合条件时返回队首元素。
     * 时间复杂度 O(n)，n 是 nums 的长度，每一个下标恰好被放入队列一次，且最多被弹出一次。
     * 空间复杂度 O(k)。
     *
     * @param nums 数组，如 {1, 3, -1, -3, 5, 3, 6, 7}
     * @param k    目标值，如 3
     * @return int[] 长度为 3 的窗口，滑动过程中出现的最大值，如 {3, 3, 5, 5, 6, 7}
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        // 题目已经给定 1 <= k <= nums.length <= 10^5
        if (k == 1) {
            return nums;
        }

        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>(); // 双向队列，用来存放下标
        for (int i = 0; i < nums.length; i++) {
            // 遍历 nums 过程中，q 只保存递增的元素下标，q[0] 始终是符合要求的元素
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            // deque 中长度超出 k 的话,滑出
            if (i - deque.peekFirst() == k) {
                deque.pollFirst();
            }
            // 保存符合要求的最大值
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }

    /**
     * 方法二：大根堆（不推荐，好理解但复杂度高，优化后可用），堆顶元素就是最大值。
     * 先把 k 个数字保存在大根堆中，可以确认第一个符合要求的数字就是堆顶的元素，res[0] = maxHeap.peek()。
     * 遍历剩余的 nums.length - k 个数字，堆中每次删除 nums[i-k]，加入 nums[i]，同时保存 maxHeap.peek()。
     * 时间复杂度 O(nk)，其中 Remove(object) 复杂度为 O(k)。
     * 空间复杂度 O(k)。
     *
     * @param nums 数组，如 {1, 3, -1, -3, 5, 3, 6, 7}
     * @param k    目标值，如 3
     * @return int[] 滑动窗口（长度为3）向右滑动过程中出现的最大值，如 {3, 3, 5, 5, 6, 7}
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        // 题目已经给定 1 <= k <= nums.length <= 10^5
        if (k == 1) {
            return nums;
        }

        // 大根堆，传入了一个比较器，把小根堆变成大根堆，不用 o2 - o1 是防止溢出。
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            maxHeap.offer(nums[i]);
        }

        res[0] = maxHeap.peek();
        for (int i = k; i < nums.length; i++) {
            maxHeap.remove(nums[i - k]);
            maxHeap.offer(nums[i]);
            res[i - k + 1] = maxHeap.peek();
        }
        return res;
    }

    /**
     * 方法三：大根堆（推荐），堆顶元素就是最大值。
     * 和上面的方法差不多，只不过堆中保存的不是数字，而是 [数字, 下标]，当滑动窗口右移时候需要删除元素，
     * 我们只在乎删除的这个元素是不是堆顶元素，现在可以通过下标差来判断，避免使用 O(k) 复杂度的 remove。
     * 遍历剩余的 nums.length - k 个数字，堆中每次删除 nums[i-k]，加入 nums[i]，同时保存 maxHeap.peek()。
     * 时间复杂度 O(n)，遍历一次 nums。
     * 空间复杂度 O(n)。
     *
     * @param nums 数组，如 {1, 3, -1, -3, 5, 3, 6, 7}
     * @param k    目标值，如 3
     * @return int[] 滑动窗口（长度为3）向右滑动过程中出现的最大值，如 {3, 3, 5, 5, 6, 7}
     */
    public int[] maxSlidingWindow3(int[] nums, int k) {
        // 题目已经给定 1 <= k <= nums.length <= 10^5
        if (k == 1) {
            return nums;
        }

        // 大根堆，保存着[元素, 下标]，传入了一个比较器，优先比较值，值相同时比较下标。
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1]);
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            maxHeap.offer(new int[]{nums[i], i});
        }

        res[0] = maxHeap.peek()[0];
        for (int i = k; i < nums.length; i++) {
            if (i - maxHeap.peek()[1] == k) {
                maxHeap.poll();
            }
            maxHeap.offer(new int[]{nums[i], i});
            res[i - k + 1] = maxHeap.peek()[0];
        }
        return res;
    }

}
