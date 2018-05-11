package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumI {

	/*
	 * Question: Given an array of integers, find two numbers such that they add up
	 * to a specific target number. The function twoSum should return indices of the
	 * two numbers such that they add up to the target, where index1 must be less
	 * than index2. Please note that your returned answers (both index1 and index2)
	 * are not zero-based. You may assume that each input would have exactly one
	 * solution.
	 */

	/*
	 * Solution: 
	 * O(n2) runtime, O(1) space – Brute force: The brute force approach
	 * is simple. Loop through each element x and find if there is another value
	 * that equals to target – x. As finding another value requires looping through
	 * the rest of array, its runtime complexity is O(n2). 
	 * 
	 * O(n) runtime, O(n) space
	 * – Hash table: We could reduce the runtime complexity of looking up a value to
	 * O(1) using a hash map that maps a value to its index.
	 */
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
		
		for(int i=0; i<nums.length - 1; i++) {
			if(numMap.containsKey(target - nums[i])) {
				return new int[] {nums[i], target - nums[i]};
			}
			// if not put this number to map
			numMap.put(nums[i], i);
		}
		
		return new int[] {-1, -1};
	}

	public static void main(String[] args) {
		TwoSumI twoSumI = new TwoSumI();
		
		int[] nums = new int[] {-1, 0, 2, 4, 6, 8, 3};
		int target = 12;
		
		Arrays.stream(twoSumI.twoSum(nums, target)).forEach(a -> System.out.println(a));

	}

}
