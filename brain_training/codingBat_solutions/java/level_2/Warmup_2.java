package level_2;

/**
 * Created by Kacper Kuźniarski on 09.06.2017.
 */
public class Warmup_2 {

    /*
     * Given a string and a non-negative int n,
     * return a larger string that is n copies of the original string.
     */
    public String stringTimes(String str, int n) {
        String a = "";
        for (int i = 0; i < n; i++)
            a += str;
        return a;
    }

    /*
     * Given a string and a non-negative int n,
     * we'll say that the front of the string is the first 3 chars,
     * or whatever is there if the string is less than length 3.\
     * Return n copies of the front;
     */
    public String frontTimes(String str, int n) {
        char[] tab = str.toCharArray();
        String a = "";
        for (int i = 0; i < n; i++) {
            switch (str.length()) {
                case 0:
                    break;
                case 1: {
                    a += "" + tab[0];
                    break;
                }
                case 2: {
                    a += "" + tab[0] + tab[1];
                    break;
                }
                default:
                    a += "" + tab[0] + tab[1] + tab[2];
            }
        }
        return a;
    }

    /*
     * Count the number of "xx" in the given string.
      * We'll say that overlapping is allowed, so "xxx" contains 2 "xx".
     */
    int countXX(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++)
            if (str.substring(i, i + 2).equals("xx"))
                count++;
        return count;
    }

    /*
     * Given a string, return true if the first instance of
     * "x" in the string is immediately followed by another "x".
     */
    boolean doubleX(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.substring(i, i + 2).equals("xx"))
                return true;
            else if (str.charAt(i) == 'x' && !(str.charAt(i + 1) == 'x'))
                return false;
        }
        return false;
    }

    /*
     * Given a string, return a new string made of every
     * other char starting with the first, so "Hello" yields "Hlo".
     */
    public String stringBits(String str) {
        String a = "";
        for (int i = 0; i < str.length(); i += 2) {
            a += "" + str.charAt(i);
        }
        return a;
    }

    /*
     * Given a non-empty string like "Code" return a string like "CCoCodCode".
     */
    public String stringSplosion(String str) {
        String a = "";
        for (int i = 1; i <= str.length(); i++) {
            a += "" + str.substring(0, i);
        }
        return a;
    }

    /*
     * Given a string, return the count of the number of times that a substring
     * length 2 appears in the string and also as the last 2 chars of the string,
     * so "hixxxhi" yields 1 (we won't count the end substring).
     */
    public int last2(String str) {
        if (str.length() <= 3)
            return 0;
        int a = 0;
        for (int i = 0; i < str.length() - 1; i++)
            a += (str.substring(str.length() - 2).equals(str.substring(i, i + 2))) ? 1 : 0;

        return a - 1;
    }

    /*
     * Given an array of ints, return the number of 9's in the array.
     */
    public int arrayCount9(int[] nums) {
        int b = 0;
        for (int a : nums) {
            b += (a == 9) ? 1 : 0;
        }
        return b;
    }

    /*
     * Given an array of ints, return true if one of the first 4 elements in the array is a 9.
     * The array length may be less than 4.
     */
    public boolean arrayFront9(int[] nums) {
        int a = 0;
        for (int k : nums) {
            a++;
            if ((a < 4) && k == 9)
                return true;
        }
        return false;
    }

    /*
     * Given an array of ints, return true if the sequence of numbers 1, 2, 3
     * appears in the array somewhere.
     */
    public boolean array123(int[] nums) {
        for (int a = 0; a < (nums.length - 2); a++) {
            if (nums[a] == 1)
                if (nums[a + 1] == 2)
                    if (nums[a + 2] == 3)
                        return true;
        }
        return false;
    }

    /*
     * Given 2 strings, a and b, return the number of the positions where they
     * contain the same length 2 substring. So "xxcaazz" and "xxbaaz" yields 3,
      * since the "xx", "aa", and "az" substrings appear in the same place in both strings.
     */
    public int stringMatch(String a, String b) {
        int count = 0, stringSize = Math.min(a.length(), b.length());
        for (int i = 2; i <= stringSize; i++) {
            count += (a.substring(i - 2, i).equals(b.substring(i - 2, i))) ? 1 : 0;
        }
        return count;
    }

    /*
     * Given a string, return a version where all the "x" have been removed.
     * Except an "x" at the very start or end should not be removed.
     */
    public String stringX(String str) {
        String a = "";
        if (str.length() <= 2)
            return str;

        a += str.charAt(0);
        for (int i = 1; i < str.length() - 1; i++) {
            a += (str.charAt(i) == 'x') ? "" : str.charAt(i);
        }
        a += str.charAt(str.length() - 1);
        return a;
    }

    /*
     * Given a string, return a string made of the chars
     * at indexes 0,1, 4,5, 8,9 ... so "kittens" yields "kien".
     */
    public String altPairs(String str) {
        String a = "";
        for (int i = 0; i < str.length(); i += 4) {
            a += str.substring(i, i + 1);
            a += (i + 2 > str.length()) ? "" : str.substring(i + 1, i + 2);
        }
        return a;
    }

    /*
     * Suppose the string "yak" is unlucky. Given a string,
     * return a version where all the "yak" are removed,
     * but the "a" can be any char. The "yak" strings will not overlap.
     */
    public String stringYak(String str) {
        return str.replace("yak", "");
    }

    /*
     * Given an array of ints, return the number of times that two 6's are
     * next to each other in the array. Also count instances where the second "6" is actually a 7.
     */
    public int array667(int[] nums) {
        int a = 0;
        for (int i = 0; i < nums.length - 1; i++)
            a += (nums[i] == 6 && (nums[i + 1] == 6 || nums[i + 1] == 7)) ? 1 : 0;

        return a;
    }

    /*
     * Given an array of ints, we'll say that a triple is a value appearing 3 times in a row in the array.
     * Return true if the array does not contain any triples.
     */
    public boolean noTriples(int[] nums) {
        if (nums.length < 3) return true;
        int a = 0;
        for (int i = 0; i < nums.length - 2; i++)
            a += ((nums[i] == nums[i + 1]) && (nums[i] == nums[i + 2])) ? 1 : 0;
        return (a == 0);
    }

    /*
     * Given an array of ints, return true if it contains a 2, 7, 1 pattern: a value,
     * followed by the value plus 5, followed by the value minus 1.
     * Additionally the 271 counts even if the "1" differs by 2 or less from the correct value.
     */
    public boolean has271(int[] nums) {
        for (int i = 0; i < (nums.length - 2); i++) {
            int val = nums[i];
            if (nums[i + 1] == (val + 5) &&
                    Math.abs(nums[i + 2] - (val - 1)) <= 2) return true;
        }
        return false;
    }


}
