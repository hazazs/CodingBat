public class CodingBat {

    /*
    makeBricks
    We want to make a row of bricks that is goal inches long. We have a number of small
    bricks (1 inch each) and big bricks (5 inches each). Return true if it is possible to make the
    goal by choosing from the given bricks. This is a little harder than it looks and can be done
    without any loops. See also: Introduction to MakeBricks
     */
    public boolean makeBricks(int small, int big, int goal) {
        return 5 * big >= goal ? small >= goal % 5 : small + 5 * big >= goal;
    }
    
    /*
    loneSum
    Given 3 int values, a b c, return their sum. However, if one of the values is the same as
    another of the values, it does not count towards the sum.
     */
    public int loneSum(int a, int b, int c) {
        if (a == b || a == c)
            return b == c ? 0 : (a == b ? c : b);
        else return b == c ? a : a + b + c;
    }
    
    /*
    luckySum
    Given 3 int values, a b c, return their sum. However, if one of the values is 13 then it does
    not count towards the sum and values to its right do not count. So for example, if b is 13,
    then both b and c do not count.
     */
    public int luckySum(int a, int b, int c) {
        if (a != 13)
            return b == 13 ? a : (c == 13 ? a + b : a + b + c);
        else return 0;
    }
    
    /*
    noTeenSum
    Given 3 int values, a b c, return their sum. However, if any of the values is a teen -- in the
    range 13..19 inclusive -- then that value counts as 0, except 15 and 16 do not count as a
    teens. Write a separate helper "public int fixTeen(int n) {"that takes in an int value and
    returns that value fixed for the teen rule. In this way, you avoid repeating the teen code 3
    times (i.e. "decomposition"). Define the helper below and at the same indent level as the
    main noTeenSum().
     */
    public int noTeenSum(int a, int b, int c) {
        return fixTeen(a) + fixTeen(b) + fixTeen(c);
    }
    public int fixTeen(int n) {
        return n >= 13 && n <= 19 && n != 15 && n != 16 ? 0 : n;
    }
    
    /*
    roundSum
    For this problem, we'll round an int value up to the next multiple of 10 if its rightmost digit
    is 5 or more, so 15 rounds up to 20. Alternately, round down to the previous multiple of 10
    if its rightmost digit is less than 5, so 12 rounds down to 10. Given 3 ints, a b c, return the
    sum of their rounded values. To avoid code repetition, write a separate helper "public int
    round10(int num) {" and call it 3 times. Write the helper entirely below and at the same
    indent level as roundSum().
     */
    public int roundSum(int a, int b, int c) {
        return round10(a) + round10(b) + round10(c);
    }
    public int round10(int num) {
        return num % 10 < 5 ? num - (num % 10) : num - (num % 10) + 10;
    }
    
    /*
    closeFar
    Given three ints, a b c, return true if one of b or c is "close" (differing from a by at most
    1), while the other is "far", differing from both other values by 2 or more. Note:
    Math.abs(num) computes the absolute value of a number.
     */
    public boolean closeFar(int a, int b, int c) {
        boolean tForB = Math.abs(b - a) <= 1 && Math.abs(c - a) >= 2 && Math.abs(c - b) >= 2;
        boolean tForC = Math.abs(c - a) <= 1 && Math.abs(b - a) >= 2 && Math.abs(c - b) >= 2;
        return tForB || tForC;
    }
    
    /*
    blackjack
    Given 2 int values greater than 0, return whichever value is nearest to 21 without going
    over. Return 0 if they both go over.
     */
    public int blackjack(int a, int b) {
        if ((a > 21 && b <= 21) || (b > 21 && a <= 21))
            return Math.min(a, b);
        else return a > 21 ? 0 : Math.max(a, b);
    }
    
    /*
    evenlySpaced
    Given three ints, a b c, one of them is small, one is medium and one is large. Return true if
    the three values are evenly spaced, so the difference between small and medium is the
    same as the difference between medium and large.
     */
    public boolean evenlySpaced(int a, int b, int c) {
        return b - c == a - b || a - c == b - a || c - b == a - c;
    }
    
    /*
    makeChocolate
    We want make a package of goal kilos of chocolate. We have small bars (1 kilo each) and
    big bars (5 kilos each). Return the number of small bars to use, assuming we always use
    big bars before small bars. Return -1 if it can't be done.
     */
    public int makeChocolate(int small, int big, int goal) {
        if (5 * big >= goal)
            return small >= goal % 5 ? goal % 5 : -1;
        else return small + 5 * big >= goal ? goal - 5 * big : -1;
    }

}