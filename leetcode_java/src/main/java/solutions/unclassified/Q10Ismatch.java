
package main.java.solutions.unclassified;

/**
 * 10. Regular Expression Matching -- 正则表达式匹配。
 * 题目： https://leetcode.com/problems/regular-expression-matching/
 * 参考： https://leetcode.com/problems/regular-expression-matching/solution/
 * 参考： https://leetcode-cn.com/problems/regular-expression-matching/solution/javadi-gui-yi-bu-yi-bu-de-you-hua-dao-ji-bai-100yi/
 *
 * @author zx
 * @since 2021-01-14
 */
public class Q10Ismatch {
    int[][] memo; //记忆化递归使用

    /**
     * 方法一：暴力递归，仅用于引出记忆化递归，不推荐使用，效率太低。
     * 时间复杂度 O((T+P)*2^(T+P/2)，T 和 P 分别是 s 和 p 的长度。
     * 空间复杂度 O((T+P)*2^(T+P/2)。
     *
     * @param s 被匹配的字符串
     * @param p 正则表达式
     * @return boolean 匹配结果
     */
    public boolean isMatch1(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        // s 和 p 的首字母匹配结果
        boolean match = !s.isEmpty() && ((s.charAt(0) == p.charAt(0)) || p.charAt(0) == '.');
        // 有星号的话，星号前面的字符可能出现 0 次，也可能出现多次
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch1(s, p.substring(2)) || (match && isMatch1(s.substring(1), p));
        }
        return match && isMatch1(s.substring(1), p.substring(1));
    }


    /**
     * 方法二：记忆化递归，暴力递归的代码虽然简洁，但有太多重复的调用
     * 时间复杂度 O(TP)，T 和 P 分别是 s 和 p 的长度。
     * 空间复杂度 O(TP)。
     *
     * @param s 被匹配的字符串，如 "ab"
     * @param p 正则表达式，如 "c*a*b"
     * @return boolean 匹配结果，如 True
     */
    public boolean isMatch2(String s, String p) {
        this.memo = new int[s.length() + 1][p.length() + 1];
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        return isMatchChar(ss, pp, 0, 0);
    }

    private boolean isMatchChar(char[] s, char[] p, int s1, int p1) {
        if (p1 >= p.length) {  //p 用完了之后，s 也用完则 True，否则 False
            return s1 >= s.length;
        }
        if (memo[s1][p1] != 0) {  // 已经算过的，直接返回结果
            return memo[s1][p1] > 0;
        }
        boolean match = s1 < s.length && ((s[s1] == p[p1]) || p[p1] == '.');

        // 对 * 的情况进行匹配，星号前面的字符可能出现 0 次，也可能出现多次
        if (p.length - p1 >= 2 && p[p1 + 1] == '*') {
            boolean t = isMatchChar(s, p, s1, p1 + 2) || (match && isMatchChar(s, p, s1 + 1, p1));
            if (t) {
                memo[s1][p1] = 1;
            } else {
                memo[s1][p1] = -1;
            }
            return t;
        }

        // 对没有 * 的情况进行匹配
        boolean t = match && isMatchChar(s, p, s1 + 1, p1 + 1);
        if (t) {
            memo[s1][p1] = 1;
        } else {
            memo[s1][p1] = -1;
        }
        return t;
    }

    /**
     * 方法三：动态规划，dp[i][j] 表示 s[i+1] 和 p[j+1]的匹配结果，难点在于 * 的前一位可能出现 0 或 1 或 n 次
     * 时间复杂度 O(TP)，T 和 P 分别是 s 和 p 的长度。
     * 空间复杂度 O(TP)。
     *
     * @param s 被匹配的字符串
     * @param p 正则表达式
     * @return boolean 匹配结果
     */
    public boolean isMatch3(String s, String p) {
        int lens = s.length(), lenp = p.length();
        if (lenp == 0) return lens == 0;

        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        boolean dp[][] = new boolean[lens + 1][lenp + 1];
        dp[0][0] = true;
        // s 作为行，p 作为列，但是 dp 要多加一行一列作为空字符的匹配，
        // 初始化星号的情况，因为不能星号开头，所以 p 从下标 1 开始遍历。
        for (int j = 2; j <= lenp; j++) {
            if (pp[j - 1] == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= lens; i++) {
            for (int j = 1; j <= lenp; j++) {
                // 两个字符相同的话，当前结果和前一位的匹配结果一致
                if (ss[i - 1] == pp[j - 1] || pp[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pp[j - 1] == '*') {
                    // * 的前一位可以匹配，那 * 可能代表前一位出现 0 次或多次
                    if (ss[i - 1] == pp[j - 2] || pp[j - 2] == '.') {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    } else { // * 的前一位不能匹配，那 * 可能代表前一位出现 0 次。注意顺序.
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[lens][lenp];
    }
}


/*
转移方程：
1.	如果p[j - 1] == s[i - 1] or p[j - 1] == '.' ，那就看它们之前的字符是否匹配，例如 abc和ab. 是否匹配，看ab 和ab就行了，所以dp[i][j] = dp[i - 1][j - 1]。

2.	当遇到 * 的时候会有三种情况，具体属于哪种情况要看 * 前一位的匹配情况：
a.	* 表示前一个字母出现 0 次，如 s = xa 和 p = xab* 。* 的前一位出现 0 次，那么看 * 的前二位和s的匹配结果就行，即 xa 和 xa，也就是 dp[i][j] = dp[i][j - 2] 。

b.	* 表示前一个字母出现1 次，如 s = xa和 p = xa* 。* 的前一位出现 1 次，那么看 * 的前一位和 s 的匹配结果就行，即xa 和xa，也就是 dp[i][j] = dp[i][j - 1]。这一步其实可以省略，因为 * 的前一位出现多次的情况，会覆盖这一种情况。

c.	* 表示前一个字母出现多次，如 s = xaa 和 p = xa* 。* 的前一位出现 2 次，那么看 p 和s前一位的匹配结果就行，即 xa 和 xa* ，也就是 dp[i][j] = dp[i - 1][j]。但是这种情况会覆盖情况b，因为假如出现3次，最终也要先检查出现2次的情况，再检查出现一次的情况。

归纳一下，注意i和j是dp的下标，对应到s和p中要减一：
1.	如果 p[j-1] == s[i-1] or p[j-1] == '.' :  dp[i][j] = dp[i-1][j-1] ；
2.	如果 p[j-1] == '*' ，考虑两种情况就行了：
a.	如果 p[j - 2] == s[i - 1] or p[j - 2] == '.':  dp[i][j] = dp[i][j - 2] or dp[i][j - 1] or dp[i - 1][j]。表示 * 的前一个字母出现 0 次 1 次 多次。注意判断顺序，因为“点”属于能匹配的情况，先判断情况b的话，会当作不能匹配处理。
b.	如果 p[j - 2] != s[i - 1] :  dp[i][j] = dp[i][j-2]。* 表示前一个字母出现 0 次。

*/
