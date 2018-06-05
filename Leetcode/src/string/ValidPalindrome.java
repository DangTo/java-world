package string;

import java.util.Arrays;

public class ValidPalindrome {

	/*
	 * Given a string, determine if it is a palindrome, considering only
	 * alphanumeric characters and ignoring cases. For example,
	 * "A man, a plan, a canal: Panama" is a palindrome. "race a car" is not a
	 * palindrome.
	 */
	
	public boolean isValindrome(String str) {
		if(str == null) {
			return false;
		}
		
		int start = 0;
		int end = str.length()-1;
		
		while(start < end) {
			
			while(!Character.isLetterOrDigit(str.charAt(start))) {
				start++;
			}
			
			while(!Character.isLetterOrDigit(str.charAt(end))) {
				end--;
			}
			
			if(Character.toLowerCase(str.charAt(start)) != Character.toLowerCase(str.charAt(end))) {
				return false;
			}
			
			System.out.println("start:" + str.charAt(start));
			System.out.println("end:" + str.charAt(end));
			
			start++;
			end--;
		}
		
		return true;
	}
	
	public String[] breakLines(String str) {
		String[] lines = str.split("\\n?\\r");
		
		return lines;
	}
	
	public String[] breakLineToWords(String str) {
		String[] words = str.split("\\W+");
		
		return words;
	}
	
	public static void main(String[] args) {
		ValidPalindrome v = new ValidPalindrome();
		
		String str = "A man, \na plan, a canal: \nPanama";
		
		System.out.println("Original String:" + str);
		
		String[] lines = v.breakLines(str);
		
		Arrays.stream(lines).forEach(System.out::println);

		String[] words = v.breakLineToWords(str);
		
		Arrays.stream(words).forEach(System.out::println);
		
		System.out.println(v.isValindrome(str));
	}

}
