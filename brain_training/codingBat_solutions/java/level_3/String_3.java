package level_3;

import java.util.Arrays;
import java.util.Optional;

public class String_3 {

    /* Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez"
     * count, but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if
     * there is not an alphabetic letter immediately following it. (Note: Character.isLetter(char)
     * tests if a char is an alphabetic letter.)
     */
    public int countYZ(String str) {
        if (str.length() == 0)
            return 0;
        str = str.toLowerCase();

        int count = 0;
        for (int i = 0; i <= str.length() - 2; i++) {
            if ((str.charAt(i) == 'y' || str.charAt(i) == 'z') && !Character.isLetter(str.charAt(i + 1)))
                count++;
        }
        if (str.charAt(str.length() - 1) == 'y' || str.charAt(str.length() - 1) == 'z')
            count++;

        return count;
    }

    /* Given two strings, base and remove, return a version of the base string where
     * all instances of the remove string have been removed (not case sensitive). You may assume that the
     * remove string is length 1 or more. Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     */
    public String withoutString(String base, String remove) {
        return base.replaceAll(remove, "").replaceAll(remove.toLowerCase(), "").replaceAll(remove.toUpperCase(), "");
    }

    /*
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal to
     * the number of appearances of "not" anywhere in the string (case sensitive).
     */
    public boolean equalIsNot(String str) {
        int len = str.length();
        return (len - str.replaceAll("not", "").length()) / 3 == (len - str.replaceAll("is", "").length()) / 2;
    }

    /*
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     */
    public boolean gHappy(String str) {
        int length = str.length();
        boolean happy = true;

        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == 'g') {
                if (i > 0 && str.charAt(i - 1) == 'g')
                    happy = true;

                else if (i < length - 1 && str.charAt(i + 1) == 'g')
                    happy = true;

                else
                    happy = false;

            }
        }
        return happy;

    }

    /*
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     */
    public int countTriple(String str) {
        int result = 0;
        if (str.length() < 3) return result;

        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i) == str.charAt(i + 1) && str.charAt(i) == str.charAt(i + 2))
                result++;
        }
        return result;
    }

    /*
     * Given a string, return the sum of the digits 0-9 that appear in the string, ignoring all other characters.
     * Return 0 if there are no digits in the string. (Note: Character.isDigit(char) tests if a char is one of the chars
     * '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)
     */
    public int sumDigits(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            char tempChar = str.charAt(i);
            if (Character.isDigit(tempChar))
                result += Integer.parseInt("" + tempChar);
        }
        return result;
    }

    /*
     * Given a string, return the longest substring that appears at both the beginning
     * and end of the string without overlapping. For example, sameEnds("abXab") is "ab".
     */
    public String sameEnds(String string) {
        int length = string.length();
        String result = "", temp = "";

        for (int i = 0; i < length; i++) {
            temp += string.charAt(i);
            int tempLength = temp.length();
            if (i < length / 2 && temp.equals(string.substring(length - tempLength, length)))
                result = temp;
        }
        return result;
    }

    /*
     * Given a string, look for a mirror image (backwards) string at both the beginning and end of the given string.
     * In other words, zero or more characters at the very begining of the given string, and at the very end of
     * the string in reverse order (possibly overlapping). For example, the string "abXYZba" has the mirror end "ab".
     */
    public String mirrorEnds(String string) {
        String reverseString = new StringBuilder(string).reverse().toString();
        if (string.equals(reverseString))
            return string;

        int sLength = string.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sLength / 2; i++) {
            if (string.charAt(i) == string.charAt(sLength - 1 - i))
                result.append(string.charAt(i));
            else
                break;
        }
        return result.toString();
    }

    /*
     * Given a string, return the length of the largest "block" in the string.
     * A block is a run of adjacent chars that are the same.
     */
    public int maxBlock(String str) {
        if (str.length() == 0)
            return 0;

        int maxBlock = 1;
        int temp = 1;

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                temp++;
            } else {
                if (maxBlock < temp)
                    maxBlock = temp;
                temp = 1;
            }
        }
        return Math.max(maxBlock, temp);
    }

    /*
     * Given a string, return the sum of the numbers appearing in the string, ignoring all other characters.
     * A number is a series of 1 or more digit chars in a row. (Note: Character.isDigit(char) tests
     * if a char is one of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)
     */
    public int sumNumbers(String str) {
        int result = 0;
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (Character.isDigit(current)) {
                temp.append(current);
            } else if (temp.length() != 0) {
                result += Integer.parseInt(temp.toString());
                temp.setLength(0);
            }
        }
        return (temp.length() != 0) ? result + Integer.parseInt(temp.toString()) : result;
    }

    /*
     * Given a string, return a string where every appearance of the lowercase word "is" has been replaced with "is not".
     * The word "is" should not be immediately preceeded or followed by a letter -- so for example the "is" in "this" does not count.
     * (Note: Character.isLetter(char) tests if a char is a letter.)
     */
    public String notReplace(String str) {
        if (str.equals("is"))
            return "is not";

        StringBuilder result = new StringBuilder();
        int i = 0;

        if (str.length() >= 3 && str.substring(0, 2).equals("is") &&
                !Character.isLetter(str.charAt(2))) {
            result.append("is not");
            i = 2;
        }

        while (i < str.length()) {
            if (!Character.isLetter(str.charAt(i))) {
                result.append(str.charAt(i));
                i++;

            } else if (i >= 1 && i <= str.length() - 3 &&
                    !Character.isLetter(str.charAt(i - 1)) &&
                    str.substring(i, i + 2).equals("is") &&
                    !Character.isLetter(str.charAt(i + 2))) {
                result.append("is not");
                i += 2;

            } else if (i >= 1 && !Character.isLetter(str.charAt(i - 1)) &&
                    str.substring(i).equals("is")) {
                result.append("is not");
                i += 2;

            } else {
                result.append(str.charAt(i));
                i++;
            }
        }

        return result.toString();
    }


}
