
package main.java.solutions.unclassified;

/**
 * 14. Longest Common Prefix -- 最长公共前缀 。
 * https://leetcode.com/problems/longest-common-prefix/
 *
 * @author zx
 * @since 2021-01-21
 */
public class Q14LongestCommonPrefix {

    /**
     * 对第一个单词的每一位，与其它单词相同的位置进行对比，看是否匹配
     *
     * @param strs 字符串数组，如 {"flower", "flow", "flight"}
     * @return String 最长公共前缀，如 "fl"
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 对 flower 的每一位，遍历其余单词的对应位置，看是否匹配
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                // 某个单词已经遍历完，或者遇到了不匹配的字母，结束
                if (i == strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
