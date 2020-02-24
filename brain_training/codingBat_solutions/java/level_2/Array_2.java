package level_2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by kacper kuźniarski on 01.06.2017.
 */
public class Array_2 {
    /*
     * Return the number of even ints in the given array. Note: the % "mod"
     * operator computes the remainder, e.g. 5 % 2 is 1.
     *
     */
    public int countEvens(int[] nums) {
        int eventIntsAmount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0)
                eventIntsAmount++;
        }
        return eventIntsAmount;
    }

    /* Given an array length 1 or more of ints,
     * return the difference between the largest and smallest values in the array.
     * Note: the built-in Math.min(v1, v2) and Math.max(v1, v2) methods return the smaller or larger of two values.:
     */
    public int bigDiff(int[] nums) {
        List<Integer> ints = Arrays.stream(nums).boxed().collect(Collectors.toList());

        int min = ints.stream().min(Comparator.comparing(i -> i)).get();
        int max = ints.stream().max(Comparator.comparing(i -> i)).get();

        return max - min;
    }

    /*
     * Return the "centered" average of an array of ints, which we'll say is the mean average of the values,
     * except ignoring the largest and smallest values in the array. If there are multiple copies of the smallest value,
     * ignore just one copy, and likewise for the largest value. Use int division to produce the final average.
     * You may assume that the array is length 3 or more.
     */
    public int centeredAverage(int[] nums) {
        int sum = 0;
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return (sum - max - min) / (nums.length - 2);
    }


    /* Return the sum of the numbers in the array, returning 0 for an empty array. Except the number 13
     * is very unlucky, so it does not count and numbers that come immediately after a 13 also do not count.
     */
    public int sum13(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num != 13) sum += num;
            else i++;
        }
        return sum;
    }

    /* Return the sum of the numbers in the array, except ignore sections of numbers starting
     * with a 6 and extending to the next 7 (every 6 will be followed by at least one 7). Return 0 for no numbers.
     */
    public int sum67(int[] nums) {
        int sum = 0;
        boolean sequence = false;
        for (int num : nums) {
            if (num == 6)
                sequence = true;
            else if (num == 7 && sequence)
                sequence = false;
            else if (!sequence)
                sum += num;
        }
        return sum;

    }

    /*
     * Given an array of ints, return true if the array contains a 2 next to a 2 somewhere.
     */
    public boolean has22(int[] nums) {
        boolean has22 = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 2 && nums[i + 1] == 2)
                has22 = true;
        }
        return has22;
    }

    /*
     * Given an array of ints, return true if the array contains no 1's and no 3's.
     */
    public boolean lucky13(int[] nums) {
        return !Arrays.stream(nums).anyMatch(value -> value == 1 || value == 3);
    }

    /*
     * Given an array of ints, return true if the sum of all the 2's in the array is exactly 8.
     */
    public boolean sum28(int[] nums) {
        return (Arrays.stream(nums).filter(v -> v == 2).count() == 4);
    }

    /*
     * Given an array of ints, return true if the number of 1's is greater than the number of 4's
     */
    public boolean more14(int[] nums) {
        long amount1s = Arrays.stream(nums).filter(v -> v == 1).count();
        long amount4s = Arrays.stream(nums).filter(v -> v == 4).count();

        return (amount1s > amount4s);
    }

    /* Given a number n, create and return a new int array of length n, containing the numbers 0, 1, 2, ... n-1.
     * The given n may be 0, in which case just return a length 0 array. You do not need a separate if-statement
     * for the length-0 case; the for-loop should naturally execute 0 times in that case, so it just works.
     */
    public int[] fizzArray(int n) {
        int tab[] = new int[n];
        for (int i = 0; i < n; i++)
            tab[i] = i;

        return tab;
    }

    /*
     * Given an array of ints, return true if every element is a 1 or a 4.
     */
    public boolean only14(int[] nums) {
        return Arrays.stream(nums).allMatch(v -> v == 1 || v == 4);
    }

    /* Given a number n, create and return a new string array of length n, containing the strings "0", "1" "2" ..
     * through n-1. N may be 0, in which case just return a length 0 array. Note: String.valueOf(xxx) will make
     * the String form of most types. The syntax to make a new string array is: new String[desired_length]
     */
    public String[] fizzArray2(int n) {
        String tab[] = new String[n];
        for (int i = 0; i < n; i++)
            tab[i] = "" + i;

        return tab;
    }

    /*
     * Given an array of ints, return true if it contains no 1's or it contains no 4's.
     */
    public boolean no14(int[] nums) {
        return !(Arrays.stream(nums).anyMatch(v -> v == 1) && Arrays.stream(nums).anyMatch(v -> v == 4));
    }

    /*
     * We'll say that a value is "everywhere" in an array if for every pair of adjacent elements in the array,
     * at least one of the pair is that value. Return true if the given value is everywhere in the array.
     */

    public boolean isEverywhere(int[] nums, int val) {
        boolean result = true;
        for (int i = 0; i <= nums.length - 2; i++) {
            if (nums[i] != val && nums[i + 1] != val)
                result = false;
        }
        return result;
    }

    /*
     * Given an array of ints, return true if the array contains a 2 next to a 2 or a 4 next to a 4, but not both.
     */
    public boolean either24(int[] nums) {
        boolean has2 = false;
        boolean has4 = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1] && nums[i] == 2) {
                has2 = true;
            } else if (nums[i] == nums[i + 1] && nums[i] == 4) {
                has4 = true;
            }
        }
        return (has2 && !has4 || has4 && !has2);
    }

    /* Given arrays nums1 and nums2 of the same length, for every element in nums1,
     * consider the corresponding element in nums2 (at the same index). Return the count of
     * the number of times that the two elements differ by 2 or less, but are not equal.:
     */
    public int matchUp(int[] nums1, int[] nums2) {
        int count = 0;

        for (int i = 0; i < nums1.length; i++) {
            if (Math.abs(nums1[i] - nums2[i]) <= 2 && nums1[i] != nums2[i])
                count++;
        }

        return count;
    }

    /* Given an array of ints, return true if the array contains two 7's next to each other,
     * or there are two 7's separated by one element, such as with {7, 1, 7}.
     */
    public boolean has77(int[] nums) {
        boolean has77 = false;
        if (nums.length < 2)
            has77 = false;
        else has77 = (nums[0] == 7 && nums[1] == 7);


        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 7 && (nums[i + 1] == 7 || nums[i + 2] == 7) || nums[i + 1] == 7 && nums[i + 2] == 7)
                has77 = true;
        }
        return has77;
    }

    /* Given an array of ints, return true if there is a 1 in the array with a 2 somewhere later in the array. */
    public boolean has12(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        if (!list.contains(1) || nums.length < 2)
            return false;

        int indexOf1 = list.indexOf(1);
        list = list.subList(indexOf1, list.size());

        return list.stream().filter(p -> p == 2).count() != 0;
    }

    /* Given an array of ints, return true if the array contains either 3 even or 3 odd values all next to each other. */
    public boolean modThree(int[] nums) {
        boolean result = false;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i; j < nums.length - 2; j++) {
                if (nums[j] % 2 == 0 && nums[j + 1] % 2 == 0 && nums[j + 2] % 2 == 0 || nums[j] % 2 != 0 && nums[j + 1] % 2 != 0 && nums[j + 2] % 2 != 0)
                    result = true;
            }
        }
        return result;
    }

    /*Given an array of ints, return true if the value 3 appears in the array exactly 3 times, and no 3's are next to each other.*/
    public boolean haveThree(int[] nums) {
        return Arrays.stream(nums).filter(i -> i == 3).count() == 3 && !Arrays.toString(nums).matches(".*3, 3.*");
    }

    /*Given an array of ints, return true if every 2 that appears in the array is next to another 2.*/
    public boolean twoTwo(int[] nums) {
        if (nums.length == 1 && nums[0] == 2)
            return false;

        if (nums.length >= 2 && ((nums[0] == 2 && nums[1] != 2) ||
                (nums[nums.length - 1] == 2 && nums[nums.length - 2] != 2)))
            return false;

        for (int i = 1; i <= nums.length - 2; i++) {
            if (nums[i] == 2 && nums[i - 1] != 2 && nums[i + 1] != 2)
                return false;
        }

        return true;
    }

    /*
     * Return true if the group of N numbers at the start and end of the array are the same.
     * For example, with {5, 6, 45, 99, 13, 5, 6}, the ends are the same for n=0 and n=2, and false for n=1 and n=3.
     * You may assume that n is in the range 0..nums.length inclusive.
     */
    public boolean sameEnds(int[] nums, int len) {
        int arraySize = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] != nums[arraySize - len + i])
                return false;
        }
        return true;
    }

    /*
     * Return true if the array contains, somewhere, three increasing adjacent numbers like .... 4, 5, 6, ... or 23, 24, 25.
     */
    public boolean tripleUp(int[] nums) {
        if (nums.length < 3)
            return false;

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == nums[i + 1] - 1 && nums[i] == nums[i + 2] - 2)
                return true;
        }
        return false;
    }

    /*
     * Given start and end numbers, return a new array containing the sequence of integers from start up to but not including end,
     * so start=5 and end=10 yields {5, 6, 7, 8, 9}.
     * The end number will be greater or equal to the start number. Note that a length-0 array is valid. (See also: FizzBuzz Code)
     */
    public int[] fizzArray3(int start, int end) {
        int[] array = new int[end - start];
        for (int i = 0; i < end - start; i++) {
            array[i] = i + start;
        }
        return array;
    }

    /*
     * Return an array that is "left shifted" by one -- so {6, 2, 5, 3} returns {2, 5, 3, 6}.
     * You may modify and return the given array, or return a new array.
     */
    public int[] shiftLeft(int[] nums) {
        if (nums.length < 2)
            return nums;

        int result[] = new int[nums.length];
        result[nums.length - 1] = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            result[i] = nums[i + 1];
        }
        return result;
    }

    /*
     * For each multiple of 10 in the given array, change all the values following it to be that multiple of 10,
     * until encountering another multiple of 10. So {2, 10, 3, 4, 20, 5} yields {2, 10, 10, 10, 20, 20}.
     */
    public int[] tenRun(int[] nums) {
        boolean isDivisibleByTen = false;
        int temp = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 10 == 0) {
                temp = nums[i];
                isDivisibleByTen = true;
            } else if (nums[i] % 10 != 0 && isDivisibleByTen) {
                nums[i] = temp;
            }
        }
        return nums;
    }

    /*
     * Given a non-empty array of ints, return a new array containing the elements from the original array
     * that come before the first 4 in the original array. The original array will contain at least one 4.
     * Note that it is valid in java to create an array of length 0.
     */
    public int[] pre4(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 4)
                resultList.add(nums[i]);
            else
                break;
        }
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    /*
     * Given a non-empty array of ints, return a new array containing the elements from the original array that
     * come after the last 4 in the original array. The original array will contain at least one 4.
     * Note that it is valid in java to create an array of length 0.
     */
    public int[] post4(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] != 4)
                resultList.add(nums[i]);
            else
                break;
        }

        Collections.reverse(resultList);
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    /*
     * We'll say that an element in an array is "alone" if there are values before and after it,
     * and those values are different from it. Return a version of the given array where every instance
     * of the given value which is alone is replaced by whichever value to its left or right is larger.
     */
    public int[] notAlone(int[] nums, int val) {
        if (nums.length < 3)
            return nums;

        for (int i = 0; i < nums.length - 2; i++) {
            int biggerNeighbour = Math.max(nums[i], nums[i + 2]);

            if (nums[i] != nums[i + 1] && nums[i + 1] != nums[i + 2])
                nums[i + 1] = Math.max(nums[i + 1], biggerNeighbour);
        }
        return nums;
    }

    /*
     * Return an array that contains the exact same numbers as the given array, but rearranged so that
     * all the zeros are grouped at the start of the array. The order of the non-zero numbers does not matter.
     * So {1, 0, 0, 1} becomes {0 ,0, 1, 1}. You may modify and return the given array or make a new array.
     */
    public int[] zeroFront(int[] nums) {
        boolean hasZero = false;
        for (int i : nums) {
            if (i == 0) {
                hasZero = true;
                break;
            }
        }

        if (hasZero) {
            int endIndex = nums.length - 1,
                    beginIndex = 0;
            while (beginIndex < endIndex) {

                if (nums[beginIndex] != 0 && nums[endIndex] == 0) {
                    int temp = nums[beginIndex];
                    nums[beginIndex] = nums[endIndex];
                    nums[endIndex] = temp;

                }

                while (nums[beginIndex] == 0 && beginIndex != endIndex) {
                    beginIndex++;
                }

                while (nums[endIndex] != 0) {
                    endIndex--;
                }
            }

        }
        return nums;

    }

    /*
     * Return a version of the given array where all the 10's have been removed.
     * The remaining elements should shift left towards the start of the array as needed,
     * and the empty spaces a the end of the array should be 0. So {1, 10, 10, 2} yields {1, 2, 0, 0}.
     * You may modify and return the given array or make a new array.
     */
    public int[] withoutTen(int[] nums) {
        int[] resultArray = new int[nums.length];

        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = 0;
        }

        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 10) {
                resultArray[j] = nums[i];
                j++;
            }
        }
        return resultArray;
    }

    /*
     * Return a version of the given array where each zero value in the array is replaced by
     * the largest odd value to the right of the zero in the array. If there is no odd value to the right of the zero,
     * leave the zero as a zero.
     */
    public int[] zeroMax(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int maxOddToRight = 0;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] > maxOddToRight && nums[j] % 2 != 0)
                        maxOddToRight = nums[j];
                }
                nums[i] = maxOddToRight;
            }
        }
        return nums;
    }

    /*
     * Return an array that contains the exact same numbers as the given array, but rearranged
     * so that all the even numbers come before all the odd numbers. Other than that,
     * the numbers can be in any order. You may modify and return the given array, or make a new array.
     */
    public int[] evenOdd(int[] nums) {
        int endIndex = nums.length - 1,
                beginIndex = 0;
        while (beginIndex < endIndex) {

            if (nums[beginIndex] % 2 != 0 && nums[endIndex] % 2 == 0) {
                int temp = nums[beginIndex];
                nums[beginIndex] = nums[endIndex];
                nums[endIndex] = temp;
            }

            while (nums[beginIndex] % 2 == 0 && beginIndex < nums.length - 1) {
                beginIndex++;
            }

            while (nums[endIndex] % 2 != 0) {
                endIndex--;
            }
        }
        return nums;
    }

    /*
     * This is slightly more difficult version of the famous FizzBuzz problem which is sometimes
     * given as a first problem for job interviews. (See also: FizzBuzz Code.) Consider the series of numbers
     * beginning at start and running up to but not including end, so for example start=1 and end=5 gives
     * the series 1, 2, 3, 4. Return a new String[] array containing the string form of these numbers,
     * except for multiples of 3, use "Fizz" instead of the number, for multiples of 5 use "Buzz",
     * and for multiples of both 3 and 5 use "FizzBuzz". In Java, String.valueOf(xxx) will make the
     * String form of an int or other type. This version is a little more complicated than the usual
     * version since you have to allocate and index into an array instead of just printing,
     * and we vary the start/end instead of just always doing 1..100.
     */
    public String[] fizzBuzz(int start, int end) {
        String[] array = new String[end - start];

        for (int i = start; i < end; i++) {
            String temp = (i % 3 == 0) ? "Fizz" : "";
            temp += (i % 5 == 0) ? "Buzz" : "";

            array[i-start] = (temp.equals("")) ? "" + i : temp;
        }
        return array;
    }


}
