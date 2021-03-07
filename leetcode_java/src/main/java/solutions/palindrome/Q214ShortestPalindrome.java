
package main.java.solutions.palindrome;

import java.util.Arrays;

/**
 * 214. Shortest Palindrome -- 最短回文串。
 * https://leetcode.com/problems/shortest-palindrome/
 *
 * @author zx
 * @since 2021-01-05
 */
public class Q214ShortestPalindrome {

    /**
     * 我们可以把字符串看成两部分： s = s1 + s2，用 s2` 表示 s2 的逆序，
     * 如果 s1 是回文，那么 s2` + s1 + s2 就是回文，如 s = abadc,
     * 可以看到 aba 是重复的，只需要补充 cd 就 成了 cdabadc
     *
     * @param s 字符串， 如 "aacecaaa"
     * @return 最短回文串， 如 "aaacecaaa"，在 s 前加一个 "a" 就可以组成回文
     */
    public String shortestPalindrome1(String s) {
        int idx = 0;
        for (int i = 1; i <= s.length(); i++) {
            // StringBuilder 可以使用 reverse 方法，找出最长回文，记录下标
            String rev = new StringBuilder(s.substring(0, i)).reverse().toString();
            if (s.substring(0, i).equals(rev)) {
                idx = i;
            }
        }
        return new StringBuilder(s.substring(idx)).reverse() + s;
    }

    /**
     * 本题仅需找到最大回文前缀的长度即可，正好可以用 KMP 的 next 数组，O(n)。
     * 令 str = s + '#' + s`，则 str = abab#baba。求出 str 的 next 数组，
     * next[-1] 就是 str 的最长公共前后缀的长度，即 s 的最长回文前缀的长度。
     *
     * @param s 字符串
     * @return 最短回文串
     */
    public String shortestPalindrome2(String s) {
        if (s.length() < 2) {
            return s;
        }
        String str = s + '#' + new StringBuilder(s).reverse();
        int[] next = getLastNext(str);
        int idx = next[str.length() - 1]; // 回文前缀的最大长度
        return new StringBuilder(s.substring(idx)).reverse() + s;
    }

    /**
     * KMP 是字符串匹配算法，常用于求 s 和 p 的匹配情况，重点是求 pattern 的 next 数组。
     *
     * next[i] 是 s[0: i] 的公共前后缀的长度，如：
     * pattern: a b c d a b c y
     * next:    0 0 0 0 1 2 3 0
     * 其实是个 dp ，参考 https://www.bilibili.com/video/BV1hW411a7ys ，
     * 不过 12.15 开始说的侧着移位有点难理解，可以参考 https://youtu.be/GTJr8OvyEVQ ，
     *
     * @param s 字符串
     * @return next 数组
     */
    public int[] getLastNext(String s) {
        int n = s.length();
        int[] next = new int[n];
        next[0] = 0;
        int i = 0, j = 1;
        // 通过 s[i] 和 s[j] 比较，求出 next 数组，我习惯 i 在前 j 在后。
        while (j < n) {
            if (s.charAt(i) == s.charAt(j)) { // 相等，i 和 j 一起向后移
                next[j] = i + 1;
                i++;
                j++;
            } else if (i == 0) {  // 当 i == 0 时移动到头了，更新 next[j]
                next[j] = 0;
                j++;
            } else{  // 不等，且 i 没移动到头，那就移动 i
                i = next[i-1];
            }
        }
        System.out.println(Arrays.toString(next));
        return next;
    }
}
