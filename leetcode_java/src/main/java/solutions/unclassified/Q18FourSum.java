
package main.java.solutions.unclassified;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum -- 四数相加。
 * https://leetcode.com/problems/4sum/
 *
 * @author zx
 * @since 2021-01-23
 */
public class Q18FourSum {

    /**
     * 类似三数之和，排序后，固定前两位，然后从左右两侧向中间遍历，找到符合条件的所有组合
     *
     * @param nums   数字数组，如 {1, 0, -1, 0, -2, 2}
     * @param target 和，如 0
     * @return List 四个数字和为 0 的组合，{{-2, -1, 1, 2}, {-2， 0， 0， 2}, {-1， 0， 0， 1}}
     */
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }
        Arrays.sort(nums);
        // 先固定 nums[i] 和 nums[j]，然后用 left 和 right 向中间逼近，确保遍历完所有数字，
        // 因为已经排序，所以四个数字的和小于 0 就 left++，否则 right-- 。
        for (int i = 0; i < nums.length - 3; i++) {
            // 已排序，前四个和大于target那后面就不用算了，另外相同的元素,结果也相同，跳过
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                // 相同的元素,结果也相同，跳过
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    int tmp = nums[i] + nums[j] + nums[l] + nums[r];
                    if (tmp == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        // 过滤掉重复的结果
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (tmp < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return ans;
    }


//    static List<List<Integer>> ans = new ArrayList<>();

    /**
     * N 数之和的模板。思路还是排序后，先固定 n - 2 个数字，只留两个数字找一遍，然后递归回溯
     *
     * @param nums   数字数组
     * @param target 四数之和
     * @return List 结果
     */
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, target, 4, 0, path, ans);
        return ans;
    }

    /**
     * 回溯递归
     *
     * @param nums   数字数组
     * @param target 和
     * @param k      target 是 k 个数字之和
     * @param idx    nums 下标
     * @param path   每次找到的符合条件的解
     * @param ans    所有符合条件的解
     */
    private void helper(int[] nums, int target, int k, int idx, List<Integer> path, List<List<Integer>> ans) {
        if (nums == null || nums.length < k) return;
        System.out.println("target:" + target + ", k:" + k + ", idx:" + idx);
        if (k == 2) {
            int l = idx, r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    List<Integer> temp = new ArrayList<>(path);
                    // List<Integer> temp = new ArrayList<>(); temp.addll(path);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    ans.add(temp);
                    System.out.println("+++++++++ans: " + ans + ", temp: " + temp);
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (nums[l] + nums[r] < target) {
                    l++;
                } else {
                    r--;
                }
            }
        } else {
            for (int i = idx; i < nums.length - k + 1; i++) {
                int minSum = 0, maxSum = 0;
                for (int j = 0; j < k; j++) {
                    minSum += nums[i + j];
                    maxSum += nums[nums.length - j - 1];
                }
                System.out.println("minSum:" + minSum + "----- maxSum:" + maxSum);
                if (minSum > target) break;
                if (maxSum < target) break;
                if (i > idx && nums[i] == nums[i - 1]) continue;
                path.add(nums[i]);
                helper(nums, target - nums[i], k - 1, i + 1, path, ans);
                path.remove(path.size() - 1);
                System.out.println("ans:" + ans + "\n");
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int target1 = 0;
        Q18FourSum q18FourSum1 = new Q18FourSum();
        List<List<Integer>> res1 = q18FourSum1.fourSum2(nums1, target1);
        System.out.println(res1);

        System.out.println("==================");
        int[] nums2 = {0, 0, 0, 0};
        int target2 = 0;
//        Q18FourSum q18FourSum2 = new Q18FourSum();
        List<List<Integer>> res2 = q18FourSum1.fourSum2(nums2, target2);
        System.out.println(res2);
    }
}
