package level_2;

import java.util.Arrays;

/**
 * Created by kacper kuźniarski on 01.06.2017.
 */
public class Logic_2 {
    /*
 * We want to make a row of bricks that is goal inches long. We have a
 * number of small bricks (1 inch each) and big bricks (5 inches each).
 * Return true if it is possible to make the goal by choosing from the given
 * bricks. This is a little harder than it looks and can be done without any
 * loops. See also: Introduction to MakeBricks
 */
    public boolean makeBricks(int small, int big, int goal) {
        boolean result = false;
        big *= 5;

        if ((small >= goal) || (big == goal) || ((big >= goal) && (goal % 5 <= small)))
            result = true;
        if ((big < goal) && (goal - big <= small))
            result = true;
        return result;
    }

    /*
 * Given 3 int values, a b c, return their sum. However, if one of the
 * values is the same as another of the values, it does not count towards
 * the sum.
 */
    public int loneSum(int a, int b, int c) {
        int sum = 0;
        if (a == b)
            sum = (a == c) ? 0 : c;
        else if (a == c)
            sum = (b == c) ? 0 : b;
        else if (b == c)
            sum = (a == b) ? 0 : a;
        else
            sum = a + b + c;
        return sum;
    }

    /*
 * Given 3 int values, a b c, return their sum. However, if one of the
 * values is 13 then it does not count towards the sum and values to its
 * right do not count. So for example, if b is 13, then both b and c do not
 * count.
 */
    public int luckySum(int a, int b, int c) {
        int sum = 0;
        if (a != 13) {
            sum += a;
            if (b != 13) {
                sum += b;
                if (c != 13)
                    sum += c;
            }
        }
        return sum;
    }

    /*
     * Given 3 int values, a b c, return their sum. However, if any of the
     * values is a teen -- in the range 13..19 inclusive -- then that value
     * counts as 0, except 15 and 16 do not count as a teens. Write a separate
     * helper "public int fixTeen(int n) {"that takes in an int value and
     * returns that value fixed for the teen rule. In this way, you avoid
     * repeating the teen code 3 times (i.e. "decomposition"). Define the helper
     * below and at the same indent level as the main noTeenSum().
     */
    public int noTeenSum(int a, int b, int c) {
        return fixTeen(a) + fixTeen(b) + fixTeen(c);
    }

    public int fixTeen(int n) {
        n = (n >= 13 && n <= 14) || (n > 16 && n <= 19) ? 0 : n;
        return n;
    }

    /*
     * For this problem, we'll round an int value up to the next multiple of 10
     * if its rightmost digit is 5 or more, so 15 rounds up to 20. Alternately,
     * round down to the previous multiple of 10 if its rightmost digit is less
     * than 5, so 12 rounds down to 10. Given 3 ints, a b c, return the sum of
     * their rounded values. To avoid code repetition, write a separate helper
     * "public int round10(int num) {" and call it 3 times. Write the helper
     * entirely below and at the same indent level as roundSum().
     */
    public int roundSum(int a, int b, int c) {
        return round10(a) + round10(b) + round10(c);
    }

    public int round10(int num) {
        double a = Math.round((double) num / 10) * 10;
        return (int) a;
    }

    /*
     *
     * Given three ints, a b c, return true if one of b or c is "close"
     * (differing from a by at most 1), while the other is "far", differing
     * from both other values by 2 or more. Note: Math.abs(num) computes the
     * absolute value of a number.
     */
    public boolean closeFar(int a, int b, int c) {
        if (Math.abs(a - b) <= 1) {
            return (Math.abs(a - c) >= 2 && Math.abs(c - b) >= 2);
        } else if (Math.abs(a - c) <= 1) {
            return (Math.abs(a - b) >= 2 && Math.abs(c - b) >= 2);
        } else if (Math.abs(b - c) <= 1) {
            return (Math.abs(a - b) >= 2 && Math.abs(c - a) >= 2);
        }
        return false;
    }

    /*
     * Given 2 int values greater than 0, return whichever value
     * is nearest to 21 without going over. Return 0 if they both go over.
     */
    public int blackjack(int a, int b) {
        int result = 0;
        if (a > 21 && b > 21)
            result = 0;
        else if (a <= 21 && b <= 21) {
            result = (Math.abs(21 - a) < Math.abs(21 - b)) ? a : b;
        } else {
            result = (a < b) ? a : b;
        }
        return result;
    }

    /*
    * Given three ints, a b c, one of them is small, one is medium and one is large.
     * Return true if the three values are evenly spaced, so the difference between
     * small and medium is the same as the difference between medium and large.
     */
    public boolean evenlySpaced(int a, int b, int c) {
        int[] tab = {a, b, c};
        Arrays.sort(tab);
        return ((tab[1] - tab[0]) == (tab[2] - tab[1]));
    }

    /*
     * We want make a package of goal kilos of chocolate. We have small bars (1 kilo each)
     * and big bars (5 kilos each). Return the number of small bars to use,
     * assuming we always use big bars before small bars. Return -1 if it can't be done.
     */
    public int makeChocolate(int small, int big, int goal) {
        big *= 5;
        while(big > goal)
            big -= 5;
        int result = ((goal - big) <= small)? goal - big : -1;
        return result;
    }


}
