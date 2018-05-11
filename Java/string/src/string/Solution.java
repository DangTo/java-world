package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public String reverseString(String sourceStr) {
		String reversedStr = null;

		return reversedStr;
	}

	public String[] getAllSubstring(String sourceStr) {
		List<String> substringList = new ArrayList<String>();

		return (String[]) substringList.toArray();
	}

	public String sortString(String sourceStr) {
		String sortedStr = null;

		return sortedStr;
	}

	public int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			int x = numbers[i];
			if (map.containsKey(target - x)) {
				return new int[] { map.get(target - x) + 1, i + 1 };
			}
			map.put(x, i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	public int[] twoSumSorted(int[] numbers, int target) {
		// Assume input is already sorted.
		for (int i = 0; i < numbers.length; i++) {
			int j = bsearch(numbers, target - numbers[i], i + 1);
			if (j != -1) {
				return new int[] { i + 1, j + 1 };
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	private int bsearch(int[] A, int key, int start) {
		int L = start, R = A.length - 1;
		while (L < R) {
			int M = (L + R) / 2;
			if (A[M] < key) {
				L = M + 1;
			} else {
				R = M;
			}
		}
		return (L == R && A[L] == key) ? L : -1;
	}

	public int[] twoSumPointers(int[] numbers, int target) {
		// Assume input is already sorted.
		int i = 0, j = numbers.length - 1;
		while (i < j) {
			int sum = numbers[i] + numbers[j];
			if (sum < target) {
				i++;
			} else if (sum > target) {
				j--;
			} else {
				return new int[] { i + 1, j + 1 };
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] numbers = new int[] { -3, -1, 0, 4, 7, 10, 21, 22 };
		int target = 17;

		// int[] result = solution.twoSum(numbers, target);
		//int[] result = solution.twoSumSorted(numbers, target);
		int[] result = solution.twoSumPointers(numbers, target);

		// Arrays.stream(result).forEach(System.out::println);
		Arrays.stream(result).forEach(a -> System.out.println(a));
	}

}
