
package test.palindrome;

import main.java.solutions.palindrome.Q5LongestPalindrome;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Q5LongestPalindromeTest {
    @Test
    public void longestPalindrome1Test() {
        String s1 = "babbad";
        String s2 = "bbabbad";
        assertEquals("abba", new Q5LongestPalindrome().longestPalindrome1(s1));
        assertEquals("bbabb", new Q5LongestPalindrome().longestPalindrome1(s2));
    }

    @Test
    public void longestPalindrome2Test() {
        String s1 = "babbad";
        String s2 = "bbabbad";
        assertEquals("abba", new Q5LongestPalindrome().longestPalindrome2(s1));
        assertEquals("bbabb", new Q5LongestPalindrome().longestPalindrome2(s2));
    }
}