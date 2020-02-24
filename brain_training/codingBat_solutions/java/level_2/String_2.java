package level_2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by kacper on 01.06.2017.
 */
public class String_2 {
    /*
     * Given a string, return a string where for every char in the original,
     * there are two chars.
     */
    public String doubleChar(String str) {
        String a = "";
        for (int i = 0; i < str.length(); i++)
            a += "" + str.charAt(i) + str.charAt(i);
        return a;
    }

    /*
     * Return the number of times that the string "hi" appears anywhere in the
     * given string.
     */
    public int countHi(String str) {
        int a = (str.length() - str.replaceAll("hi", "").length()) / 2;
        return a;
    }

    /*
     * Return true if the string "cat" and "dog" appear the same number of times
     * in the given string.
     */
    public boolean catDog(String str) {
        int cat = (str.length() - str.replaceAll("cat", "").length()) / 3;
        int dog = (str.length() - str.replaceAll("dog", "").length()) / 3;
        return (cat == dog);
    }

    /*
     * Return the number of times that the string "code" appears anywhere in the
     * given string, except we'll accept any letter for the 'd', so "cope" and
     * "cooe" count.
     */
    public int countCode(String str) {
        int c = 0;
        for (int i = 0; i < str.length() - 3; i++) {
            if (str.charAt(i) == 'c' && str.charAt(i + 1) == 'o' && str.charAt(i + 3) == 'e') {
                c++;
            }
        }
        return c;
    }

    /*
     * Given two strings, return true if either of the strings appears at the
     * very end of the other string, ignoring upper/lower case differences (in
     * other words, the computation should not be "case sensitive"). Note:
     * str.toLowerCase() returns the lowercase version of a string.
     */
    public boolean endOther(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        if (a.length() > b.length())
            return (a.substring(a.length() - b.length(), a.length()).equals(b));
        else
            return (b.substring(b.length() - a.length(), b.length()).equals(a));
    }

    /*
     * Return true if the given string contains an appearance of "xyz" where the
     * xyz is not directly preceeded by a period (.). So "xxyz" counts but
     * "x.xyz" does not.
     */
    public boolean xyzThere(String str) {
        return (str.replace(".xyz", "").length() > str.replace("xyz", "").length());
    }

    /*
     * Return true if the given string contains a "bob" string, but where the
     * middle 'o' char can be any char.
     */
    public boolean bobThere(String str) {
        if (str.length() <= 2)
            return false;
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.substring(i, i + 1).equals("b") && str.substring(i + 2, i + 3).equals("b"))
                return true;
        }
        return false;
    }

    /*We'll say that a String is xy-balanced if for all the 'x' chars in the string, there exists a 'y'
     * char somewhere later in the string. So "xxy" is balanced, but "xyx" is not.
     * One 'y' can balance multiple 'x's. Return true if the given string is xy-balanced.
     */
    public boolean xyBalance(String str) {
        boolean y = false;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == 'y')
                y = true;

            if (str.charAt(i) == 'x' && !y)
                return false;
        }
        return true;
    }

    /*
     * Given two strings, a and b, create a bigger string made of the first char
     * of a, the first char of b, the second char of a, the second char of b,
     * and so on. Any leftover chars go at the end of the result
     */
    public String mixString(String a, String b) {
        String result = "";
        int i;
        for (i = 0; i < Math.min(a.length(), b.length()); i++) {
            result += "" + a.charAt(i) + b.charAt(i);
        }

        if (i < a.length())
            result += a.substring(i);
        else if (i < b.length())
            result += b.substring(i);
        return result;
    }

    /*
     * Given a string and an int n, return a string made of n repetitions of the
     * last n characters of the string. You may assume that n is between 0 and
     * the length of the string, inclusive.
     */
    public String repeatEnd(String str, int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += str.substring(str.length() - n);
        }
        return result;
    }

    /* Given a string and an int n, return a string made of the first n characters of the string,
     * followed by the first n-1 characters of the string, and so on. You may assume
     * that n is between 0 and the length of the string, inclusive (i.e. n >= 0 and n <= str.length()).
     */
    public String repeatFront(String str, int n) {
        String result = "";
        for (int i = n; i > 0; i--) {
            result += str.substring(0, i);
        }
        return result;
    }

    /*Given two strings, word and a separator sep, return a big string made of
     * count occurrences of the word, separated by the separator string.
     */
    public String repeatSeparator(String word, String sep, int count) {
        String result = "";
        for (int i = 0; i < count - 1; i++) {
            result += word + sep;
        }
        return (count < 1) ? result : result + word;
    }


    /*
     * Given a string, consider the prefix string made of the first N chars of
     * the string. Does that prefix string appear somewhere else in the string?
     * Assume that the string is not empty and that N is in the range
     * 1..str.length().
     */
    public boolean prefixAgain(String str, int n) {
        return (str.substring(n).length() > str.substring(n).replaceAll(str.substring(0, n), "").length());
    }

    /*
     * Given a string, does "xyz" appear in the middle of the string? To define middle,
     * we'll say that the number of chars to the left and right of the "xyz"
     * must differ by at most one. This problem is harder than it looks.
     */
    public boolean xyzMiddle(String str) {
        if (str.length() < 3)
            return false;

        int prefixPos = str.length() / 2 - 2;
        int postfixPos = str.length() / 2 - 1;

        if (str.length() % 2 == 0) {
            return str.substring(prefixPos, prefixPos + 3).equals("xyz") ||
                    str.substring(postfixPos, postfixPos + 3).equals("xyz");
        }

        return str.substring(postfixPos, postfixPos + 3).equals("xyz");
    }

    /* A sandwich is two pieces of bread with something in between.
     * Return the string that is between the first and last appearance of "bread" in the given string,
     * or return the empty string "" if there are not two pieces of bread.:
     */
    public String getSandwich(String str) {
        int firstBread = str.indexOf("bread") + 5;
        int lastBread = str.lastIndexOf("bread");

        if (str.length() <= 10) return "";

        return str.substring(firstBread, lastBread);
    }

    /* Returns true if for every '*' (star) in the string, if there are chars
     * both immediately before and after the star, they are the same.:
     */
    public boolean sameStarChar(String str) {

        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i) == '*' && str.charAt(i - 1) != str.charAt(i + 1))
                return false;
        }
        return true;
    }

    /* Given a string, compute a new string by moving the first char to come
     * after the next two chars, so "abc" yields "bca". Repeat this process for each subsequent
     * group of 3 chars, so "abcdef" yields "bcaefd". Ignore any group of fewer than 3 chars at the end.
     */
    public String oneTwo(String str) {
        String result = "";
        for (int i = 0; i < str.length() - 2; i += 3) {
            String temporaryString = str.substring(i, i + 3);
            result += temporaryString.substring(1) + temporaryString.charAt(0);
        }
        return result;
    }

    /* Look for patterns like "zip" and "zap" in the string -- length-3,
     * starting with 'z' and ending with 'p'. Return a string where for all such words,
     * the middle letter is gone, so "zipXzap" yields "zpXzp".
     */
    public String zipZap(String str) {
        int size = str.length();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < size; i++) {
            result.append(str.substring(i, i + 1));
            if (i > 0 && i < size - 1) if (str.charAt(i - 1) == 'z' && str.charAt(i + 1) == 'p')
                result = new StringBuilder(result.substring(0, result.length() - 1));
        }
        return result.toString();
    }

    /* Return a version of the given string, where for every star (*) in the string
     * the star and the chars immediately to its left and right are gone. So "ab*cd"
     * yields "ad" and "ab**cd" also yields "ad".
     */
    public String starOut(String str) {
        int size = str.length();
        String result = "";

        for (int i = 0; i < size; i++) {
            if (i == 0 && str.charAt(i) != '*')
                result += str.charAt(i);

            if (i > 0 && str.charAt(i) != '*' && str.charAt(i - 1) != '*')
                result += str.charAt(i);

            if (i > 0 && str.charAt(i) == '*' && str.charAt(i - 1) != '*')
                result = result.substring(0, result.length() - 1);

        }
        return result;
    }

    /* Given a string and a non-empty word string, return a
     * version of the original String where all chars have been replaced by pluses ("+"),
     * except for appearances of the word string which are preserved unchanged.
     */
    public String plusOut(String str, String word) {
        word = java.util.regex.Pattern.quote(word);
        return str.replaceAll("\\G((?:" + word + ")*+).", "$1+");
    }

    /* Given a string and a non-empty word string, return a string made of each char just
     * before and just after every appearance of the word in the string. Ignore cases where
     * there is no char before or after the word, and a char may be included twice if it is between two words.
     */
    public String wordEnds(String str, String word) {

        StringBuilder resultString = new StringBuilder();
        int wordLen = word.length();
        int textLen = str.length();

        for (int i = 0; i < textLen - wordLen + 1; i++) {
            String tmp = str.substring(i, i + wordLen);

            if (i > 0 && tmp.equals(word))
                resultString.append(str, i - 1, i);

            if (i < textLen - wordLen && tmp.equals(word))
                resultString.append(str, i + wordLen, i + wordLen + 1);
        }
        return resultString.toString();
    }


}
