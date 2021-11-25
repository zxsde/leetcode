package main.java.solutions.unclassified;

import java.util.HashMap;
import java.util.Map;

/**
 * 1814. Count Nice Pairs in an Array -- 统计一个数组中好对子的数目
 * https://leetcode.com/problems/count-nice-pairs-in-an-array/
 *
 * @author zx
 * @since 2021-06-16
 */
public class Q1814CountNicePairs {
    /**
     * “好对子” 指的是 nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])，则有
     * nums[i] - rev(nums[i]) == nums[j] - rev(nums[j])，我们只需求出有多少满足这种情况的数字即可。
     * 比如 [1, 1, 1, 1]，四个元素都满足要求，对应的组合为 (0, 1), (0, 2), (0, 3),(1, 2), (1, 3), (2, 3)。
     * 可以得到一种关系：nums[i] - rev(nums[i]) 出现的次数为 k ，则可组成的“好对子”有 k*(k-1)/2 种。
     *
     * @param nums 数组，如 {42, 11, 1, 97}
     * @return int “好对子” 的个数
     */
    public int countNicePairs(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int mod = (int) 1e9 + 7;  // 10^9+7 是一个较大的质数，常用其取模防止溢出
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int n : nums) {
            int diff = n - rev(n);
            hashMap.put(diff, hashMap.getOrDefault(diff, 0) + 1);
        }
        long res = 0;
        for (int diff : hashMap.keySet()) {
            long times = hashMap.get(diff);
            res = (res + times * (times - 1) / 2) % mod;
        }
        return (int) res % mod;
    }

    // 翻转数字
    public int rev(int num) {
        int res = 0;
        if (num < 10) {
            return num;
        }
        while (num > 0) {
            res = res * 10 + (num % 10);
            num /= 10;
        }
        return res;
    }
}



