package level_3;

/**
 * Created by kacper kuźniarski on 01.06.2017.
 */
public class Array_3 {
    /*
	 * Consider the leftmost and righmost appearances of some value in an array.
	 * We'll say that the "span" is the number of elements between the two
	 * inclusive. A single value has a span of 1. Returns the largest span found
	 * in the given array. (Efficiency is not a priority.)
	 */
    public int maxSpan(int[] nums) {
        if (nums.length < 1)
            return 0;
        int max = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = nums.length - 1; i < j; j--) {
                if (nums[i] == nums[j])
                    max = Math.max(max, (j - i + 1));
            }
        }
        return max;
    }
}
