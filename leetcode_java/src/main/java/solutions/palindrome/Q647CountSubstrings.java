
package main.java.solutions.palindrome;

/**
 * 647. Palindromic Substrings -- 回文子串。
 * https://leetcode.com/problems/palindromic-substrings/
 *
 * @author zx
 * @since 2021-01-06
 */
public class Q647CountSubstrings {

    /**
     * 中心扩展法，和 第 5 题差不多，对每个字母，找以它为中心的最长回文
     *
     * @param s 字符串，如 "abcc"
     * @return int 中回文子串的个数，如 5，{"a", "b", "c", "c", "cc"}
     */
    public int countSubstrings1(String s) {
        if (s.length() < 2) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += getPalindromic(s, i, i);  // 奇数长度的回文
            count += getPalindromic(s, i, i + 1);  // 偶数长度的回文
        }
        return count;
    }

    // 向左右两边扩展，找到最大回文串
    public int getPalindromic(String s, int l, int r) {
        int c = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            c++;
            l--;
            r++;
        }
        return c;
    }

    /**
     * 动态规划，dp[i][j] = True 表示 s[i] ~ s[j] 是回文
     *
     * @param s 字符串，如 "abcc"
     * @return int 中回文子串的个数，如 5，{"a", "b", "c", "c", "cc"}
     */
    public int countSubstrings2(String s) {
        int n = s.length();
        if (n < 2) {
            return 1;
        }
        int count = 0;
        boolean[][] dp = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            dp[j][j] = true;
            for (int i = 0; i <= j; i++) {  // 取到 i == j，防止漏掉单个字母
                // s[i] == s[j] 时，若dp[i][j]是回文，要么它们相邻，要么它们之间的元素是回文
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    count++;
                }
            }
        }
        return count;
    }
}
