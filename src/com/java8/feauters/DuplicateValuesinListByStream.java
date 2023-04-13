package com.java8.feauters;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateValuesinListByStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 3);
		
		
		
		
		Object[] k = numbers.toArray();
		
		Arrays.stream(k)
				.collect(Collectors.groupingBy(i -> i))
				.entrySet()
				.stream()
				.filter(i -> i.getValue().size()>1)
				.forEach(i -> System.out.println("the value of" + i + "is : " + i.getValue().size()));
			
		

        List<Integer> duplicates = numbers.stream()
            .collect(Collectors.groupingBy(i -> i))
            .entrySet().stream()
            .filter(e -> e.getValue().size() > 1)
            .map(e -> e.getKey())
            .collect(Collectors.toList());

        System.out.println(duplicates);
        
        
        List<String> names = Arrays.asList("John", "Mary", "Peter", "Jane", "David", "Bob");

        Map<Character, List<String>> groups = names.stream()
            .collect(Collectors.groupingBy(name -> name.charAt(0)));

        System.out.println(groups);
        
        
        
        numbers.stream()
        .collect(Collectors.groupingBy(i -> i))
        .entrySet()
        .stream()
        .collect(Collectors.toList()).forEach(i -> System.out.println("i " + i));
   //     .filter(i -> i.getValue().size()>1)
   //     .forEach(i -> System.out.println(i.getKey() + " " + i.getValue()));
        
	}

}





