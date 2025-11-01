package interviews.practice;

import java.util.*;
import java.util.stream.Collectors;

public class UniqueStringElements {
	public static void main(String[] args) {
		String name = "Vishesh";
		
		//Method1
		HashSet<Character> uniqueElements = new HashSet<>();
		char nameArray[] = name.toCharArray();
		for (char word : nameArray) {
			uniqueElements.add(word);
		}
		System.out.println(uniqueElements);
		
		//Method 2
		String unique = Arrays.stream(name.split("")).distinct().collect(Collectors.joining());
		System.out.println(unique);
		
		//Method3  ---> print elements whose count is 1
		HashMap<Character,Integer> unique1 = new HashMap<>();
		for(char n:name.toCharArray()) {
			if(unique1.containsKey(n)) {
				unique1.put(n, unique1.get(n)+1);
			}
			else {
				unique1.put(n, 1);
			}
		}
		for(Map.Entry<Character, Integer> count:unique1.entrySet()) {
			if(count.getValue()==1) {
				System.out.print(count.getKey());
			}
		}
		

	}	
}
