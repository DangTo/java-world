package org.apache.camel.example.ftp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
//IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
//SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

	public List<String> subStringsKDist(String inputStr, int num) {

		List<String> result = new ArrayList<String>();

		if (inputStr == null || inputStr.isEmpty() || num <= 0)
			return result;

		char[] charArray = inputStr.toCharArray();

		for (int i = 0; i <= inputStr.length() - num; i++) {
			StringBuilder distinctWord = new StringBuilder();
			distinctWord.append(charArray[i]);
			for (int j = 1; j < num; j++) {

				for (int k = 1; k < num - j; k++) {
					if (charArray[i] == charArray[i + j]) {
						break;
					}
				}

				distinctWord.append(charArray[i + j]);
			}

			if (distinctWord.toString().length() == num && !result.contains(distinctWord.toString()))
				result.add(distinctWord.toString());

			// System.out.println(result.toString());
		}

		return result;
	}

	public static void main(String[] args) {
		/*
		 * Solution solution = new Solution(); String inputStr =
		 * "awagnlknagawunagwkwagl"; int num = 4; List<String> result =
		 * solution.subStringsKDist(inputStr, num);
		 * System.out.println(result.toString());
		 */

		/*
		 * int[] a = {1}; int[] b = new int[10]; b[0] = 0; System.arraycopy(a, 0, b, 0,
		 * 1);
		 * 
		 * for(int i:b) { System.out.println(i); }
		 */

		/*
		 * int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}}; int n = matrix.length;
		 * 
		 * System.out.println("Original"); for (int i = 0; i < n; i++) { for (int j = 0;
		 * j < n; j++) { System.out.print(matrix[i][j] + " "); } System.out.println(); }
		 * 
		 * for (int i = 0; i < n / 2; i++) { for (int j = 0; j < (n+1)/2; j++) { int
		 * temp = matrix[i][j]; matrix[i][j] = matrix[n-1-j][i]; matrix[n-1-j][i] =
		 * matrix[n-1-i][n-1-j]; matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
		 * matrix[j][n-1-i] = temp; } }
		 * 
		 * System.out.println("Rotate"); for (int i = 0; i < n; i++) { for (int j = 0; j
		 * < n; j++) { System.out.print(matrix[i][j] + " "); } System.out.println(); }
		 */

		/*
		 * int[] arr = new int[] { 6, 3, 9 }; int[] arr2 = new int[] { 9, 3, 6, 0, 0 };
		 * 
		 * // Arrays.sort(arr); // Arrays.sort(arr2); System.arraycopy(arr, 0, arr2, 3,
		 * 2); System.out.println(Math.max(99, 343));
		 * 
		 * String str = "abcdef"; char[] ch = str.toCharArray();
		 * 
		 * for (int i = 0; i < 5; i++) { System.out.print(arr2[i] + " ");
		 * System.out.println(ch[i]); System.out.println(str.charAt(i)); }
		 * System.out.println(str.substring(1, 3));
		 * System.out.println(Arrays.toString(ch));
		 * 
		 * boolean isEqual = Arrays.equals(arr, arr2); System.out.println(isEqual);
		 * 
		 * // set(no dup), list(index), map(key value)
		 * 
		 * Map<String, String> map1 = new HashMap<String, String>(); List<String> list1
		 * = new ArrayList<String>(); Set<String> set1 = new HashSet<String>();
		 * 
		 * list1.add("abc"); set1 = new HashSet<String>(list1); list1 = new
		 * ArrayList<String>(set1); map1.put("a", "b");
		 */

		String[][] students = new String[][] { { "Danny", "100" }, { "John", "34" }, { "Jane", "78" },
				{ "Danny", "40" }, { "Jim", "56" }, { "Tifa", "80" }, { "Jane", "90" } };
		Integer bestScore = 0;
		
		//first: create a map to store student and their score
		//second: if a student appears more than once then calculate his average score before put to map
		//third: compare current score with best score and set best score accordingly
		
		Map<String, Integer> studentMap = new HashMap<String, Integer>();
		for (int i = 0; i < students.length - 1; i++) {
			if (studentMap.containsKey(students[i][0]))
				continue;

			Integer score = Integer.parseInt(students[i][1]);

			for (int j = i + 1; j < students.length; j++) {
				if (students[i][0].equals(students[j][0])) {
					score = (score + Integer.parseInt(students[j][1])) / 2;
				}
			}

			studentMap.put(students[i][0], score);

			if (bestScore < score)
				bestScore = score;
		}

		System.out.println("Best Score:" + bestScore);
	}
}