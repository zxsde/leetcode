
package test.palindrome;

import main.java.solutions.palindrome.Q3LengthOfLongestSubstring;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Q3LengthOfLongestSubstringTest {

    @Test
    public void lengthOfLongestSubstring1() {
        String s1 = "abcabcbb";
        int res1 = new Q3LengthOfLongestSubstring().lengthOfLongestSubstring1(s1);
        int expected = 3;  // "abc"
        assertEquals(expected, res1);
    }

    @Test
    public void lengthOfLongestSubstring2() {
        String s1 = "abcbad";
        int res1 = new Q3LengthOfLongestSubstring().lengthOfLongestSubstring2(s1);
        int expected = 4;  // "cbad"
        assertEquals(expected, res1);
    }
}