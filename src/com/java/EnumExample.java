package com.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class EnumExample {
	
	static public BiFunction<Integer, Integer, Integer> biFunction = (a,b) -> a*b;


	public static void main(String[] args) {
		
		
		System.out.println("5 " + (int)5);
		
		
		int k=153;
		int beforeK = k;
		int remainder =0;
		int finalSum=0;
		while(k>=1)
		{
			remainder = k%10;
			k=k/10;
			finalSum = finalSum + (remainder*remainder*remainder);
		}
		boolean isIt = (finalSum==beforeK)?true:false;
		System.out.println("finalSum "+ finalSum +" " +isIt);
		
	    int result = biFunction.apply(5, 10);
	    System.out.println(result);

		Arrays.stream(StatusCode.values()).forEach(System.out::print);
		
		Integer[] n = new Integer[] {1, 3, 6, 9};
		
	//	Arrays.stream(n).sorted().forEach(System.out::print);
		
		Arrays.sort(n, Collections.reverseOrder());
		
		IntStream.range(1,10).forEach(System.out::print);
		

		System.out.println();
		System.out.println("\n" + StatusCode.staus_code_500.getIsItStatusCode());


	

	}
	
	
}

enum StatusCode
{
	 staus_code_404("404"),
	 staus_code_500("5xx"),
	 staus_code_504("504"),
	 staus_code_403("403");
	
	
	private String isItStatusCode;
	
	public String getIsItStatusCode() {
		return isItStatusCode;
	}



	StatusCode(String isItStatusCode)
	{
		this.isItStatusCode = isItStatusCode;
	}
	
	
	
	public StatusCode turnRight() {
	    int newOrdinal = (this.ordinal() + 1) % values().length;
	    return values()[newOrdinal];
	  }

}

