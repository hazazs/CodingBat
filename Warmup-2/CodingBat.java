public class CodingBat {
    
    /*
    stringTimes
    Given a string and a non-negative int n, return a larger string that is n copies of the
    original string.
     */
    public String stringTimes(String str, int n) {
        String ret = "";
        for (int i = 0; i < n; i++)
            ret += str;
        return ret;
    }
    
    /*
    frontTimes
    Given a string and a non-negative int n, we'll say that the front of the string is the first 3
    chars, or whatever is there if the string is less than length 3. Return n copies of the front;
     */
    public String frontTimes(String str, int n) {
        String ret = "";
        for (int i = 0; i < n; i++)
            ret += str.length() > 3 ? str.substring(0, 3) : str;
        return ret;
    }
    
    /*
    countXX
    Count the number of "xx" in the given string. We'll say that overlapping is allowed, so
    "xxx" contains 2 "xx".
     */
    int countXX(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++)
            if (str.substring(i, i + 2).equals("xx"))
                count++;
        return count;
    }
    
}