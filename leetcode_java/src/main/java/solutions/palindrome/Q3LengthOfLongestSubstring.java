
package main.java.solutions.palindrome;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum -- 无重复字符的最长子串
 * https://leetcode.com/problems/two-sum/
 *
 * @author zx
 * @since 2020-12-24
 */
public class Q3LengthOfLongestSubstring {

    /**
     * 用 Map 保存遍历过的字母，key 是字母 value 是下标，
     * 如果遇到已存在的字母，就要移动 left，并更新该字母的 value 为最新下标
     *
     * @param s 字符串，如 "abcabcbb"
     * @return int 无重复字符的最长子串，如 3，"abc"
     */
    public int lengthOfLongestSubstring1(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int res = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                // 注意 left 只能往右走，尝试 “abcbade” 到第二个 "a" 时 left 如何走
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, i);
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    /**
     * 滑动窗口，window 保存遍历过的字母，key 是字母 value 是出现次数，
     * 当 s[i] 出现次数大于 1 时就说明有重复字母，需要从窗口左侧逐个弹出字母，
     * 直到 s[i] 出现次数等于 1，记录此时的长度。
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> window = new HashMap<>();
        int res = 0, left = 0;
        for (int right = 0; right < s.length(); right++) {
            if (!window.containsKey(s.charAt(right))) {
                window.put(s.charAt(right), 1);
            } else {
                window.put(s.charAt(right), window.get(s.charAt(right)) + 1);
            }
            while (window.get(s.charAt(right)) > 1) {
                window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
