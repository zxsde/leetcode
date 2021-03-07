
package main.java.solutions.sliding_window;

import java.util.HashMap;
import java.util.Map;

/*
 * 和76差不多，76可以看成是 s2 包含 s1全部字符就行了，但本题是 s2 包含 s1 字符串，
 * 而且是全排列的字符串，字符串和全部字符是有区别的，字符串需要连续匹配才行。
 * 可以用 Map 也可以用数组（int[] s1 = new int[26];），因为只有26个字母构成，下标为元素，值为出现次数。
 * */

/**
 * 567. Permutation in String -- 字符串的排列。
 * https://leetcode.com/problems/permutation-in-string/
 *
 * @author zx
 * @since 2020-12-23
 */
public class Q567CheckInclusion {

    /**
     * 看 s1 的全排列是否在 s2 中，不看顺序，所以先把 s1 处理成 Map1，
     * 遍历 s2 的过程中也保存一个长度为 len(s1) 的 Map2，两个 Map 相等时就找到了
     *
     * @param s1 字符串，如 "ab"
     * @param s2 字符串，如 "eidbaooo"
     * @return boolean True，因为 s2 包含 s1 的排列
     */
    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int len1 = s1.length(), len2 = s2.length();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> win = new HashMap<>();

        if (len1 == 1) {
            return (s2.contains(s1));
        }

        // 全排列不看顺序，所以处理成 Map 最好对比。
        // 把 s1 和 s2 处理成 Map，key 是元素，value 是出现的次数。
        for (int i = 0; i < len1; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (need.containsKey(c1)) {
                need.put(c1, need.get(c1) + 1);
            } else {
                need.put(c1, 1);
            }
            if (win.containsKey(c2)) {
                win.put(c2, win.get(c2) + 1);
            } else {
                win.put(c2, 1);
            }
        }
        // 遍历 s1 长度的元素，两个 Map 相等，直接返回 true
        if (win.equals(need)) {
            return true;
        }

        // 滑动窗口，我们已经遍历了 s1.length() 个元素，这个窗口不符合条件的话，开始右移
        // 通过删除 left 增加 right 向后移动窗口，注意移动过程中对 win 元素个数的加减
        for (int right = len1; right < len2; right++) {
            char cright = s2.charAt(right);
            char cleft = s2.charAt(right - len1);
            // 窗口有边界增 1
            if (win.containsKey(cright)) {
                win.put(cright, win.get(cright) + 1);
            } else {
                win.put(cright, 1);
            }
            // 窗口左边界减 1，如果减一后个数为 0，则删除该键值，方便两个 Map 比较
            if (win.get(cleft) == 1) {
                win.remove(cleft);
            } else {
                win.put(cleft, win.get(cleft) - 1);
            }
            // 滑动后的窗口正好包含 s1 的全排列，返回 true
            if (need.equals(win)) {
                return true;
            }
        }
        return false;
    }
}
