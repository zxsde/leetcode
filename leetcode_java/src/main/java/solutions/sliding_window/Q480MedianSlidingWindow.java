
package main.java.solutions.sliding_window;

import java.util.ArrayList;
import java.util.List;

/**
 * 480. Sliding Window Median -- 滑动窗口中位数。
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * @author zx
 * @since 2020-12-23
 */
public class Q480MedianSlidingWindow {

    /**
     * 窗口 win 保存一个有序数组，求其中位数很简单。注意窗口移动时 win 要弹出多余的数字
     *
     * @param nums 整型数组，如 {1, 3, -1, -3, 5, 3, 6, 7}
     * @param k    窗口大小， 如 3
     * @return 窗口滑动过程中的中位数，如 {1.0, -1.0, -1.0, 3.0, 5.0, 6.0}
     */
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        List<Integer> win = new ArrayList<>();
        int idx = 0, pos;
        for (int i = 0; i < nums.length; i++) {
            // win 是一个长度为 k 的递增窗口，nums 中每个元素按递增插入 win
            win.add(binarySearch(win, nums[i]), nums[i]);
            // 遍历到 k 个元素开始，把中位数输出到 res 保存
            if (i >= k - 1) {
                if (k % 2 == 0) {
                    res[i - k + 1] = ((double) win.get((k - 1) / 2) + (double) win.get(k / 2)) / 2;
                } else {
                    res[i - k + 1] = win.get((k - 1) / 2);
                }
                // win 保持 k 个元素，所以要按序把 nums 中的元素弹出
                pos = binarySearch(win, nums[idx]);
                win.remove(pos);
                idx++;
            }
        }
        return res;
    }

    // 二分查找定位插入点
    private int binarySearch(List<Integer> data, int targert) {
        int left = 0, right = data.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (data.get(mid) < targert) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
