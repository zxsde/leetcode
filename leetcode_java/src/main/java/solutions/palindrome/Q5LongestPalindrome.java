
package main.java.solutions.palindrome;

/**
 * 5. Longest Palindromic Substring -- 最长回文子串
 * 题目： https://leetcode.com/problems/longest-palindromic-substring/
 *
 * @author zx
 * @since 2020-12-24
 */
public class Q5LongestPalindrome {
    /**
     * 方法一：中心扩展法。对每个位置，向左右两侧延申，找最长的回文串。
     * 参考： https://leetcode.com/problems/longest-palindromic-substring/discuss/2954/
     *
     * @param s 字符串，如 "babbad"
     * @return String 最长回文子串，如 "abba"
     */
    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        String palindrome = "";
        for (int i = 0; i < s.length(); i++) {
            // 奇数最大回文串
            String tmp1 = getLongestPalindrome(s, i, i);
            if (tmp1.length() > palindrome.length()) {
                palindrome = tmp1;
            }

            // 偶数最大回文串
            String tmp2 = getLongestPalindrome(s, i, i + 1);
            if (tmp2.length() > palindrome.length()) {
                palindrome = tmp2;
            }
        }
        return palindrome;
    }

    // 向左右两边扩展，找到最大的回文串
    private String getLongestPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    /**
     * 方法二：中心扩展法。和方法一差不多，时空复杂度都稍有提升。
     *
     * @param s 字符串，如 "babbad"
     * @return String 最长回文子串，如 "abba"
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int lenOdd = getLongestPalindrome2(s, i, i);  // 回文长度为奇数
            int lenEvent = getLongestPalindrome2(s, i, i + 1);  // 回文长度为偶数
            int lenMax = Math.max(lenOdd, lenEvent);
            // 根据中间位置 i 求最大回文的首尾下标，偶数时候 i 是偏左的，
            // 所以求起点时候要减一再除以 2，终点则不必，举例推导一下即可。
            if (lenMax > end - start) {
                start = i - (lenMax - 1) / 2;
                end = i + lenMax / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    // 向左右两边扩展，找到最大的回文串，返回长度
    private int getLongestPalindrome2(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    /**
     * 方法三：动态规划。dp[l][r] == true 代表 l 到 r 的这段子串是回文。
     *
     * @param s 输入字符串
     * @return String 最长回文子串
     */
    public String longestPalindrome3(String s) {
        int n = s.length();
        int start = 0, end = 0;
        boolean[][] dp = new boolean[n][n];
        for (int r = 0; r < n; r++) {
            dp[r][r] = true;
            for (int l = 0; l < r; l++) {
                // s[i] == s[j] 时 dp[l][r] 是回文需要两个条件，或者相邻，或者不相邻，但 dp[i + 1][j - 1] = true 。
                // 相邻时 dp[l + 1][r - 1] 越界，所以先判断 r - l == 1。
                if (s.charAt(l) == s.charAt(r) && (r - l == 1 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l > end - start) {
                        start = l;
                        end = r;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
