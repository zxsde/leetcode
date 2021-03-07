
package test.unclassified;

import main.java.solutions.unclassified.Q13RomanToInt;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Q13RomanToIntTest {

    @Test
    public void romanToIntTest() {
        String s1 = "LVIII";
        String s2 = "MCMXCIV";
        assertEquals(58, new Q13RomanToInt().romanToInt(s1));
        assertEquals(1994, new Q13RomanToInt().romanToInt(s2));
    }
}