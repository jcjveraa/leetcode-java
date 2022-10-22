package cyou.jelle;

import java.util.HashMap;
import java.util.Map;

public class S0013RomanToInteger {

    //Constraints:
    //
    //1 <= s.length <= 15
    //s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
    //It is guaranteed that s is a valid roman numeral in the range [1, 3999].

    public int romanToInt(String s) {
        Map<Character, Integer> numeralToInt = new HashMap<>();
        numeralToInt.put('I', 1);
        numeralToInt.put('V', 5);
        numeralToInt.put('X', 10);
        numeralToInt.put('L', 50);
        numeralToInt.put('C', 100);
        numeralToInt.put('D', 500);
        numeralToInt.put('M', 1000);

        char[] splitNumeral = s.toCharArray();
        int accumulator = 0;

        for (int i = 0; i < splitNumeral.length; i++) {
            int current = numeralToInt.get(splitNumeral[i]);
            int next = 0;
            if (i + 1 < splitNumeral.length) {
                next = numeralToInt.get(splitNumeral[i + 1]);
            }

            if (current >= next) {
                accumulator += current;
            } else {
                accumulator -= current;
            }
        }

        return accumulator;
    }

}
