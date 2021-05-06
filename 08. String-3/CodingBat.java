public class CodingBat {

    /*
    countYZ
    Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and
    the 'z' in "fez" count, but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z
    is at the end of a word if there is not an alphabetic letter immediately following it. (Note:
    Character.isLetter(char) tests if a char is an alphabetic letter.)
     */
    public int countYZ(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            boolean isEqualZ = str.substring(i, i + 1).equalsIgnoreCase("z");
            boolean isEqualY = str.substring(i, i + 1).equalsIgnoreCase("y");
            boolean isNextAlphabetic = false;
            if (i < str.length() - 1) {
                isNextAlphabetic = !Character.isLetter(str.charAt(i + 1));
            }
            if ((isEqualZ || isEqualY) && (i == str.length() - 1 || isNextAlphabetic)) {
                count++;
            }
        }
        return count;
    }

    /*
    withoutString
    Given two strings, base and remove, return a version of the base string where all
    instances of the remove string have been removed (not case sensitive). You may assume
    that the remove string is length 1 or more. Remove only non-overlapping instances, so
    with "xxx" removing "xx" leaves "x".
     */
    public String withoutString(String base, String remove) {
        StringBuilder ret = new StringBuilder(base.length());
        for (int i = 0; i < base.length(); i++) {
            boolean subEqualsRemove = false;
            if (i < base.length() - remove.length() + 1) {
                if (base.substring(i, i + remove.length()).equalsIgnoreCase(remove)) {
                    subEqualsRemove = true;
                }
            }
            if (subEqualsRemove) {
                i += remove.length() - 1;
            } else {
                ret.append(base.substring(i, i + 1));
            }
        }
        return ret.toString();
    }

    /*
    equalIsNot
    Given a string, return true if the number of appearances of "is" anywhere in the string is
    equal to the number of appearances of "not" anywhere in the string (case sensitive).
     */
    public boolean equalIsNot(String str) {
        int isNo = 0;
        int notNo = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.substring(i, i + 2).equals("is")) {
                isNo++;
            }
            if (i < str.length() - 2 && str.substring(i, i + 3).equals("not")) {
                notNo++;
            }
        }
        return isNo == notNo;
    }

    /*
    gHappy
    We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its
    left or right. Return true if all the g's in the given string are happy.
     */
    public boolean gHappy(String str) {
        for (int i = 0; i < str.length(); i++) {
            boolean isPreviousG = i > 0 && str.charAt(i - 1) == 'g';
            boolean isNextG = i < str.length() - 1 && str.charAt(i + 1) == 'g';
            if (str.charAt(i) == 'g' && !(isPreviousG || isNextG)) {
                return false;
            }
        }
        return true;
    }

    /*
    countTriple
    We'll say that a "triple" in a string is a char appearing three times in a row. Return the
    number of triples in the given string. The triples may overlap.
     */
    public int countTriple(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i) == str.charAt(i + 1) && str.charAt(i) == str.charAt(i + 2)) {
                count++;
            }
        }
        return count;
    }

    /*
    sumDigits
    Given a string, return the sum of the digits 0-9 that appear in the string, ignoring all other
    characters. Return 0 if there are no digits in the string. (Note: Character.isDigit(char) tests
    if a char is one of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an
    int.)
     */
    public int sumDigits(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                sum += Integer.parseInt(str.substring(i, i + 1));
            }
        }
        return sum;
    }

    /*
    sameEnds
    Given a string, return the longest substring that appears at both the beginning and end of
    the string without overlapping. For example, sameEnds("abXab") is "ab".
     */
    public String sameEnds(String string) {
        StringBuilder ret = new StringBuilder(string.length() / 2);
        for (int i = 1; i < string.length() / 2 + 1; i++) {
            if (string.substring(0, i).equals(string.substring(string.length() - i))) {
                ret = new StringBuilder(string.substring(0, i));
            }
        }
        return ret.toString();
    }

    /*
    mirrorEnds
    Given a string, look for a mirror image (backwards) string at both the beginning and end of
    the given string. In other words, zero or more characters at the very begining of the given
    string, and at the very end of the string in reverse order (possibly overlapping). For
    example, the string "abXYZba" has the mirror end "ab".
     */
    public String mirrorEnds(String string) {
        int i = 1;
        while (i < string.length() + 1 && isBeginningEqualsMirrorEnd(string, i)) {
            i++;
        }
        return string.substring(0, i - 1);
    }

    public boolean isBeginningEqualsMirrorEnd(String str, int i) {
        String beginning = str.substring(0, i);
        String end = str.substring(str.length() - i);
        return beginning.equals(new StringBuilder(end).reverse().toString());
    }

    /*
    maxBlock
    Given a string, return the length of the largest "block" in the string. A block is a run of
    adjacent chars that are the same.
     */
    public int maxBlock(String str) {
        int actBlock = 0;
        int maxBlock = 0;
        for (int i = 0; i < str.length(); i++) {
            actBlock = i == 0 || str.charAt(i) == str.charAt(i - 1) ? actBlock + 1 : 1;
            maxBlock = actBlock > maxBlock ? actBlock : maxBlock;
        }
        return maxBlock;
    }

    /*
    sumNumbers
    Given a string, return the sum of the numbers appearing in the string, ignoring all other
    characters. A number is a series of 1 or more digit chars in a row. (Note:
    Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'.
    Integer.parseInt(string) converts a string to an int.)
     */
    public int sumNumbers(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                int j = i + 1;
                while (j < str.length() && Character.isDigit(str.charAt(j))) {
                    j++;
                }
                sum += Integer.parseInt(str.substring(i, j));
                i = j;
            }
        }
        return sum;
    }

    /*
    notReplace
    Given a string, return a string where every appearance of the lowercase word "is" has been
    replaced with "is not". The word "is" should not be immediately preceeded or followed by a
    letter -- so for example the "is" in "this" does not count. (Note: Character.isLetter(char)
    tests if a char is a letter.)
     */
    public String notReplace(String str) {
        StringBuilder ret = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            if (i + 2 <= str.length() && str.substring(i, i + 2).equals("is")) {
                ret.append(isPreceededValid(str, i) && isFollowedValid(str, i) ? "is not" : "is");
                i += 1;
            } else {
                ret.append(str.charAt(i));
            }
        }
        return ret.toString();
    }

    public boolean isPreceededValid(String str, int i) {
        return i - 1 < 0 || !Character.isLetter(str.charAt(i - 1));
    }

    public boolean isFollowedValid(String str, int i) {
        return i + 2 == str.length() || !Character.isLetter(str.charAt(i + 2));
    }

}