package com.java8.feauters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.function.Consumer;


public class ConsumerInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list = new ArrayList(Arrays.asList("String2", "String1", "String3"));
		
		Consumer<List<String>> consumer = (listParamer) -> {
			
			listParamer.forEach(string -> string.concat("___Concating"));
			
		};
		consumer.accept(list);
		list.stream().forEach(System.out::println);
	}

}
