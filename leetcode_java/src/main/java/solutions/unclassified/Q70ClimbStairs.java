
package main.java.solutions.unclassified;

/**
 * 70. Climbing Stairs -- 爬楼梯。
 * https://leetcode.com/problems/climbing-stairs/
 *
 * @author zx
 * @since 2021-02-24
 */
public class Q70ClimbStairs {
    /**
     * 记忆化递归，
     *
     * @param n 数字数组，如 5
     * @return int 有多少种方法，如 8
     */
    public int climbStairs1(int n) {
        int[] memo = new int[n + 1];
        return climb(memo, n);
    }

    private int climb(int[] memo, int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (memo[n] > 1) {
            return memo[n];
        }
        memo[n] = climb(memo, n - 1) + climb(memo, n - 2);
        return memo[n];
    }

    /**
     * 迭代
     *
     * @param n 数字数组
     * @return int 有多少种方法
     */
    public int climbStairs2(int n) {
        if (n < 3) {
            return n;
        }
        int first = 1;
        int second = 2;
        int res = 0;
        for (int i = 2; i < n; i++) {
            res = first + second;
            first = second;
            second = res;
        }
        return res;
    }
}
