
package test.unclassified;

import main.java.solutions.unclassified.Q12IntToRoman;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Q12IntToRomanTest {

    @Test
    public void intToRomanTest() {
        int num1 = 58;
        int num2 = 1994;
        assertEquals("LVIII", new Q12IntToRoman().intToRoman(num1));
        assertEquals("MCMXCIV", new Q12IntToRoman().intToRoman(num2));
    }
}