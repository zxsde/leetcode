package test.unclassified;

import main.java.solutions.unclassified.Q1814CountNicePairs;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Q1814CountNicePairsTest {

    @Test
    public void countNicePairs() {
        int[] nums = new int[]{42, 11, 1, 97};
        int res = new Q1814CountNicePairs().countNicePairs(nums);
        int expected = 2;
        assertEquals(expected, res);
    }
}