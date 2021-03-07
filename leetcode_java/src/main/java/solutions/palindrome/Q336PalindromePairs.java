
package main.java.solutions.palindrome;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

/**
 * 336. Palindrome Pairs -- 回文对
 * https://leetcode.com/problems/palindrome-pairs/
 *
 * @author zx
 * @since 2021-01-05
 */
public class Q336PalindromePairs {

    /**
     * 对每个单词，从头到尾拆分成两部分，如果前/后缀是回文，只需要看另一部分的逆序是否存在
     * 尝试两个边界案例： ["a",""] 和 ["abc","cba"]
     *
     * @param words 字符串数组，如 {"abcd", "dcba", "lls", "s", "sssll"}
     * @return 回文对，如 {{0, 1}, {1, 0}, {3, 2}, {2, 4}}
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> wordsMap = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        // 把 words 处理成 Map，key 是单词，value 是下标，不存在重复的单词。
        for (int i = 0; i < words.length; i++) {
            wordsMap.put(words[i], i);
        }
        // 遍历每个单词，把每个单词拆分成前后缀，如果前缀是回文，如果后缀的逆序存在则可组成回文。
        // 如果后缀是回文，如果前缀的逆序存在则可组成回文。
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j <= word.length(); j++) {
                String prefix = word.substring(0, j);  // 前缀
                String suffix = word.substring(j);     // 后缀
                String prefixRev = new StringBuilder(prefix).reverse().toString();  // 前缀逆序
                String suffixRev = new StringBuilder(suffix).reverse().toString();  // 后缀逆序
                if (prefix.equals(prefixRev)) {   // 如果前缀是回文，把后缀逆序加前面
                    // 后缀逆序不是 word 本身（以防 aaa 这种自己和自己组成回文），且后缀逆序存在，可组成回文。
                    if (!suffixRev.equals(word) && wordsMap.containsKey(suffixRev)) {
                        res.add(Arrays.asList(wordsMap.get(suffixRev), i));
                    }
                }
                // j == word.length() 的情况和 j == 0 的情况重复。
                if (j != word.length() && suffix.equals(suffixRev)) {   // 如果后缀是回文，把前缀逆序加后面
                    // 前缀逆序不是 word 本身（以防自己和自己组成回文），且后缀逆序存在，可组成回文。
                    if (!prefixRev.equals(word) && wordsMap.containsKey(prefixRev)) {
                        res.add(Arrays.asList(i, wordsMap.get(prefixRev)));
                    }
                }
            }
        }
        return res;
    }
}
