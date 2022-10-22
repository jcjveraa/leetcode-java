package cyou.jelle;

import java.util.Random;

public class S0004MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] one = new int[10000];
        int[] two = new int[10000];

        var sol = new S0004MedianOfTwoSortedArrays();
        double linearTime = 0;
        double binarySearchtime = 0;
        int iterations = 100_000;
        for (int i = 0; i < iterations; i++) {
            fillArrays(one, two);
            long start = System.nanoTime();
            sol.findMedianSortedArrays(one, two);
            linearTime += ((System.nanoTime() - start)/1e9d) ;
            start = System.nanoTime();
            sol.findMedianSortedArraysWithBinarySearch(one, two);
            binarySearchtime += ((System.nanoTime() - start)/1e9d);
        }

        System.out.println("Linear: " + linearTime);
        System.out.println("BinSearch: " + binarySearchtime);

    }

   private static void fillArrays(int[] one, int[] two) {
        int i=0, j=0;
        int value = 1;
        Random random = new Random();
        while (i < one.length && j < two.length) {
            var arrayPicker = random.nextInt(2);
            value += random.nextInt(1,5);
            if(arrayPicker == 0) {
                one[i++] = value;
            } else
            {
                two[j++] = value;
            }
        }

        while (i < one.length) {
            value += random.nextInt(1,5);
            one[i++] = value;
        }
        while (j < two.length) {
            value += random.nextInt(1,5);
            two[j++] = value;
        }
    }

    // My first less than optimal solution
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int numNumbers = nums1.length + nums2.length;
        boolean isEven = numNumbers % 2 == 0;
        int mergedArraySize = numNumbers / 2 + 1;

        var lastTwoItemsOfMergedArray = solve(nums1, nums2, mergedArraySize);
        return isEven ? (lastTwoItemsOfMergedArray[0] + lastTwoItemsOfMergedArray[1]) / 2d : lastTwoItemsOfMergedArray[0];
    }

    // Basic array merge algorithm without actually merging the array
    int[] solve(int[] nums1, int[] nums2, int mergedArraySize) {
        int i = 0, j = 0, k = 0;
        int[] lastTwoItemsOfMergedArray = new int[2];

        while (k < mergedArraySize && i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                pushRight(lastTwoItemsOfMergedArray, nums1[i++]);
            } else {
                pushRight(lastTwoItemsOfMergedArray, nums2[j++]);
            }
            k++;
        }

        // Loop over anything that remains
        while (i < nums1.length && k < mergedArraySize) {
            pushRight(lastTwoItemsOfMergedArray, nums1[i++]);
            k++;
        }
        while (j < nums2.length && k < mergedArraySize) {
            pushRight(lastTwoItemsOfMergedArray, nums2[j++]);
            k++;
        }

        return lastTwoItemsOfMergedArray;
    }

    private void pushRight(int[] toPush, int newValue) {
        toPush[1] = toPush[0];
        toPush[0] = newValue;
    }

    private void findMedianSortedArraysWithBinarySearch(int[] one, int[] two) {
    }


}
