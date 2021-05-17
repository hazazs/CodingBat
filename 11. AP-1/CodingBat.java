import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodingBat {

    /*
    scoresIncreasing
    Given an array of scores, return true if each score is equal or greater than the one before.
    The array will be length 2 or more.
     */
    public boolean scoresIncreasing(int[] scores) {
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < scores[i - 1]) {
                return false;
            }
        }
        return true;
    }

    /*
    scores100
    Given an array of scores, return true if there are scores of 100 next to each other in the
    array. The array length will be at least 2.
     */
    public boolean scores100(int[] scores) {
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] == 100 && scores[i - 1] == 100) {
                return true;
            }
        }
        return false;
    }

    /*
    scoresClump
    Given an array of scores sorted in increasing order, return true if the array contains 3
    adjacent scores that differ from each other by at most 2, such as with {3, 4, 5} or {3, 5,
    5}.
     */
    public boolean scoresClump(int[] scores) {
        for (int i = 1; i < scores.length - 1; i++) {
            if (scores[i + 1] - scores[i - 1] <= 2) {
                return true;
            }
        }
        return false;
    }

    /*
    scoresAverage
    Given an array of scores, compute the int average of the first half and the second half, and
    return whichever is larger. We'll say that the second half begins at index length/2. The
    array length will be at least 2. To practice decomposition, write a separate helper method
    int average(int[] scores, int start, int end) { which computes the average of the
    elements between indexes start..end. Call your helper method twice to implement
    scoresAverage(). Write your helper method after your scoresAverage() method in the
    JavaBat text area. Normally you would compute averages with doubles, but here we use
    ints so the expected results are exact.
     */
    public int scoresAverage(int[] scores) {
        return Math.max(average(scores, 0, scores.length / 2),
                average(scores, scores.length / 2, scores.length));
    }

    int average(int[] scores, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += scores[i];
        }
        return sum / (end - start);
    }

    /*
    wordsCount
    Given an array of strings, return the count of the number of strings with the given length.
     */
    public int wordsCount(String[] words, int len) {
        int count = 0;
        for (String str : words) {
            if (str.length() == len) {
                count++;
            }
        }
        return count;
    }

    /*
    wordsFront
    Given an array of strings, return a new array containing the first N strings. N will be in the
    range 1..length.
     */
    public String[] wordsFront(String[] words, int n) {
        return Arrays.copyOf(words, n);
    }

    /*
    wordsWithoutList
    Given an array of strings, return a new List (e.g. an ArrayList) where all the strings of the
    given length are omitted. See wordsWithout() below which is more difficult because it uses
    arrays.
     */
    public List wordsWithoutList(String[] words, int len) {
        List<String> array = new ArrayList<>();
        for (String str : words) {
            if (str.length() != len) {
                array.add(str);
            }
        }
        return array;
    }

    /*
    hasOne
    Given a positive int n, return true if it contains a 1 digit. Note: use % to get the rightmost
    digit, and / to discard the rightmost digit.
     */
    public boolean hasOne(int n) {
        while (n % 10 != 1 && n >= 10) {
            n /= 10;
        }
        return n % 10 == 1;
    }

    /*
    dividesSelf
    We'll say that a positive int divides itself if every digit in the number divides into the
    number evenly. So for example 128 divides itself since 1, 2, and 8 all divide into 128
    evenly. We'll say that 0 does not divide into anything evenly, so no number with a 0 digit
    divides itself. Note: use % to get the rightmost digit, and / to discard the rightmost digit.
     */
    public boolean dividesSelf(int n) {
        boolean ret = true;
        int i = n;
        while (i > 0 && ret) {
            if (i % 10 == 0 || n % (i % 10) != 0) {
                ret = false;
            }
            i /= 10;
        }
        return ret;
    }

    /*
    copyEvens
    Given an array of positive ints, return a new array of length "count" containing the first
    even numbers from the original array. The original array will contain at least "count" even
    numbers.
     */
    public int[] copyEvens(int[] nums, int count) {
        int[] array = new int[count];
        int i = 0;
        for (int j = 0; j < count; j++) {
            while (nums[i] % 2 != 0) {
                i++;
            }
            array[j] = nums[i++];
        }
        return array;
    }

    /*
    copyEndy
    We'll say that a positive int n is "endy" if it is in the range 0..10 or 90..100 (inclusive).
    Given an array of positive ints, return a new array of length "count" containing the first
    endy numbers from the original array. Decompose out a separate isEndy(int n) method to
    test if a number is endy. The original array will contain at least "count" endy numbers.
     */
    public int[] copyEndy(int[] nums, int count) {
        int[] array = new int[count];
        int i = 0;
        for (int j = 0; j < count; j++) {
            while (!isEndy(nums[i])) {
                i++;
            }
            array[j] = nums[i++];
        }
        return array;
    }

    boolean isEndy(int n) {
        return (n >= 0 && n <= 10) || (n >= 90 && n <= 100);
    }

    /*
    matchUp
    Given 2 arrays that are the same length containing strings, compare the 1st string in one
    array to the 1st string in the other array, the 2nd to the 2nd and so on. Count the number
    of times that the 2 strings are non-empty and start with the same char. The strings may be
    any length, including 0.
     */
    public int matchUp(String[] a, String[] b) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i].length() != 0 && b[i].length() != 0 && a[i].charAt(0) == (b[i].charAt(0))) {
                count++;
            }
        }
        return count;
    }

    /*
    scoreUp
    The "key" array is an array containing the correct answers to an exam, like {"a", "a", "b",
    "b"}. the "answers" array contains a student's answers, with "?" representing a question
    left blank. The two arrays are not empty and are the same length. Return the score for this
    array of answers, giving +4 for each correct answer, -1 for each incorrect answer, and +0
    for each blank answer.
     */
    public int scoreUp(String[] key, String[] answers) {
        int score = 0;
        for (int i = 0; i < key.length; i++) {
            if (key[i].equals(answers[i])) {
                score += 4;
            } else {
                score += answers[i].equals("?") ? 0 : -1;
            }
        }
        return score;
    }

    /*
    wordsWithout
    Given an array of strings, return a new array without the strings that are equal to the
    target string. One approach is to count the occurrences of the target string, make a new
    array of the correct length, and then copy over the correct strings.
     */
    public String[] wordsWithout(String[] words, String target) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals(target)) {
                count++;
            }
        }
        String[] array = new String[count];
        int j = 0;
        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals(target)) {
                array[j++] = words[i];
            }
        }
        return array;
    }

    /*
    scoresSpecial
    Given two arrays, A and B, of non-negative int scores. A "special" score is one which is a
    multiple of 10, such as 40 or 90. Return the sum of largest special score in A and the
    largest special score in B. To practice decomposition, write a separate helper method which
    finds the largest special score in an array. Write your helper method after your
    scoresSpecial() method in the JavaBat text area.
     */
    public int scoresSpecial(int[] a, int[] b) {
        return largestSpecial(a) + largestSpecial(b);
    }

    int largestSpecial(int[] scores) {
        int largest = 0;
        for (int score : scores) {
            if (score % 10 == 0 && score > largest) {
                largest = score;
            }
        }
        return largest;
    }

    /*
    sumHeights
    We have an array of heights, representing the altitude along a walking trail. Given
    start/end indexes into the array, return the sum of the changes for a walk beginning at the
    start index and ending at the end index. For example, with the heights {5, 3, 6, 7, 2} and
    start=2, end=4 yields a sum of 1 + 5 = 6. The start end end index will both be valid
    indexes into the array with start <= end.
     */
    public int sumHeights(int[] heights, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += Math.abs(heights[i + 1] - heights[i]);
        }
        return sum;
    }

    /*
    sumHeights2
    (A variation on the sumHeights problem.) We have an array of heights, representing the
    altitude along a walking trail. Given start/end indexes into the array, return the sum of the
    changes for a walk beginning at the start index and ending at the end index, however
    increases in height count double. For example, with the heights {5, 3, 6, 7, 2} and
    start=2, end=4 yields a sum of 1*2 + 5 = 7. The start end end index will both be valid
    indexes into the array with start <= end.
     */
    public int sumHeights2(int[] heights, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            int diff = heights[i + 1] - heights[i];
            sum = diff > 0 ? sum + diff * 2 : sum + Math.abs(diff);
        }
        return sum;
    }

    /*
    bigHeights
    (A variation on the sumHeights problem.) We have an array of heights, representing the
    altitude along a walking trail. Given start/end indexes into the array, return the number of
    "big" steps for a walk starting at the start index and ending at the end index. We'll say that
    step is big if it is 5 or more up or down. The start end end index will both be valid indexes
    into the array with start <= end.
     */
    public int bigHeights(int[] heights, int start, int end) {
        int count = 0;
        for (int i = start; i < end; i++) {
            if (Math.abs(heights[i + 1] - heights[i]) >= 5) {
                count++;
            }
        }
        return count;
    }

    /*
    userCompare
    We have data for two users, A and B, each with a String name and an int id. The goal is to
    order the users such as for sorting. Return -1 if A comes before B, 1 if A comes after B,
    and 0 if they are the same. Order first by the string names, and then by the id numbers if
    the names are the same. Note: with Strings str1.compareTo(str2) returns an int value
    which is negative/0/positive to indicate how str1 is ordered to str2 (the value is not limited
    to -1/0/1). (On the AP, there would be two User objects, but here the code simply takes
    the two strings and two ints directly. The code logic is the same.)
     */
    public int userCompare(String aName, int aId, String bName, int bId) {
        if (aName.compareTo(bName) == 0) {
            if (aId - bId == 0) {
                return 0;
            }
            return aId - bId < 0 ? -1 : 1;
        }
        return aName.compareTo(bName) < 0 ? -1 : 1;
    }

    /*
    mergeTwo
    Start with two arrays of strings, A and B, each with its elements in alphabetical order and
    without duplicates. Return a new array containing the first N elements from the two arrays.
    The result array should be in alphabetical order and without duplicates. A and B will both
    have a length which is N or more. The best "linear" solution makes a single pass over A
    and B, taking advantage of the fact that they are in alphabetical order, copying elements
    directly to the new array.
     */
    public String[] mergeTwo(String[] a, String[] b, int n) {
        String[] array = new String[n];
        int i = 0;
        int j = 0;
        int k = 0;
        array[k++] = a[i].compareTo(b[j]) <= 0 ? a[i++] : b[j++];
        while (k != n) {
            if (a[i].equals(b[j]) && j != b.length - 1) {
                j++;
            }
            if (a[i].compareTo(b[j]) < 0) {
                if (array[k - 1].compareTo(a[i]) < 0) {
                    array[k++] = a[i++];
                } else {
                    i++;
                }
            } else if (array[k - 1].compareTo(b[j]) < 0) {
                array[k++] = b[j++];
            } else {
                j++;
            }
        }
        return array;
    }

    /*
    commonTwo
    Start with two arrays of strings, a and b, each in alphabetical order, possibly with
    duplicates. Return the count of the number of strings which appear in both arrays. The
    best "linear" solution makes a single pass over both arrays, taking advantage of the fact
    that they are in alphabetical order.
     */
    public int commonTwo(String[] a, String[] b) {
        int count = 0;
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if (i == 0 || (i > 0 && a[i] != a[i - 1])) {
                int j = index;
                while (j != b.length && a[i] != b[j]) {
                    j++;
                }
                if (j != b.length && a[i] == b[j]) {
                    count++;
                    while (j != b.length - 1 && b[j] == b[j + 1]) {
                        j++;
                    }
                    index = j++;
                }
            }
        }
        return count;
    }

}