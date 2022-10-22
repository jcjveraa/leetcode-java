package cyou.jelle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution0013RomanToIntegerTest {

    /*
Example 1:
    Input: s = "III"
    Output: 3
    Explanation: III = 3.

Example 2:
    Input: s = "LVIII"
    Output: 58
    Explanation: L = 50, V= 5, III = 3.

Example 3:
    Input: s = "MCMXCIV"
    Output: 1994
    Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     */

    @Test
    void romanToInt() {
        var sol = new Solution_0013_Roman_to_Integer();

        var in1 = "III";
        var out1 = 3;

        var in2 = "LVIII";
        var out2 = 58;

        var in3 = "MCMXCIV";
        var out3 = 1994;

        assertEquals(out1, sol.romanToInt(in1));
        assertEquals(out2, sol.romanToInt(in2));
        assertEquals(out3, sol.romanToInt(in3));
    }
}