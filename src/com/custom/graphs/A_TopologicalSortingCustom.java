package com.custom.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class A_TopologicalSortingCustom {

	public static void main(String[] args) {
		
		
		TopSort topSort = new TopSort();

		topSort.add(5, 2);
		topSort.add(5, 0);
		topSort.add(4, 0);
		topSort.add(4, 1);
		topSort.add(2, 3);
		topSort.add(3, 1); // results - [4, 5, 0, 2, 3, 1]

		topSort.public_SortMethod();

		System.out.println("\n" + "Second TopSort List");
		
		TopSort topSort2 = new TopSort();
		/*
		 * TopologicalSort_other.add(1, 0); TopologicalSort_other.add(2, 3); TopologicalSort_other.add(3,
		 * 4);
		 */

		topSort2.add(1, 2);
		topSort2.add(1, 3);
		topSort2.add(3, 4);
		topSort2.add(3, 5);
		topSort2.add(2, 4);

		topSort2.public_SortMethod();


	}
}

class TopSort
{
	
	class InnerClass
	{
		boolean innerBoolean ;
		
		List<Integer> innerList ;

	}
	
	Map<Integer, List<Integer>> map = new HashMap();
	
	
	Stack<Integer> stack = new Stack();

	Map<Integer, InnerClass> booleanMap = new HashMap();

	List<Integer> actualList = new ArrayList();
	
	boolean finalBoolean;




	public void add(int i, int j) {
		if (map.get(i) == null) {
			List<Integer> l = new ArrayList<Integer>();
			l.add(j);
			map.put(i, l);
		} else {
			map.get(i).add(j);
		}
		
		if(map.get(j)==null)
		{
			List<Integer> listJ  = new ArrayList<Integer>();
			map.put(j, listJ);
		}
		
		if (!actualList.contains(i)) {
			actualList.add(i);
		}
		if (!actualList.contains(j)) {
			actualList.add(j);
		}
	}

	public void public_SortMethod() {
		
		
		actualList.forEach( i ->
		{
			map.get(i).forEach(j -> {
				
				if(booleanMap.get(j)!=null)
				{
					booleanMap.get(j).innerList.add(i);
				}
				else
				{
					InnerClass innerClass = new InnerClass();
					
					innerClass.innerList = new ArrayList();
					innerClass.innerList.add(i);
					innerClass.innerBoolean= false;
					booleanMap.put(j, innerClass);

				}
			});

		});
		
		actualList.forEach(i -> 
		{
			if(booleanMap.get(i)==null)
			{
				InnerClass innerClass = new InnerClass();
				
				innerClass.innerList = new ArrayList();
				innerClass.innerBoolean= false;
				booleanMap.put(i, innerClass);
			}
		
		});

		Iterator<Integer> iterator = actualList.iterator();
		int temp;
		while (iterator.hasNext()) {
			temp = iterator.next();
			if(booleanMap.get(temp) == null || booleanMap.get(temp).innerBoolean != true) {

			private_SortMethod(temp);

		}

		/*
		 * for (int i = 0; i < actualList.size(); i++) { if
		 * (booleanMap.get(actualList.get(i)) != true)
		 * private_SortMethod(actualList.get(i));
		 * 
		 * }
		 */

		while (stack.empty() == false)
			System.out.print(stack.pop() + "  ");
		}

	}

	public void private_SortMethod(int temp) {
		
		if(booleanMap.get(temp)==null )
		{
			InnerClass innerClass = new InnerClass();

			innerClass.innerBoolean= true;
			booleanMap.put(temp, innerClass);
			
		}
		
		else if(booleanMap.get(temp).innerList.isEmpty())
		{
			booleanMap.get(temp).innerBoolean= true;
		}


		List<Integer> innerList = map.get(temp);
		if (innerList != null) {
			for (int i = 0; i < innerList.size(); i++) {
				if (booleanMap.get(i) != null && booleanMap.get(i).innerBoolean != true) {
					if(booleanMap.get(i).innerList!=null && booleanMap.get(i).innerList.contains(temp))
					{
						booleanMap.get(i).innerList.remove(temp);
						private_SortMethod(innerList.get(i));

					}
					else
					{
						finalBoolean= false;
					}
				}
			}
		}
		
		
		if (!stack.contains(temp))
			stack.add(temp);


	}
	
	public void isTopologicalSortExist()
	{
		public_SortMethod();
		
		System.out.println(finalBoolean);
	}
	

}