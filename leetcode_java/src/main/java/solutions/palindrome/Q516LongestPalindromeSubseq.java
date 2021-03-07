
package main.java.solutions.palindrome;


/**
 * 516. Longest Palindromic Subsequence -- 最长回文子序列。
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 *
 * @author zx
 * @since 2021-01-05
 */
public class Q516LongestPalindromeSubseq {

    /**
     * 子序列可以不连续，子串必须连续。
     * 动态规划，dp[i][j] 是从 i 到 j 的最大回文长度。
     * 只要 s[i] == s[j] 则 dp[i][j] 就是 s[i+1] ~ s[j-1] 的最大回文长度加 2
     * 若 s[i] != s[j] 则 dp[i][j] 就是 s[i+1] ~ s[j] 和 s[i] ~ s[j-1] 中大的那个。
     *
     * @param s 字符串，如 "aacecaaa"
     * @return int 最长回文子序列的长度，如 7，"aacecaa"长度为 7
     */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        // 注意 j 从 0 到 n，i 从 j 到 0 ，增长方向相反
        for (int j = 0; j < n; j++) {
            dp[j][j] = 1;
            for (int i = j - 1; i >= 0; i--) {
                // 只要 s[i] == s[j] 则回文长度 + 2
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    // 要用到 dp[i + 1][j]，所以 i 和 j 增长方向相反
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
