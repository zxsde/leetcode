
package main.java.solutions.unclassified;

/**
 * 12. Integer to Roman -- 整数转罗马数字。
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 题目： https://leetcode.com/problems/integer-to-roman/
 * 参考： https://leetcode-cn.com/problems/integer-to-roman/solution/tan-xin-suan-fa-by-liweiwei1419/
 *
 * @author zx
 * @since 2021-01-16
 */
public class Q12IntToRoman {

    /**
     * 列出数字的对应关系，然后从大到小遍历阿拉伯数字，完成转换
     * 时间复杂度 O(1)，复杂度是 O(1) 的核心原因在于题目限定了范围。
     * 时间复杂度 O(1)。
     *
     * @param num 阿拉伯数字，如 1994
     * @return String 罗马数字，如 "MCMXCIV"
     */
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            // 如果是 python 可以用除，3000 / 1000 = 3，直接 3 * "M" 就是 "MMM"
            while (num >= values[i]) {
                sb.append(symbols[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }
}
