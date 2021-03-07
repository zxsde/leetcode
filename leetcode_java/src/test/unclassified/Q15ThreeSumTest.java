
package test.unclassified;

import main.java.solutions.unclassified.Q15ThreeSum;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class Q15ThreeSumTest {

    @Test
    public void threeSumTest() {
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res1 = new Q15ThreeSum().threeSum(nums1);

        List<List<Integer>> expected1 = new ArrayList<>();
        List<Integer> ans1 = Arrays.asList(-1, -1, 2);
        List<Integer> ans2 = Arrays.asList(-1, 0, 1);
        expected1.add(ans1);
        expected1.add(ans2);

        assertEquals(new HashSet<>(res1), new HashSet<>(expected1));

        int[] nums2 = {0};
        List<List<Integer>> res2 = new Q15ThreeSum().threeSum(nums2);
        List<List<Integer>> expected2 = new ArrayList<>();
        assertEquals(new HashSet<>(res2), new HashSet<>(expected2));
    }
}