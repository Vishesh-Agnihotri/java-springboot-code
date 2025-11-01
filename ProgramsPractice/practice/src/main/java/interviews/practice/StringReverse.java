package interviews.practice;

import java.util.*;

public class StringReverse {
	public static void main(String[]args) {
		String sentence = "How are you";

		
		//Method1
		//Reversing as it is
		List<String>splitSentence = Arrays.asList(sentence.split(" "));
		Collections.reverse(splitSentence);
		System.out.println(String.join(" ", splitSentence));
		
		//Reversing each word
		List<String>splitEach = Arrays.asList(sentence.split(""));
		Collections.reverse(splitEach);
		System.out.println(String.join("", splitEach));
		
		
		//Mehthod2
		String name="vishesh";
		char n[]=name.toCharArray();
		for(int i=name.length()-1;i>=0;i--) {
			System.out.print(n[i]);
		}
	}
}
