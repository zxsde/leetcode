
package test.sliding_window;

import main.java.solutions.sliding_window.Q239MaxSlidingWindow;
import org.junit.Test;


import static org.junit.Assert.assertArrayEquals;

public class Q239MaxSlidingWindowTest {

    @Test
    public void maxSlidingWindowTest() {
        int[] nums1 = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        int[] res = new Q239MaxSlidingWindow().maxSlidingWindow(nums1, k1);
        int[] expected = {3, 3, 5, 5, 6, 7};
        assertArrayEquals(expected, res);
    }
}