
package main.java.solutions.unclassified;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum -- 两数之和
 * https://leetcode.com/problems/two-sum/
 *
 * @author zx
 * @since 2020-12-24
 */
public class Q1TwoSum {

    /**
     * 遍历每个数字 num，如果 target - num 在 Map 中就找到了结果，否则把 num 保存到 Map 中
     *
     * @param nums   数组，如 {2, 7, 11, 15}
     * @param target 目标值，如 9
     * @return int[] 和为 target 的组合，如 5，{0, 1}
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }
}
