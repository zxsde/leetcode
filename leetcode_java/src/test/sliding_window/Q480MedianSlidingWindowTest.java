
package test.sliding_window;

import main.java.solutions.sliding_window.Q480MedianSlidingWindow;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Q480MedianSlidingWindowTest {

    @Test
    public void medianSlidingWindowTest() {
        int[] nums1 = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        double[] res1 = new Q480MedianSlidingWindow().medianSlidingWindow(nums1, k1);
        double[] expected1 = {1.0, -1.0, -1.0, 3.0, 5.0, 6.0};
        assertArrayEquals(expected1, res1, 0.0);
    }
}