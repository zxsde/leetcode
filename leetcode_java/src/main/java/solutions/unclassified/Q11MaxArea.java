
package main.java.solutions.unclassified;

/**
 * 11. Container With Most Water -- 盛最多水的容器。
 * https://leetcode.com/problems/container-with-most-water/
 *
 * @author zx
 * @since 2021-01-15
 */
public class Q11MaxArea {
    /**
     * 从左右两侧找到小的那个，往中间收敛，同时记录每一次的最大值
     *
     * @param height 容器的高，如 {4, 3, 2, 1, 4}
     * @return int 最多盛放多少水，如 16，4 + 4 + 4 + 4 = 16
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
