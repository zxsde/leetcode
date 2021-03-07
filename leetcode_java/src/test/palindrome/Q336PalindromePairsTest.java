
package test.palindrome;

import main.java.solutions.palindrome.Q336PalindromePairs;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class Q336PalindromePairsTest {

    @Test
    public void palindromePairsTest() {
        String[] words1 = {"abcd", "dcba", "lls", "s", "sssll"};
        List<List<Integer>> expected1 = new ArrayList<>();
        expected1.add(Arrays.asList(0, 1));
        expected1.add(Arrays.asList(1, 0));
        expected1.add(Arrays.asList(3, 2));
        expected1.add(Arrays.asList(2, 4));
        List<List<Integer>> res1 = new Q336PalindromePairs().palindromePairs(words1);
        assertEquals(new HashSet<>(expected1), new HashSet<>(res1));

        String[] words2 = {"a", ""};
        List<List<Integer>> expected2 = new ArrayList<>();
        expected2.add(Arrays.asList(0, 1));
        expected2.add(Arrays.asList(1, 0));
        List<List<Integer>> res2 = new Q336PalindromePairs().palindromePairs(words2);
        assertEquals(new HashSet<>(expected2), new HashSet<>(res2));
    }
}