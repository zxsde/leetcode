
package test.unclassified;

import main.java.solutions.unclassified.Q10Ismatch;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;

public class Q10IsmatchTest {

    @Test
    public void isMatch1Test() {
        String s1 = "ab", p1 = "c*a*b";
        String s2 = "aab", p2 = "c*a*b";
        String s3 = "cbaab", p3 = "c*a*b";
        assertTrue(new Q10Ismatch().isMatch1(s1, p1));
        assertTrue(new Q10Ismatch().isMatch1(s2, p2));
        assertFalse(new Q10Ismatch().isMatch1(s3, p3));
    }

    @Test
    public void isMatch2Test() {
        String s1 = "ab", p1 = "c*a*b";
        String s2 = "aab", p2 = "c*a*b";
        String s3 = "cbaab", p3 = "c*a*b";
        assertTrue(new Q10Ismatch().isMatch2(s1, p1));
        assertTrue(new Q10Ismatch().isMatch2(s2, p2));
        assertFalse(new Q10Ismatch().isMatch2(s3, p3));
    }

    @Test
    public void isMatch3() {
        String s1 = "ab", p1 = "c*a*b";
        String s2 = "aab", p2 = "c*a*b";
        String s3 = "cbaab", p3 = "c*a*b";
        assertTrue(new Q10Ismatch().isMatch3(s1, p1));
        assertTrue(new Q10Ismatch().isMatch3(s2, p2));
        assertFalse(new Q10Ismatch().isMatch3(s3, p3));
    }
}