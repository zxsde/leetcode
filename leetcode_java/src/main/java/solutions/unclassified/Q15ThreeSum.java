
package main.java.solutions.unclassified;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum -- 三数相加。
 * https://leetcode.com/problems/3sum/
 *
 * @author zx
 * @since 2021-01-21
 */
public class Q15ThreeSum {

    /**
     * 排序后，固定第一位，然后从左右两侧向中间遍历，找到符合条件的所有组合
     *
     * @param nums 数字数组，如 {-1, 0, 1, 2, -1, -4}
     * @return List 三个数字和为 0 的组合，如 {{-1, -1, 2}, {-1, 0, 1}}
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }
        Arrays.sort(nums);
        // 先选定 nums[i]，然后用 left 和 right 向中间逼近，确保遍历完所有数字，
        // 因为已经排序，所以三个数字的和小于 0 就 left++，否则 right-- 。
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // 过滤掉重复的结果
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (nums[i] + nums[l] + nums[r] < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ans;
    }
}
