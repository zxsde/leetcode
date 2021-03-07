
package test.palindrome;

import main.java.solutions.palindrome.Q214ShortestPalindrome;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Q214ShortestPalindromeTest {

    @Test
    public void shortestPalindrome1Test() {
        String s1 = "aacecaaa";
        String s2 = "abcdabcy";
        String s3 = "aabaabaaa";
        assertEquals("aaacecaaa", new Q214ShortestPalindrome().shortestPalindrome1(s1));
        assertEquals("ycbadcbabcdabcy", new Q214ShortestPalindrome().shortestPalindrome1(s2));
        assertEquals("aaabaabaaa", new Q214ShortestPalindrome().shortestPalindrome1(s3));
    }

    @Test
    public void shortestPalindrome2Test() {
        String s1 = "aacecaaa";
        String s2 = "abcdabcy";
        String s3 = "aabaabaaa";
        assertEquals("aaacecaaa", new Q214ShortestPalindrome().shortestPalindrome2(s1));
        assertEquals("ycbadcbabcdabcy", new Q214ShortestPalindrome().shortestPalindrome2(s2));
        assertEquals("aaabaabaaa", new Q214ShortestPalindrome().shortestPalindrome2(s3));
    }
}