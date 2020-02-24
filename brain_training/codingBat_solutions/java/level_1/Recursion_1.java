package level_1;

/**
 * Created by kacper kuźniarski on 01.06.2017.
 */
public class Recursion_1 {
    /*
 *
 * Given n of 1 or more, return the factorial of n, which is n * (n-1) *
 * (n-2) ... 1. Compute the result recursively (without loops).
 */
    public static int factorial(int n) {
        if (n == 1)
            return 1;
        return factorial(n - 1) * n;
    }

    /*
     * We have a number of bunnies and each bunny has two big floppy ears. We
	 * want to compute the total number of ears across all the bunnies
	 * recursively (without loops or multiplication).
	 */
    public static int bunnyEars(int bunnies) {
        return bunnies * 2;
    }

    /*
     * The fibonacci sequence is a famous bit of mathematics, and it happens to
	 * have a recursive definition. The first two values in the sequence are 0
	 * and 1 (essentially 2 base cases). Each subsequent value is the sum of the
	 * previous two values, so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13,
	 * 21 and so on. Define a recursive fibonacci(n) method that returns the nth
	 * fibonacci number, with n=0 representing the start of the sequence.
	 */
    public static int fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /*
     * We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies
	 * (1, 3, ..) have the normal 2 ears. The even bunnies (2, 4, ..) we'll say
	 * have 3 ears, because they each have a raised foot. Recursively return the
	 * number of "ears" in the bunny line 1, 2, ... n (without loops or
	 * multiplication).
	 */
    public static int bunnyEars2(int bunnyEarsAmount) {
        if (bunnyEarsAmount == 0)
            return 0;
        if (bunnyEarsAmount % 2 == 0)
            return bunnyEars2(bunnyEarsAmount - 1) + 3;
        else
            return bunnyEars2(bunnyEarsAmount - 1) + 2;
    }

    /*
	 * We have triangle made of blocks. The topmost row has 1 block, the next
	 * row down has 2 blocks, the next row has 3 blocks, and so on. Compute
	 * recursively (no loops or multiplication) the total number of blocks in
	 * such a triangle with the given number of rows.
	 */
    public static int triangle(int number) {
        if (number == 0)
            return 0;
        return triangle(number - 1) + number;
    }

    /*
	 * Given a non-negative int n, return the sum of its digits recursively (no
	 * loops). Note that mod (%) by 10 yields the rightmost digit (126 % 10 is
	 * 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
	 */
    public static int sumDigits(int n) {
        if (n == 0)
            return 0;
        return sumDigits(n / 10) + n % 10;
    }

    /*
	 * Given a non-negative int n, return the count of the occurrences of 7 as a
	 * digit, so for example 717 yields 2. (no loops). Note that mod (%) by 10
	 * yields the rightmost digit (126 % 10 is 6), while divide (/) by 10
	 * removes the rightmost digit (126 / 10 is 12).
	 */
    public static int count7(int n) {
        if (n == 0)
            return 0;
        if (n % 10 == 7)
            return count7(n / 10) + 1;
        else
            return count7(n / 10);
    }

    /*
	 * Given base and n that are both 1 or more, compute recursively (no loops)
	 * the value of base to the n power, so powerN(3, 2) is 9 (3 squared).
	 */
    public static int powerN(int base, int n) {
        if (n == 1)
            return base;
        return powerN(base, n - 1) * base;
    }

    /*
     * Given a string, compute recursively (no loops) the number of lowercase
     * 'x' chars in the string.
     */
    public int countX(String str) {
        if (str.length() == 0)
            return 0;
        if (str.substring(str.length() - 1).equals("x"))
            return countX(str.substring(0, str.length() - 1)) + 1;
        else
            return countX(str.substring(0, str.length() - 1));
    }

    /*
     * Given a string, compute recursively (no loops) the number of times
     * lowercase "hi" appears in the string.
     */
    public int countHi(String str) {
        if (str.length() < 2)
            return 0;
        if (str.endsWith("hi"))
            return countHi(str.substring(0, str.length() - 1)) + 1;
        else
            return countHi(str.substring(0, str.length() - 1));
    }

    /*
     * Given a string, compute recursively (no loops) a new string where all the
     * lowercase 'x' chars have been changed to 'y' chars.
     */
    public String changeXY(String str) {
        return str.replaceAll("x", "y");
    }

    /*
	 * Given a string, compute recursively (no loops) a new string where all
	 * appearances of "pi" have been replaced by "3.14".
	 */
    public String changePi(String str) {
        return str.replaceAll("pi", "3.14");
    }

    /*
	 * Given a string, compute recursively a new string where all the 'x' chars
	 * have been removed.
	 */
    public String noX(String str) {
        return str.replaceAll("x", "");
    }

    /*
	 * Given an array of ints, compute recursively if the array contains a 6.
	 * We'll use the convention of considering only the part of the array that
	 * begins at the given index. In this way, a recursive call can pass index+1
	 * to move down the array. The initial call will pass in index as 0.
	 */
    public boolean array6(int[] nums, int index) {
        if (index == nums.length)
            return false;
        if (nums[index] == 6)
            return true;
        return array6(nums, index + 1);
    }

    /*
	 * Given an array of ints, compute recursively the number of times that the
	 * value 11 appears in the array. We'll use the convention of considering
	 * only the part of the array that begins at the given index. In this way, a
	 * recursive call can pass index+1 to move down the array. The initial call
	 * will pass in index as 0.
	 *
	 */
    public int array11(int[] nums, int index) {
        if (index == nums.length)
            return 0;
        if (nums[index] == 11)
            return array11(nums, index + 1) + 1;
        else
            return array11(nums, index + 1);
    }

    /*
	 * Given an array of ints, compute recursively if the array contains
	 * somewhere a value followed in the array by that value times 10. We'll use
	 * the convention of considering only the part of the array that begins at
	 * the given index. In this way, a recursive call can pass index+1 to move
	 * down the array. The initial call will pass in index as 0.
	 *
	 */
    public boolean array220(int[] nums, int index) {
        if (index == nums.length - 1 || nums.length < 2)
            return false;
        if (nums[index] * 10 == nums[index + 1])
            return true;
        return array220(nums, index + 1);
    }
}
