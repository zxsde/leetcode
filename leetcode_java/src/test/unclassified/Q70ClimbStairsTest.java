
package test.unclassified;

import main.java.solutions.unclassified.Q70ClimbStairs;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Q70ClimbStairsTest {

    @Test
    public void climbStairs1Test() {
        assertEquals(3, new Q70ClimbStairs().climbStairs1(3));
        assertEquals(8, new Q70ClimbStairs().climbStairs1(5));
    }

    @Test
    public void climbStairs2Test() {
        assertEquals(3, new Q70ClimbStairs().climbStairs2(3));
        assertEquals(8, new Q70ClimbStairs().climbStairs2(5));
    }
}