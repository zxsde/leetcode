
package test.unclassified;

import main.java.solutions.unclassified.Q295MedianFinder;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Q295MedianFinderTest {

    @Test
    public void medianFinderTest() {
        Q295MedianFinder obj = new Q295MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        obj.addNum(3);
        double param_1 = obj.findMedian();
        assertEquals(2.0, param_1);

        obj.addNum(4);
        double param_2 = obj.findMedian();
        assertEquals(2.5, param_2);
    }
}