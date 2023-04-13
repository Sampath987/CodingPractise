package com.custom.sa.lcp.lcs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LCP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4,10,5,2,5);
		List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4,10,5,2,5);


		Map<Integer, List<Integer>> groupingBy = numbers.stream()
		                        .collect(Collectors.groupingBy(i -> i*10));
		System.out.println("groupingBy : "+ groupingBy);
		
		System.out.println("averagingDouble: "+ 
		numbers.stream().collect(Collectors.averagingInt(i -> i*2)));


		Map<Boolean, List<Integer>> partitionedPrime = 
				numbers2.stream()
		        .collect(Collectors.partitioningBy(n -> 
		        {
		        	for(int i=2; i<=n/2; i++)
		        	{
		        		if(n%i==0)
		        		{
		        			return false;
		        		}
		        	}
		        	
		        	return true;
		        	
		        }));
		
		System.out.println("partitionedPrime: " + partitionedPrime);
		
		List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
		
		
		Map<String, String> nameLengths = 
				names
				.stream()
				.collect(Collectors.toMap(key-> key.concat("Sam"), key -> key.concat("value")));
				
		System.out.println("String joining() from Collectors: " +names
				.stream()
				.collect(Collectors.joining("--", "UU", "YY")));
		
		
		
		
		System.out.println("ACTUAL PROGRAM IS HERE ONWARDS");
		
		String s1 = "Sampath2";
		String s2 = "Sampath1";
		String s3 = "Sampa3th";

		ArrayList<String> list = new ArrayList<String>(Arrays.asList(s1, s2, s3));

		Map<String, List<String>> subStringMap = new HashMap();

		list.stream().forEach(stringElement -> {
			for (int i = 0; i < stringElement.length(); i++) {
				for (int j = i; j < stringElement.length(); j++) {
					if (i + j < stringElement.length()) {
						String subStringOfElement = stringElement.substring(i, stringElement.length() - j);
						

						if (subStringMap.containsKey(subStringOfElement)) {
							if (!subStringMap.get(subStringOfElement).contains(stringElement)) {
								subStringMap.get(subStringOfElement).add(stringElement);
							}
						} else {
							List<String> innerList = new ArrayList(Arrays.asList(stringElement));
							subStringMap.put(subStringOfElement, innerList);
						}
					}
				}
			}
		});
		
		
		System.out.println(subStringMap.entrySet().stream()
				.filter(predicateVariable -> predicateVariable.getValue().size()==3)
				.sorted((entry1, entry2) -> entry2.getKey().length() - entry1.getKey().length())
				.findFirst().get().getKey());

		
		/*
		 * Map<Object, List<String>> innerMap = subStringMap.entrySet().stream()
		 * .filter(predicateVariable -> predicateVariable.getValue().size()==3)
		 * .map(Map.Entry::getKey) .collect(Collectors.groupingBy(key -> key.length()));
		 * 
		 * innerMap.entrySet() .forEach(entry -> System.out.println("entry :" +
		 * entry.getKey() + entry.getValue()));
		 * 
		 * List<Integer> listofKeys = new ArrayList(innerMap.keySet());
		 * Collections.sort(listofKeys,Collections.reverseOrder());
		 * System.out.println("finalString :" + innerMap.get(listofKeys.get(0)));
		 */
        
        

	}

}
