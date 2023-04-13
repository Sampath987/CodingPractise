package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "yes";
		String s2 = "yes";
		System.out.println(s1==s2);
		
		SelectionSort selectionSort = new SelectionSort();
		selectionSort.sort();

	}
	
	int[] a = new int[]{4,2,44,33,22,100,101,102,103,105,1,5,3,99,23,103,500,200,11,88,77,66,55};


	int temp=0;
	int minIndex=0;
	public void sort()
	{
		
		
		Arrays.stream(a).forEach(i -> System.out.print(i + " "));
		
		for(int i=0; i<a.length ; i++)
		{
			minIndex = i;
			for (int j = i+1; j < a.length; j++) {
				if(a[minIndex]>a[j])
				{
					minIndex = j;
				}

			}
			temp = a[i];
			a[i]=a[minIndex];
			a[minIndex]= temp;
		}
		
		System.out.println("\n" + "After sorting");
		
		Arrays.stream(a).forEach(i -> System.out.print(i + " "));
	}
}
