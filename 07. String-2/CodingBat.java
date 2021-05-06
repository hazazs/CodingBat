public class CodingBat {

    /*
    doubleChar
    Given a string, return a string where for every char in the original, there are two chars.
     */
    public String doubleChar(String str) {
        StringBuilder ret = new StringBuilder(2 * str.length());
        for (int i = 0; i < str.length(); i++) {
            ret.append(str.substring(i, i + 1)).append(str.substring(i, i + 1));
        }
        return ret.toString();
    }

    /*
    countHi
    Return the number of times that the string "hi" appears anywhere in the given string.
     */
    public int countHi(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            count = str.substring(i, i + 2).equals("hi") ? count + 1 : count;
        }
        return count;
    }

    /*
    catDog
    Return true if the string "cat" and "dog" appear the same number of times in the given
    string.
     */
    public boolean catDog(String str) {
        int catNo = 0;
        int dogNo = 0;
        for (int i = 0; i < str.length() - 2; i++) {
            catNo = str.substring(i, i + 3).equals("cat") ? catNo + 1 : catNo;
            dogNo = str.substring(i, i + 3).equals("dog") ? dogNo + 1 : dogNo;
        }
        return catNo == dogNo;
    }

    /*
    countCode
    Return the number of times that the string "code" appears anywhere in the given string,
    except we'll accept any letter for the 'd', so "cope" and "cooe" count.
     */
    public int countCode(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 3; i++) {
            if (str.substring(i, i + 2).equals("co") && str.charAt(i + 3) == 'e') {
                count++;
            }
        }
        return count;
    }

    /*
    endOther
    Given two strings, return true if either of the strings appears at the very end of the other
    string, ignoring upper/lower case differences (in other words, the computation should not
    be "case sensitive"). Note: str.toLowerCase() returns the lowercase version of a string.
     */
    public boolean endOther(String a, String b) {
        String aLow = a.toLowerCase();
        String bLow = b.toLowerCase();
        if (a.length() > b.length() || a.length() < b.length()) {
            if (a.length() > b.length()) {
                return a.substring(a.length() - b.length()).toLowerCase().equals(bLow);
            }
            return b.substring(b.length() - a.length()).toLowerCase().equals(aLow);
        }
        return a.toLowerCase().equals(b.toLowerCase());
    }

    /*
    xyzThere
    Return true if the given string contains an appearance of "xyz" where the xyz is not
    directly preceeded by a period (.). So "xxyz" counts but "x.xyz" does not.
     */
    public boolean xyzThere(String str) {
        if (!str.startsWith("xyz") && str.length() > 3) {
            for (int i = 1; i < str.length() - 2; i++) {
                if (str.substring(i, i + 3).equals("xyz") && str.charAt(i - 1) != '.') {
                    return true;
                }
            }
        }
        return str.startsWith("xyz");
    }

    /*
    bobThere
    Return true if the given string contains a "bob" string, but where the middle 'o' char can be
    any char.
     */
    public boolean bobThere(String str) {
        if (str.length() >= 3) {
            for (int i = 0; i < str.length() - 2; i++) {
                if (str.charAt(i) == 'b' && str.charAt(i + 2) == 'b') {
                    return true;
                }
            }
        }
        return false;
    }

    /*
    xyBalance
    We'll say that a String is xy-balanced if for all the 'x' chars in the string, there exists a 'y'
    char somewhere later in the string. So "xxy" is balanced, but "xyx" is not. One 'y' can
    balance multiple 'x's. Return true if the given string is xy-balanced.
     */
    public boolean xyBalance(String str) {
        for (int i = str.lastIndexOf('y') + 1; i < str.length(); i++) {
            if (str.charAt(i) == 'x') {
                return false;
            }
        }
        return true;
    }

    /*
    mixString
    Given two strings, a and b, create a bigger string made of the first char of a, the first char
    of b, the second char of a, the second char of b, and so on. Any leftover chars go at the
    end of the result.
     */
    public String mixString(String a, String b) {
        StringBuilder ret = new StringBuilder(a.length() + b.length());
        for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
            ret.append(a.charAt(i)).append(b.charAt(i));
        }
        if (a.length() == b.length()) {
            return ret.toString();
        }
        if (a.length() > b.length()) {
            return ret.append(a.substring(b.length())).toString();
        }
        return ret.append(b.substring(a.length())).toString();
    }

    /*
    repeatEnd
    Given a string and an int n, return a string made of n repetitions of the last n characters of
    the string. You may assume that n is between 0 and the length of the string, inclusive.
     */
    public String repeatEnd(String str, int n) {
        StringBuilder ret = new StringBuilder(n * n);
        for (int i = 0; i < n; i++) {
            ret.append(str.substring(str.length() - n));
        }
        return ret.toString();
    }

    /*
    repeatFront
    Given a string and an int n, return a string made of the first n characters of the string,
    followed by the first n-1 characters of the string, and so on. You may assume that n is
    between 0 and the length of the string, inclusive (i.e. n >= 0 and n <= str.length()).
     */
    public String repeatFront(String str, int n) {
        StringBuilder ret = new StringBuilder(n * (n + 1) / 2);
        for (int i = n; i > 0; i--) {
            ret.append(str.substring(0, i));
        }
        return ret.toString();
    }

    /*
    repeatSeparator
    Given two strings, word and a separator sep, return a big string made of count
    occurrences of the word, separated by the separator string.
     */
    public String repeatSeparator(String word, String sep, int count) {
        int len = count * word.length() + (count - 1) * sep.length();
        StringBuilder ret = new StringBuilder(len);
        for (int i = 0; i < count; i++) {
            ret.append(i == count - 1 ? word : word + sep);
        }
        return ret.toString();
    }

    /*
    prefixAgain
    Given a string, consider the prefix string made of the first N chars of the string. Does that
    prefix string appear somewhere else in the string? Assume that the string is not empty and
    that N is in the range 1..str.length().
     */
    public boolean prefixAgain(String str, int n) {
        return str.substring(1).contains(str.substring(0, n));
    }

    /*
    xyzMiddle
    Given a string, does "xyz" appear in the middle of the string? To define middle, we'll say
    that the number of chars to the left and right of the "xyz" must differ by at most one. This
    problem is harder than it looks.
     */
    public boolean xyzMiddle(String str) {
        int len = str.length();
        if (str.length() >= 3) {
            boolean middleMatch = str.substring(len / 2 - 1, len / 2 + 2).equals("xyz");
            boolean evenLength = str.length() % 2 == 0;
            boolean leftMatch = false;
            if (evenLength) {
                leftMatch = str.substring(len / 2 - 2, len / 2 + 1).equals("xyz");
            }
            return middleMatch || evenLength && leftMatch;
        }
        return false;
    }

    /*
    getSandwich
    A sandwich is two pieces of bread with something in between. Return the string that is
    between the first and last appearance of "bread" in the given string, or return the empty
    string "" if there are not two pieces of bread.
     */
    public String getSandwich(String str) {
        if (str.indexOf("bread") != str.lastIndexOf("bread")) {
            return str.substring(str.indexOf("bread") + 5, str.lastIndexOf("bread"));
        }
        return "";
    }

    /*
    sameStarChar
    Returns true if for every '*' (star) in the string, if there are chars both immediately before
    and after the star, they are the same.
     */
    public boolean sameStarChar(String str) {
        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i) == '*' && str.charAt(i - 1) != str.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    /*
    oneTwo
    Given a string, compute a new string by moving the first char to come after the next two
    chars, so "abc" yields "bca". Repeat this process for each subsequent group of 3 chars, so
    "abcdef" yields "bcaefd". Ignore any group of fewer than 3 chars at the end.
     */
    public String oneTwo(String str) {
        StringBuilder ret = new StringBuilder(str.length() / 3 * 3);
        for (int i = 0; i < str.length() - (str.length() % 3); i += 3) {
            ret.append(str.substring(i + 1, i + 3)).append(str.charAt(i));
        }
        return ret.toString();
    }

    /*
    zipZap
    Look for patterns like "zip" and "zap" in the string -- length-3, starting with 'z' and ending
    with 'p'. Return a string where for all such words, the middle letter is gone, so "zipXzap"
    yields "zpXzp".
     */
    public String zipZap(String str) {
        StringBuilder ret = new StringBuilder(str.length());
        if (str.length() > 0) {
            ret.append(str.charAt(0));
        }
        for (int i = 1; i < str.length() - 1; i++) {
            if (!(str.charAt(i - 1) == 'z' && str.charAt(i + 1) == 'p')) {
                ret.append(str.charAt(i));
            }
        }
        if (str.length() > 1) {
            return ret.append(str.substring(str.length() - 1)).toString();
        }
        return ret.toString();
    }

    /*
    starOut
    Return a version of the given string, where for every star (*) in the string the star and the
    chars immediately to its left and right are gone. So "ab*cd" yields "ad" and "ab**cd" also
    yields "ad".
     */
    public String starOut(String str) {
        StringBuilder ret = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            boolean isPreviousAsterisk = i != 0 && str.charAt(i - 1) == '*';
            boolean isAsterisk = str.charAt(i) == '*';
            boolean isNextAsterisk = i != str.length() - 1 && str.charAt(i + 1) == '*';
            if (!isPreviousAsterisk && !isAsterisk && !isNextAsterisk) {
                ret.append(str.charAt(i));
            }
        }
        return ret.toString();
    }

    /*
    plusOut
    Given a string and a non-empty word string, return a version of the original String where
    all chars have been replaced by pluses ("+"), except for appearances of the word string
    which are preserved unchanged.
     */
    public String plusOut(String str, String word) {
        StringBuilder ret = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            boolean isWordFit = i < str.length() - word.length() + 1;
            if (isWordFit && str.substring(i, i + word.length()).equals(word)) {
                ret.append(word);
                i += word.length() - 1;
            } else {
                ret.append('+');
            }
        }
        return ret.toString();
    }

    /*
    wordEnds
    Given a string and a non-empty word string, return a string made of each char just before
    and just after every appearance of the word in the string. Ignore cases where there is no
    char before or after the word, and a char may be included twice if it is between two words.
     */
    public String wordEnds(String str, String word) {
        StringBuilder ret = new StringBuilder(str.length());
        for (int i = 0; i < str.length() - word.length() + 1; i++) {
            if (str.substring(i, i + word.length()).equals(word)) {
                if (i > 0) {
                    ret.append(str.charAt(i - 1));
                }
                if (i < str.length() - word.length()) {
                    ret.append(str.charAt(i + word.length()));
                }
                i += word.length() - 1;
            }
        }
        return ret.toString();
    }

}