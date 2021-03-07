
package test.palindrome;

import main.java.solutions.palindrome.Q9IsPalindrome;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;


public class Q9IsPalindromeTest {
    @Test
    public void isPalindromeTest() {
        int x1 = 123321;
        int x2 = 12321;
        int x3 = 0;
        int x4 = 10;
        int x5 = 123210;
        assertTrue(new Q9IsPalindrome().isPalindrome(x1));
        assertTrue(new Q9IsPalindrome().isPalindrome(x2));
        assertTrue(new Q9IsPalindrome().isPalindrome(x3));
        assertFalse(new Q9IsPalindrome().isPalindrome(x4));
        assertFalse(new Q9IsPalindrome().isPalindrome(x5));
    }
}