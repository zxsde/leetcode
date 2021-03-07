
package test.unclassified;

import main.java.solutions.unclassified.Q14LongestCommonPrefix;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Q14LongestCommonPrefixTest {

    @Test
    public void longestCommonPrefixTest() {
        String[] strs = {"flower", "flow", "flight"};
        String res = new Q14LongestCommonPrefix().longestCommonPrefix(strs);
        String expected = "fl";
        assertEquals(expected, res);
    }
}