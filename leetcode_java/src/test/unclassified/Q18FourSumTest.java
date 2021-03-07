
package test.unclassified;

import main.java.solutions.unclassified.Q18FourSum;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class Q18FourSumTest {

    @Test
    public void fourSum1Test() {
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int target1 = 0;
        List<List<Integer>> res1 = new Q18FourSum().fourSum1(nums1, target1);

        List<List<Integer>> expected1 = new ArrayList<>();
        List<Integer> ans1 = Arrays.asList(-2, -1, 1, 2);
        List<Integer> ans2 = Arrays.asList(-2, 0, 0, 2);
        List<Integer> ans3 = Arrays.asList(-1, 0, 0, 1);
        expected1.add(ans1);
        expected1.add(ans2);
        expected1.add(ans3);

        assertEquals(new HashSet<>(expected1), new HashSet<>(res1));

        int[] nums2 = {};
        int target2 = 0;
        List<List<Integer>> res2 = new Q18FourSum().fourSum1(nums2, target2);
        List<List<Integer>> expected2 = new ArrayList<>();
        assertEquals(new HashSet<>(expected2), new HashSet<>(res2));
    }

    @Test
    public void fourSum2() {
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int target1 = 0;
        List<List<Integer>> res1 = new Q18FourSum().fourSum2(nums1, target1);

        List<List<Integer>> expected1 = new ArrayList<>();
        List<Integer> ans1 = Arrays.asList(-2, -1, 1, 2);
        List<Integer> ans2 = Arrays.asList(-2, 0, 0, 2);
        List<Integer> ans3 = Arrays.asList(-1, 0, 0, 1);
        expected1.add(ans1);
        expected1.add(ans2);
        expected1.add(ans3);

        assertEquals(new HashSet<>(expected1), new HashSet<>(res1));

        int[] nums2 = {};
        int target2 = 0;
        List<List<Integer>> res2 = new Q18FourSum().fourSum2(nums2, target2);
        List<List<Integer>> expected2 = new ArrayList<>();
        System.out.println(expected2);
        assertEquals(new HashSet<>(expected2), new HashSet<>(res2));
    }
}