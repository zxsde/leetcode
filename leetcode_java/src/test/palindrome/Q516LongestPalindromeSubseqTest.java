
package test.palindrome;

import main.java.solutions.palindrome.Q516LongestPalindromeSubseq;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q516LongestPalindromeSubseqTest {

    @Test
    public void longestPalindromeSubseqTest() {
        String s = "aacecaaa";
        int res = new Q516LongestPalindromeSubseq().longestPalindromeSubseq(s);
        int expected = 7;
        assertEquals(expected, res);
    }
}