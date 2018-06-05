package string;

public class NeedleInHaystack {

	/*
	 * Implement strstr(). Returns the index of the first occurrence of needle in
	 * haystack, or –1 if needle is not part of haystack.
	 */

	/*public int strStr(String haystack, String needle) {
		System.out.println("haystack:" + haystack);
		System.out.println("needle:" + needle);
		System.out.println("haystack.length():" + haystack.length());
		System.out.println("needle.length():" + needle.length());
		for (int i = 0;; i++) {
			System.out.println("i:" + i);
			for (int j = 0;; j++) {
				System.out.println("j:" + j);
				if (j == needle.length())
					return i;
				if (i + j == haystack.length())
					return -1;
				if (needle.charAt(j) != haystack.charAt(i + j)) {
					System.out.println("needle.charAt(j):" + needle.charAt(j));
					System.out.println("haystack.charAt(i + j):" + haystack.charAt(i + j));
					break;
				}
			}
			System.out.println("******************");
		}
	}*/
	
	public int strStr(String haystack, String needle) {
		if(needle == null || needle.isEmpty())
			return 0;
		
		if(haystack == null || haystack.isEmpty() || haystack.length() < needle.length())
			return -1;
		
		for(int i=0; i<haystack.length(); i++) {			
			for(int j=0; j<needle.length(); j++) {
				
				if(haystack.charAt(i+j) != needle.charAt(j))
					break;
				
				//the last letter in needle pass verification, return index i
				if(j == needle.length()-1)
					return i;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		NeedleInHaystack v = new NeedleInHaystack();

		String haystack = "mississippi";
		String needle = "sip";
		
		int index = v.strStr(haystack, needle);
		
		System.out.println(index);
	}

}
