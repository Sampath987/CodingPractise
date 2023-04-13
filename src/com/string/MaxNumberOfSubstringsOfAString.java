package com.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MaxNumberOfSubstringsOfAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		MaxNumberOfSubstringsOfAString maxNumberOfSubstringsOfAString = new MaxNumberOfSubstringsOfAString();
		Set<String> setOfSubStrings1 = maxNumberOfSubstringsOfAString.findMaxSubstringCount("Sampath");
		Set<String> setOfSubStrings2 = maxNumberOfSubstringsOfAString.findMaxSubstringCount("Sandeep");
		Set<String> setOfSubStrings3 = maxNumberOfSubstringsOfAString.findMaxSubstringCount("Santhos");
		
		Map<String, Integer> map = new TreeMap();
		
		setOfSubStrings1.stream().forEach(i -> 
		{
			if(!map.keySet().contains(i))
			{
				map.put(i, 1);
			}
			else
			{
				map.put(i, map.get(i) + 1);

			}
		}
		);
		
		  setOfSubStrings2.stream().forEach(i -> { if(!map.keySet().contains(i)) {
		  map.put(i, 1); } else { map.put(i, map.get(i) + 1);
		  
		  } } ); setOfSubStrings3.stream().forEach(i -> { if(!map.keySet().contains(i))
		  { map.put(i, 1); } else { map.put(i, map.get(i) + 1);
		  
		  } } );
		 
		
		
	//	map.keySet().stream().toLi
		  
		  List<String> list2 = new ArrayList();

		  map.entrySet().stream().sequential()
				  .forEach(i -> 
				  {
					  System.out.println(i.getKey() + " " + i.getValue());
		  
				  });
		  
		  map.entrySet().stream().sequential()
		  .filter(i -> i.getValue()>1)
		  .forEach(i -> 
		  {
			  list2.add(i.getKey());
			  System.out.println(i.getKey() + " " + i.getValue());
  
		  });
		  
		  
		  list2.stream().sequential().forEach(i -> System.out.print(i + " "));
		  
		  Collections.sort(list2, (s1,s2) -> s1.length()-s2.length());

	}


	public Set<String> findMaxSubstringCount(String s) {
		int length = s.length();
		int tempvariable = 0;

		Set<String> setOfSubStrings = new TreeSet();


		
		for (int i = 0; i < length; i++) {
			for (int j = i; j < length; j++) {
				setOfSubStrings.add(s.substring(i, j+1));
			}
		}
				
		

		return setOfSubStrings;

	}

}
