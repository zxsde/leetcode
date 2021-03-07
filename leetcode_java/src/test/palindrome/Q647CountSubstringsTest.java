
package test.palindrome;

import main.java.solutions.palindrome.Q647CountSubstrings;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q647CountSubstringsTest {

    @Test
    public void countSubstrings1Test() {
        String s1 = "aaa";
        int res1 = new Q647CountSubstrings().countSubstrings1(s1);
        int expected1 = 6;
        assertEquals(expected1, res1);

        String s2 = "abcc";
        int res2 = new Q647CountSubstrings().countSubstrings1(s2);
        int expected2 = 5;
        assertEquals(expected2, res2);
    }

    @Test
    public void countSubstrings2Test() {
        String s1 = "aaa";
        int res1 = new Q647CountSubstrings().countSubstrings2(s1);
        int expected1 = 6;
        assertEquals(expected1, res1);

        String s2 = "abcc";
        int res2 = new Q647CountSubstrings().countSubstrings2(s2);
        int expected2 = 5;
        assertEquals(expected2, res2);
    }
}