package level_2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Kacper Kuźniarski on 05.06.2017.
 */
public class Map_2 {
    /*
     * Given an array of strings, return a Map<String, Integer> containing a key
     * for every different string in the array, always with the value 0.
     * For example the string "hello" makes the pair "hello":0.
     * We'll do more complicated counting later, but for this problem the value is simply 0.
     */
    public Map<String, Integer> word0(String[] strings) {
        Map<String, Integer> map = new HashMap<>();

        Arrays.asList(strings).forEach(s -> map.put(s, 0));
        return map;
    }

    /*
     * Given an array of strings, return a Map<String, Integer> containing a key
     * for every different string in the array, and the value is that string's length.
     */
    public Map<String, Integer> wordLen(String[] strings) {
        Map<String, Integer> map = new HashMap<>();

        Arrays.asList(strings).forEach(s -> map.put(s, s.length()));
        return map;
    }

    /*
     * Given an array of non-empty strings, create and return a Map<String,
     * String> as follows: for each string add its first character as a key with its last character as the value.
     */
    public Map<String, String> pairs(String[] strings) {
        Map<String, String> map = new HashMap<>();

        Arrays.asList(strings)
                .forEach(s -> map.put(s.substring(0, 1), s.substring(s.length() - 1, s.length())));
        return map;
    }

    /*
     * The classic word-count algorithm: given an array of strings, return a Map<String, Integer>
     * with a key for each different string, with the value the number of times that string appears in the array.
     */
    public Map<String, Integer> wordCount(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(strings);
        int max = 1;
        for (int i = 1; i < strings.length; i++) {
            if (strings[i - 1].equals(strings[i])) {
                max++;
            } else {
                map.put(strings[i - 1], max);
                max = 1;
            }
            if (i == strings.length - 1)
                map.put(strings[strings.length - 1], max);
        }
        return map;
    }

    /*
     * Given an array of non-empty strings, return a Map<String, String> with a key
     * for every different first character seen, with the value of all the strings starting
     * with that character appended together in the order they appear in the array.
     */
    public Map<String, String> firstChar(String[] strings) {
        Map<String, String> map = new HashMap<String, String>();

        for (int i = 0; i < strings.length; i++) {
            String key = String.valueOf(strings[i].charAt(0));
            if (map.containsKey(key)) {
                String val = map.get(key) + strings[i];
                map.put(key, val);
            } else {
                map.put(key, strings[i]);
            }
        }
        return map;
    }

    /*
     * Loop over the given array of strings to build a result string like this:
     * when a string appears the 2nd, 4th, 6th, etc. time in the array, append the string to the result.
     * Return the empty string if no string appears a 2nd time.
     */
    public String wordAppend(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        String result = "";

        for (String s : strings) {
            if (!map.containsKey(s))
                map.put(s, 1);
            else {
                map.put(s, map.get(s) + 1);
                if (map.get(s) % 2 == 0)
                    result += s;
            }
        }
        return result;
    }

    /*
     * Given an array of strings, return a Map<String, Boolean> where each different string is a key
     * and its value is true if that string appears 2 or more times in the array.
     */
    public Map<String, Boolean> wordMultiple(String[] strings) {
        Map<String, Boolean> map = new HashMap<>();
        for (String text : strings) {
            if (map.containsKey(text))
                map.put(text, true);
            else
                map.put(text, false);
        }
        return map;
    }


    /*
     * We'll say that 2 strings "match" if they are non-empty and their first chars are the same.
     * Loop over and then return the given array of non-empty strings as follows: if a string matches
     * an earlier string in the array, swap the 2 strings in the array.
     * When a position in the array has been swapped, it no longer matches anything.
     * Using a map, this can be solved making just one pass over the array. More difficult than it looks.
     */
    public String[] allSwap(String[] strings) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            String key = String.valueOf(strings[i].charAt(0));

            if (map.containsKey(key)) {
                int index = map.get(key);

                String swapper = strings[index];
                strings[index] = strings[i];
                strings[i] = swapper;

                map.remove(key);
            } else {
                map.put(key, i);
            }
        }
        return strings;
    }

    /*
     * We'll say that 2 strings "match" if they are non-empty and their first chars are the same.
     * Loop over and then return the given array of non-empty strings as follows:
     * if a string matches an earlier string in the array, swap the 2 strings in the array.
     * A particular first char can only cause 1 swap, so once a char has caused a swap,
     * its later swaps are disabled. Using a map, this can be solved making just one pass over the array.
     * More difficult than it looks.
     */
    public String[] firstSwap(String[] strings) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            String key = String.valueOf(strings[i].charAt(0));

            if (map.containsKey(key)) {
                int index = map.get(key);
                if (index == -1) {
                    continue;
                }

                String swapper = strings[index];
                strings[index] = strings[i];
                strings[i] = swapper;

                map.put(key, -1);
            } else {
                map.put(key, i);
            }
        }
        return strings;
    }


}
