package cyou.jelle;

import java.util.HashMap;
import java.util.Map;

public class S0001SumTwo {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complements = new HashMap<>();

        int[] result = new int[2];
        boolean solutionFound = false;

        var currentNumber = nums[0];
        var difference = target - currentNumber;
        complements.put(difference, 0);

        for (int i = 1; !solutionFound; i++) {
            currentNumber = nums[i];
            if(complements.containsKey(currentNumber)) {
                result[0] = complements.get(currentNumber);
                result[1] = i;
                solutionFound = true;
            }
            difference = target - currentNumber;
            complements.put(difference,i);
        }

        return result;
    }

}
