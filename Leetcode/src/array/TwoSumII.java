package array;

import java.util.Arrays;

public class TwoSumII {

	public int[] twoSum(int[] nums, int target) {
		Arrays.sort(nums);// cost 0(n2)

		for (int i = 0; i < nums.length; i++) {// cost 0(n)
			if (binarySearch(nums, target - nums[i], i + 1, nums.length - 1)) {
				return new int[] { nums[i], target - nums[i] };
			}
		}

		return new int[] {};
	}

	public boolean binarySearch(int[] nums, int key, int start, int end) {// cost 0(log(n))

		while (start < end) {
			int mid = (start + end) / 2;
			System.out.println("Key:" + key);
			System.out.println("Mid Num:" + nums[mid]);
			System.out.println("start:" + start);
			System.out.println("mid:" + mid);
			System.out.println("end:" + end);
			System.out.println("***********");
			if (nums[mid] < key) {
				start = mid + 1;
			} else if (nums[mid] > key) {
				end = mid;
			} else {
				return true;
			}
		}

		// check last case
		if (start == end && key == nums[start])
			return true;

		return false;
	}
	
	public int[] twoSumUsingPointers(int[] nums, int target) {
		Arrays.sort(nums);// cost 0(n2)
		
		int start = 0;
		int end = nums.length-1;
		
		while(start < end) {
			System.out.println("nums[start]:" + nums[start]);
			System.out.println("nums[end]:" + nums[end]);
			System.out.println("sum:" + (nums[start] + nums[end]));
			if(nums[start] + nums[end] < target) {
				start++;
			} else if(nums[start] + nums[end] > target) {
				end--;
			} else {
				return new int[] {nums[start], nums[end]};
			}
		}
		
		return new int[] {};
	}

	public static void main(String[] args) {
		TwoSumII twoSumII = new TwoSumII();

		int[] nums = { -4, -2, 0, 1, 3, 5, 9 };
		int target = 4;

		int[] result = twoSumII.twoSumUsingPointers(nums, target);

		Arrays.stream(result).forEach(a -> System.out.println(a));
	}

}
