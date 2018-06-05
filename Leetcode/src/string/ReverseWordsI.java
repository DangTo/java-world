package string;

public class ReverseWordsI {

	/*
	 * Given an input string s, reverse the string word by word. For example, given
	 * s = "the sky is blue", return "blue is sky the".
	 */
	
	public String reverseWord(String oriStr) {
		StringBuilder reversedStr = new StringBuilder();
		
		int j = oriStr.length();
		for(int i=oriStr.length()-1; i>=0; i--) {
			System.out.println("i:" + i);
			System.out.println("j:" + j);
			System.out.println(reversedStr);
			if(i==0 || oriStr.charAt(i-1) == ' ') {
				reversedStr.append(oriStr.substring(i, j) + ' ');
				j = i-1;
			}
		}
		
		return reversedStr.toString();
	}
	
	public static void main(String[] args) {
		ReverseWordsI word = new ReverseWordsI();
		
		String oriStr = "I am going to    reverse this sentence";
		
		System.out.println(word.reverseWord(oriStr));
	}

}
