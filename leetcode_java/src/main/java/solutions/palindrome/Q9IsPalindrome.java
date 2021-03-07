
package main.java.solutions.palindrome;

/**
 * 9. Palindrome Number -- 回文数。
 * https://leetcode.com/problems/palindrome-number
 *
 * @author zx
 * @since 2021-01-09
 */
public class Q9IsPalindrome {
    /**
     * 一个整数分成两部分，右侧反转后如果等于左侧，说明是回文，10 的整数倍单独处理
     *
     * @param x 数字，如 12321
     * @return boolean 是否为回文，如 True
     */
    public boolean isPalindrome(int x) {
        // 负数和 10 的整数倍一定不是回文，但 0 是回文
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        // 1221 处理完是 x = 12, rev = 12
        // 121 处理完是 x = 1, rev = 12
        return x == rev || x == rev / 10;
    }
}
