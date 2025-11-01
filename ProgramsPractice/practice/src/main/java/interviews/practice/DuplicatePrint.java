package interviews.practice;

import java.util.*;

public class DuplicatePrint {
	public static void main(String[] args) {
		// Printing duplicate elements only

		// Given
		int a[] = { 12, 2, 4, 12, 55, 12, 5, 5, 1 };
		HashMap<Integer, Integer> elements = new HashMap<>();
		for (int n : a) {
			if (elements.containsKey(n)) {
				elements.put(n, elements.get(n) + 1);
			} else {
				elements.put(n, 1);
			}
		}
		//Printing elements with their occurences
		System.out.println(elements);
		
		//Printing duplicate elements
		for(Map.Entry <Integer, Integer> display:elements.entrySet()) {
			if(display.getValue()>1) {
				System.out.println(display.getKey());
			}
		}
	}
}
