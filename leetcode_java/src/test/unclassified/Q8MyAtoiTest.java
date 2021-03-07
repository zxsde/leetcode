
package test.unclassified;

import main.java.solutions.unclassified.Q8MyAtoi;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class Q8MyAtoiTest {
    @Test
    public void myAtoiTest() {
        String s1 = "-42";
        String s2 = "2147483647";
        String s3 = "2147483648";
        String s4 = "-2147483647";
        String s5 = "-2147483648";
        assertEquals(-42, new Q8MyAtoi().myAtoi(s1));
        assertEquals(2147483647, new Q8MyAtoi().myAtoi(s2));
        assertEquals(2147483647, new Q8MyAtoi().myAtoi(s3));
        assertEquals(-2147483647, new Q8MyAtoi().myAtoi(s4));
        assertEquals(-2147483648, new Q8MyAtoi().myAtoi(s5));
        assertEquals(-42, new Q8MyAtoi().myAtoi(s1));
    }
}