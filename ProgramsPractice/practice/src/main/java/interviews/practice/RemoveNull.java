package interviews.practice;

import java.util.*;

public class RemoveNull {
	public static void main(String[] args) {

		Map<String, String> map = new HashMap<>();

		// Adding some key-value pairs
		map.put("A", "Apple");
		map.put("B", "Banana");

		// Adding a null key
		map.put(null, "NullKeyValue");

		// Adding a null value
		map.put("C", null);

		// Another null key with different value (null keys overwrite previous ones)
		map.put(null, "OverwrittenNullKey");

		// Another null value
		map.put("D", null);
		System.out.println(map);
		
		//removing null keys and values method 1
		HashMap<String,String>newMap = new HashMap<>();
		for(Map.Entry<String, String> keys: map.entrySet()) {
			if(keys.getKey()!=null) {
				newMap.put(keys.getKey(), keys.getValue());
			}
		}
		System.out.println(newMap);
		HashMap<String,String>newMapValue = new HashMap<>();
		for(Map.Entry<String, String> keys: map.entrySet()) {
			if(keys.getValue()!=null) {
				newMapValue.put(keys.getKey(), keys.getValue());
			}
		}
		System.out.println(newMapValue);
		
		
		//removing null keys and values method 2
		map.remove(null);	//remove null keys
		System.out.println(map);
		
		map.entrySet().removeIf(value->value.getValue()==null);
		System.out.println(map);
		
		map.values().removeIf(value->value==null);
		System.out.println(map);
		
		
		
	}
}