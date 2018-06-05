package string;

public class ReverseWordsII {

	public String reverseWords(String words) {
		if (words == null || words.isEmpty())
			return null;

		char[] letterArray = words.toCharArray();

		// reverse the whole string first time
		reverseWord(letterArray, 0, letterArray.length);

		System.out.println("Done 1st step:" + new String(letterArray));

		int j = 0;
		for (int i = 0; i < letterArray.length; i++) {
			if (letterArray[i] == ' ') {
				reverseWord(letterArray, j, i);
				j = i + 1;
			}
		}

		return new String(letterArray);
	}

	public void reverseWord(char[] array, int start, int end) {
		for (int i = 0; i < (end - start) / 2; i++) {
			char temp = array[start+i];
			array[start+i] = array[end - 1 - i];
			array[end - 1 - i] = temp;
		}
	}

	public static void main(String[] args) {
		ReverseWordsII word = new ReverseWordsII();

		String oriStr = "I am going to reverse this sentence";

		System.out.println("Final:" + word.reverseWords(oriStr));
	}

}
