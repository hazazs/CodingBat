import java.util.HashMap;
import java.util.Map;

public class CodingBat {

    /*
    word0
    Given an array of strings, return a Map<String, Integer> containing a key for every
    different string in the array, always with the value 0. For example the string "hello" makes
    the pair "hello":0. We'll do more complicated counting later, but for this problem the value
    is simply 0.
     */
    public Map<String, Integer> word0(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : strings) {
            map.put(str, 0);
        }
        return map;
    }

    /*
    wordLen
    Given an array of strings, return a Map<String, Integer> containing a key for every
    different string in the array, and the value is that string's length.
     */
    public Map<String, Integer> wordLen(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : strings) {
            map.put(str, str.length());
        }
        return map;
    }

    /*
    pairs
    Given an array of non-empty strings, create and return a Map<String, String> as follows:
    for each string add its first character as a key with its last character as the value.
     */
    public Map<String, String> pairs(String[] strings) {
        Map<String, String> map = new HashMap<>();
        for (String str : strings) {
            map.put(str.substring(0, 1), str.substring(str.length() - 1));
        }
        return map;
    }

    /*
    wordCount
    The classic word-count algorithm: given an array of strings, return a Map<String, Integer>
    with a key for each different string, with the value the number of times that string appears
    in the array.
     */
    public Map<String, Integer> wordCount(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : strings) {
            map.put(str, map.containsKey(str) ? map.get(str) + 1 : 1);
        }
        return map;
    }

    /*
    firstChar
    Given an array of non-empty strings, return a Map<String, String> with a key for every
    different first character seen, with the value of all the strings starting with that character
    appended together in the order they appear in the array.
     */
    public Map<String, String> firstChar(String[] strings) {
        Map<String, String> map = new HashMap<>();
        for (String str : strings) {
            String firstChar = str.substring(0, 1);
            map.put(firstChar, map.containsKey(firstChar) ? map.get(firstChar) + str : str);
        }
        return map;
    }

    /*
    wordAppend
    Loop over the given array of strings to build a result string like this: when a string appears
    the 2nd, 4th, 6th, etc. time in the array, append the string to the result. Return the empty
    string if no string appears a 2nd time.
     */
    public String wordAppend(String[] strings) {
        StringBuilder strb = new StringBuilder(0);
        Map<String, Integer> map = new HashMap<>();
        for (String str : strings) {
            map.put(str, map.containsKey(str) ? map.get(str) + 1 : 1);
            if (map.get(str) % 2 == 0) {
                strb.append(str);
            }
        }
        return strb.toString();
    }

    /*
    wordMultiple
    Given an array of strings, return a Map<String, Boolean> where each different string is a
    key and its value is true if that string appears 2 or more times in the array.
     */
    public Map<String, Boolean> wordMultiple(String[] strings) {
        Map<String, Boolean> map = new HashMap<>();
        for (String str : strings) {
            map.put(str, map.containsKey(str));
        }
        return map;
    }

    /*
    allSwap
    We'll say that 2 strings "match" if they are non-empty and their first chars are the same.
    Loop over and then return the given array of non-empty strings as follows: if a string
    matches an earlier string in the array, swap the 2 strings in the array. When a position in
    the array has been swapped, it no longer matches anything. Using a map, this can be
    solved making just one pass over the array. More difficult than it looks.
     */
    public String[] allSwap(String[] strings) {
        String[] ret = new String[strings.length];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            String firstChar = strings[i].substring(0, 1);
            if (!map.containsKey(firstChar)) {
                map.put(firstChar, i);
                ret[i] = strings[i];
            } else {
                ret[i] = strings[map.get(firstChar)];
                ret[map.get(firstChar)] = strings[i];
                map.remove(firstChar);
            }
        }
        return ret;
    }

    /*
    firstSwap
    We'll say that 2 strings "match" if they are non-empty and their first chars are the same.
    Loop over and then return the given array of non-empty strings as follows: if a string
    matches an earlier string in the array, swap the 2 strings in the array. A particular first
    char can only cause 1 swap, so once a char has caused a swap, its later swaps are
    disabled. Using a map, this can be solved making just one pass over the array. More
    difficult than it looks.
     */
    public String[] firstSwap(String[] strings) {
        String[] ret = new String[strings.length];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            String firstChar = strings[i].substring(0, 1);
            if (!map.containsKey(firstChar)) {
                map.put(firstChar, i);
                ret[i] = strings[i];
            } else if (map.get(firstChar) != -1) {
                ret[i] = strings[map.get(firstChar)];
                ret[map.get(firstChar)] = strings[i];
                map.put(firstChar, -1);
            } else {
                ret[i] = strings[i];
            }
        }
        return ret;
    }

}