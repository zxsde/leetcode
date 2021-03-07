
package main.java.solutions.unclassified;

/**
 * 8. String to Integer (atoi) -- 字符串转换整数 (atoi)
 * https://leetcode.com/problems/string-to-integer-atoi/
 *
 * @author zx
 * @since 2021-01-08
 */
public class Q8MyAtoi {
    /**
     * 按题意，小于等于 −2^31 的返回 −2^31 ，大于 2^31 − 1 的返回 2^31，极小值个位数是 -8，极大值个位数是 7
     * 转换时候统一按照正数处理，最后再加符号。所以判断边界时，只要个位数大于 7 就是越界，根据符号输出极大/小值。
     *
     * @param s 字符串，如 "-42"
     * @return int 转换后的数字，如 -42
     */
    public int myAtoi(String s) {
        int start = 0, sign = 1;
        int num = 0;
        // 去掉前置空格，因为遍历到非数字就结束，所以结尾空格不用管
        while (start < s.length() && s.charAt(start) == ' ') {
            start++;
        }
        // s = "" 和 s = " " 都返回 0
        if (s.length() == 0 || start == s.length()) {
            return 0;
        }
        // 判断正负，并跳过符号，转换时候统一按照正数处理，最后再加符号。
        if (s.charAt(start) == '-' || s.charAt(start) == '+') {
            sign = (s.charAt(start) == '+') ? 1 : -1;
            start++;
        }
        // 也可用 Character.isDigit(char) 判断 char 是否为数字
        while (start < s.length() && s.charAt(start) >= '0' && s.charAt(start) <= '9') {
            // char 转换为数字不能用 int，int curnum 会变成 ASCII 码
            int curnum = s.charAt(start) - '0';
            if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && curnum > 7)) {
                if (sign == 1) {  // 正数
                    return Integer.MAX_VALUE;
                } else {  // 负数
                    return Integer.MIN_VALUE;
                }
            }
            num = num * 10 + curnum;
            start++;
        }
        return num * sign;
    }
}
