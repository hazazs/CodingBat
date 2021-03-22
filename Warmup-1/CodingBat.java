public class CodingBat {
    
    /*
    sleepIn
    The parameter weekday is true if it is a weekday, and the parameter vacation is true if we
    are on vacation. We sleep in if it is not a weekday or we're on vacation. Return true if we
    sleep in.
    */
    public boolean sleepIn(boolean weekday, boolean vacation) {
        return !weekday || vacation;
    }
    
    /*
    monkeyTrouble
    We have two monkeys, a and b, and the parameters aSmile and bSmile indicate if each is
    smiling. We are in trouble if they are both smiling or if neither of them is smiling. Return
    true if we are in trouble.
    */
    public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        return (aSmile && bSmile) || (!aSmile && !bSmile);
    }
    
    /*
    sumDouble
    Given two int values, return their sum. Unless the two values are the same, then return
    double their sum.
    */
    public int sumDouble(int a, int b) {
        return a == b ? 2 * (a + b) : a + b;
    }
    
}