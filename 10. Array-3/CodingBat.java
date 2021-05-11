public class CodingBat {

    /*
    maxSpan
    Consider the leftmost and righmost appearances of some value in an array. We'll say that
    the "span" is the number of elements between the two inclusive. A single value has a span
    of 1. Returns the largest span found in the given array. (Efficiency is not a priority.)
     */
    public int maxSpan(int[] nums) {
        int span = 0;
        int j;
        for (int i = 0; i < nums.length; i++) {
            j = nums.length - 1;
            while (nums[j] != nums[i]) {
                j--;
            }
            span = Math.max(span, j - i + 1);
        }
        return span;
    }

    /*
    fix34
    Return an array that contains exactly the same numbers as the given array, but rearranged
    so that every 3 is immediately followed by a 4. Do not move the 3's, but every other
    number may move. The array contains the same number of 3's and 4's, every 3 has a
    number after it that is not a 3, and a 3 appears in the array before any 4.
     */
    public int[] fix34(int[] nums) {
        int[] array = nums.clone();
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 3) {
                if (i > 0 && array[i - 1] == 3) {
                    array[i] = 4;
                } else {
                    while (nums[index] == 3 || nums[index] == 4) {
                        index++;
                    }
                    array[i] = nums[index++];
                }
            }
        }
        return array;
    }

    /*
    fix45
    (This is a slightly harder version of the fix34 problem.) Return an array that contains
    exactly the same numbers as the given array, but rearranged so that every 4 is
    immediately followed by a 5. Do not move the 4's, but every other number may move. The
    array contains the same number of 4's and 5's, and every 4 has a number after it that is
    not a 4. In this version, 5's may appear anywhere in the original array.
     */
    public int[] fix45(int[] nums) {
        int[] array = nums.clone();
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 4) {
                if (i > 0 && array[i - 1] == 4) {
                    array[i] = 5;
                } else {
                    while (nums[index] == 4 || nums[index] == 5) {
                        index++;
                    }
                    array[i] = nums[index++];
                }
            }
        }
        return array;
    }

    /*
    canBalance
    Given a non-empty array, return true if there is a place to split the array so that the sum
    of the numbers on one side is equal to the sum of the numbers on the other side.
     */
    public boolean canBalance(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0 || nums.length < 2) {
            return false;
        }
        int left = 0;
        int i = 0;
        while (i < nums.length && left != sum / 2) {
            left += nums[i++];
        }
        return left == sum / 2;
    }

    /*
    linearIn
    Given two arrays of ints sorted in increasing order, outer and inner, return true if all of
    the numbers in inner appear in outer. The best solution makes only a single "linear" pass of
    both arrays, taking advantage of the fact that both arrays are already in sorted order.
     */
    public boolean linearIn(int[] outer, int[] inner) {
        int i = 0;
        for (int num : inner) {
            while (i != outer.length && outer[i] < num) {
                i++;
            }
            if (i == outer.length || outer[i] > num) {
                return false;
            }
        }
        return true;
    }

    /*
    squareUp
    Given n>=0, create an array length n*n with the following pattern, shown here for n=3 :
    {0, 0, 1,    0, 2, 1,    3, 2, 1} (spaces added to show the 3 groups).
     */
    public int[] squareUp(int n) {
        int[] array = new int[n * n];
        int index = 0;
        for (int i = n - 1; i > -1; i--) {
            index += i;
            for (int j = n - i; j > 0; j--) {
                array[index++] = j;
            }
        }
        return array;
    }

    /*
    seriesUp
    Given n>=0, create an array with the pattern {1,    1, 2,    1, 2, 3,   ... 1, 2, 3 .. n}
    (spaces added to show the grouping). Note that the length of the array will be 1 + 2 + 3
    ... + n, which is known to sum to exactly n*(n + 1)/2.
     */
    public int[] seriesUp(int n) {
        int[] array = new int[n * (n + 1) / 2];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < i + 2; j++) {
                array[index++] = j;
            }
        }
        return array;
    }

    /*
    maxMirror
    We'll say that a "mirror" section in an array is a group of contiguous elements such that
    somewhere in the array, the same group appears in reverse order. For example, the largest
    mirror section in {1, 2, 3, 8, 9, 3, 2, 1} is length 3 (the {1, 2, 3} part). Return the size of
    the largest mirror section found in the given array.
     */
    public int maxMirror(int[] nums) {
        int mirror = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums.length - i > mirror) {
                for (int j = nums.length - 1; j >= 0; j--) {
                    int k = j;
                    while (k >= 0 && i + j - k <= nums.length - 1 && nums[k] == nums[i + j - k]) {
                        k--;
                    }
                    mirror = Math.max(mirror, j - k);
                }
            }
        }
        return mirror;
    }

    /*
    countClumps
    Say that a "clump" in an array is a series of 2 or more adjacent elements of the same
    value. Return the number of clumps in the given array.
     */
    public int countClumps(int[] nums) {
        int len = 1;
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                len++;
            } else {
                len = 1;
            }
            if (len == 2) {
                count++;
            }
        }
        return count;
    }

}