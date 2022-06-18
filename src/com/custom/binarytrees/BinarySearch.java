package com.custom.binarytrees;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println();
		
		Integer[] inputArray = { 1,2,5,66,99,3,4,212,66,90,56,66,95};
		Arrays.sort(inputArray);
		
		//  12 5 3 4 66 66 90 56 95 
	//	Stream.of(inputArray).forEach(i->System.out.print( i+ " "));
		

		System.out.println(Arrays.binarySearch(inputArray, 99) + "   results");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		
		// 0 1 2 3 4 5 56 66 66 90 95 99 212

		System.out.println(inputArray.length);
		System.out.println((new BinarySearch()).binarySearchMethod(inputArray, 0,0,12));

		// Test with while loop as well
		

		
	}

	public int binarySearchMethod(Integer[] inputArray, int findingOutElement,int startIndex,int endIndex)
	{
		int mid=startIndex+ (endIndex-startIndex)/2;
		/*
		 * if(endIndex==startIndex) { return
		 * inputArray[endIndex]==findingOutElement?findingOutElement:-1; }
		 */
		if(endIndex>=startIndex)
		{
		if(inputArray[mid]==findingOutElement)
		{
			return mid;
		}
		if(inputArray[mid]>findingOutElement)
		{
			System.out.println("GREATER THAN CONDITION  " +findingOutElement+ "  "+startIndex+ "  "+(mid-1));
			return binarySearchMethod(inputArray,findingOutElement,startIndex,mid-1);
		}
		if(inputArray[mid]<findingOutElement)
		{
			System.out.println("LESS THAN CONDITION  " +findingOutElement+ "  "+endIndex+ "  "+(mid+1));
			return binarySearchMethod(inputArray,findingOutElement,mid+1,endIndex);
		}
		}
		return -1;
	}
}
