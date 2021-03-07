
package test.sliding_window;

import main.java.solutions.sliding_window.Q567CheckInclusion;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q567CheckInclusionTest {

    @Test
    public void checkInclusionTest() {
        String s1_1 = "abid";
        String s1_2 = "eidbaooo";
        boolean res1 = new Q567CheckInclusion().checkInclusion(s1_1, s1_2);
        assertTrue(res1);

        String s2_1 = "ab";
        String s2_2 = "eidboaooo";
        boolean res2 = new Q567CheckInclusion().checkInclusion(s2_1, s2_2);
        assertFalse(res2);
    }
}