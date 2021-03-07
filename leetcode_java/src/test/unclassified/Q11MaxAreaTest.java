
package test.unclassified;

import main.java.solutions.unclassified.Q11MaxArea;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Q11MaxAreaTest {

    @Test
    public void maxAreaTest() {
        int[] height = {4, 3, 2, 1, 4};
        assertEquals(16, new Q11MaxArea().maxArea(height));
    }
}