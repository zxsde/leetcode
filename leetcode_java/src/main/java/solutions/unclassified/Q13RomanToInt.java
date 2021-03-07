
package main.java.solutions.unclassified;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer -- 罗马数字转整数。
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * https://leetcode.com/problems/roman-to-integer/
 *
 * @author zx
 * @since 2021-01-19
 */
public class Q13RomanToInt {
    /**
     * 把数字的对应关系保存成 Map，遍历 s，小于后一位就减，大于后一位就加
     *
     * @param s 罗马数字，如 "MCMXCIV"
     * @return int 阿拉伯数字， 如 1994
     */
    public int romanToInt(String s) {
        if (s == null || s.length() == 0)
            return -1;
        int num = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        for (int i = 0; i < s.length() - 1; i++) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                num += map.get(s.charAt(i));
            } else {
                num -= map.get(s.charAt(i));
            }
        }

        return num + map.get(s.charAt(s.length() - 1));
    }
}
