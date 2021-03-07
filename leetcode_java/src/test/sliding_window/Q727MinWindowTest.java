
package test.sliding_window;

import main.java.solutions.sliding_window.Q727MinWindow;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q727MinWindowTest {

    @Test
    public void minWindowTest() {
        String s2 = "ababcbd", t2 = "abbd";
        String res = new Q727MinWindow().minWindow(s2, t2);
        String expected = "abcbd";
        assertEquals(expected, res);
    }
}