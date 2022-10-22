package cyou.jelle;

import static org.junit.jupiter.api.Assertions.*;

class solution0001SumTwoTest {
    int[] nums = {2, 7, 11, 15};
    int target = 9;

    int[] nums2 = {3,2,4};
    int target2 = 6;

    @org.junit.jupiter.api.Test
    void twoSum() {
        var sol = new Solution_0001_Sum_Two();

        int[] expected = {0,1};
        var result = sol.twoSum(nums, target);
        assertArrayEquals(expected, result);

        int[] expected2 = {1,2};
        result = sol.twoSum(nums2, target2);
        assertArrayEquals(expected2, result);
    }
}