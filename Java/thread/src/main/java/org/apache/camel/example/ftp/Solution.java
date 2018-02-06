package org.apache.camel.example.ftp;

import java.util.ArrayList;
//IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
//SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
import java.util.List;

//DEFINE ANY CLASS AND METHOD NEEDED
//CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution {
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public List<String> subStringsKDist(String inputStr, int num) {
		// WRITE YOUR CODE HERE

		List<String> result = new ArrayList<String>();

		if (inputStr == null || inputStr.isEmpty() || num <= 0)
			return result;

		char[] charArray = inputStr.toCharArray();

		for (int i = 0; i <= inputStr.length() - num; i++) {
			StringBuilder distinctWord = new StringBuilder();
			distinctWord.append(charArray[i]);
			for (int j = 1; j < num; j++) {

				for(int k = 1; k < num - j; k++) {
					if (charArray[i] == charArray[i + j]) {
						break;
					}
				}
				

				distinctWord.append(charArray[i + j]);
			}

			if (distinctWord.toString().length() == num && !result.contains(distinctWord.toString()))
				result.add(distinctWord.toString());

			System.out.println(result.toString());
		}

		return result;
	}
	// METHOD SIGNATURE ENDS

	public static void main(String[] args) {
		Solution solution = new Solution();
		String inputStr = "awagnlknagawunagwkwagl";
		int num = 4;
		List<String> result = solution.subStringsKDist(inputStr, num);
		System.out.println(result.toString());
	}
}