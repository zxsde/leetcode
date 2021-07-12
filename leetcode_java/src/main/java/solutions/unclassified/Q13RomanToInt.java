
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
 * 题目： https://leetcode.com/problems/roman-to-integer/
 * 参考： https://leetcode-cn.com/problems/roman-to-integer/solution/luo-ma-shu-zi-zhuan-zheng-shu-by-leetcod-w55p/
 * 参考： https://leetcode-cn.com/problems/roman-to-integer/solution/yong-shi-9993nei-cun-9873jian-dan-jie-fa-by-donesp/
 *
 * @author zx
 * @since 2021-01-19
 */
public class Q13RomanToInt {
    /**
     * 方法一：hashMap。把数字的对应关系保存成 Map，遍历 s，小于后一位就减，大于后一位就加。
     * 时间复杂度 O(n)，小数据量情况下 hashmap 显示不出优势，用 switch 会更快。
     * 时间复杂度 O(n)。
     *
     * @param s 罗马数字，如 "MCMXCIV"
     * @return int 阿拉伯数字， 如 1994
     */
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int sum = 0;
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
                sum += map.get(s.charAt(i));
            } else {
                sum -= map.get(s.charAt(i));
            }
        }

        // for 循环没有遍历到最后一位，最后加上
        return sum + map.get(s.charAt(s.length() - 1));
    }

    /**
     * 方法二：switch。思路上和上面相同，遍历 s，小于后一位就减，大于后一位就加。
     * 时间复杂度 O(n)，小数据量情况下 switch 比 hashmap 更快。
     * 时间复杂度 O(n)。
     *
     * @param s 罗马数字，如 "MCMXCIV"
     * @return int 阿拉伯数字， 如 1994
     */
    public int romanToInt2(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int curNum = getValue(s.charAt(i));
            if (preNum < curNum) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = curNum;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
