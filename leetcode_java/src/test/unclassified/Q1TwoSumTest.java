
package test.unclassified;

import main.java.solutions.unclassified.Q1TwoSum;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Q1TwoSumTest {

    @Test
    public void twoSumTest() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] res = new Q1TwoSum().twoSum(nums, target);
        int[] expected = {0, 1};
        assertArrayEquals(expected, res);
    }
}