
package main.java.solutions.sliding_window;

import java.util.HashMap;
import java.util.Map;


public class Q727MinWindow {

    /**
     * 本题让我们找出 s 的一个最短子串 w，使得 t 是 w 的子序列。
     * 定义一个 Map，key 是字母 value 是次数，因为可能出现多次，先把 t 处理成 Map，
     * 遍历 s 时候也保存成 Map，当 s 中的某个字母出现次数与 t 中一样时，就是找到了一个，
     * 用 count 记录找到的个数，全部找到后，再从左侧一个一个弹出多余的字母，留下最小的子串。
     *
     * @param s 字符串，如 "ababcbd"，
     * @param t 字符串，如 "abbd"，
     * @return 字符串，s 中包含 t 的最短子序列，如 "abcbd"
     */
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        int count = 0, left = 0;
        int start = 0, end = Integer.MAX_VALUE;
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        // 把 t 处理成 Map，String 不能用 for each，转为字符数组才行
        for (char c : t.toCharArray()) {
            if (!needs.containsKey(c)) {
                needs.put(c, 1);
            } else {
                needs.put(c, needs.get(c) + 1);
            }
        }

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            // 把 s 处理成 Map
            if (!window.containsKey(c)) {
                window.put(c, 1);
            } else {
                window.put(c, window.get(c) + 1);
            }
            // count 记录遍历到的元素个数，注意 ABB 要遍历到 2 个 B 才算成功
            /* 这里注意 Integer 会缓存频繁使用的数值，数值范围为-128到127，
            在此范围内直接返回缓存值。超过该范围就会new 一个对象。而 == 比较的是地址，
            新对象和就对象必然不是同一地址，所以用 equals  */
            if (needs.containsKey(c) && window.get(c).equals(needs.get(c))) {
                count++;
            }
            // 包含 t 的窗口已确定，从左侧收敛窗口大小，确定最小窗口
            while (left <= right && count == needs.size()) {
                // 更新最小窗口，记录左右下标
                if (right - left < end - start) {
                    start = left;
                    end = right;
                }
                // 左侧窗口右移过程中，如果不包含 t 中所有元素了，count 要减一
                window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                if (needs.containsKey(s.charAt(left)) && window.get(s.charAt(left)) < needs.get(s.charAt(left))) {
                    count--;
                }
                left++;
            }
        }
        if (end == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(start, end + 1);
    }
}
