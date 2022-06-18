package com.custom.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class A_TopologicalSort_other {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TopologicalSort_other TopologicalSort_other = new TopologicalSort_other();
		/*
		 * TopologicalSort_other.add(1, 0); TopologicalSort_other.add(2, 3); TopologicalSort_other.add(3,
		 * 4);
		 */

		TopologicalSort_other.add(5, 2);
		TopologicalSort_other.add(5, 0);
		TopologicalSort_other.add(4, 0);
		TopologicalSort_other.add(4, 1);
		TopologicalSort_other.add(2, 3);
		TopologicalSort_other.add(3, 1); // results - [4, 5, 0, 2, 3, 1]

		TopologicalSort_other.public_SortMethod();

		System.out.println("\n" + "Second TopSort List");
		
		TopologicalSort_other TopologicalSort_other2 = new TopologicalSort_other();
		/*
		 * TopologicalSort_other.add(1, 0); TopologicalSort_other.add(2, 3); TopologicalSort_other.add(3,
		 * 4);
		 */

		TopologicalSort_other2.add(1, 2);
		TopologicalSort_other2.add(1, 3);
		TopologicalSort_other2.add(3, 4);
		TopologicalSort_other2.add(3, 5);
		TopologicalSort_other2.add(2, 4);

		TopologicalSort_other2.public_SortMethod();
		
	}

}

class TopologicalSort_other {
	Map<Integer, List<Integer>> map = new HashMap();
	
	
	Stack<Integer> stack = new Stack();

	Map<Integer, Boolean> booleanMap = new HashMap();

	List<Integer> actualList = new ArrayList();

	// LinkedList<Integer> stack = new LinkedList();



	public void add(int i, int j) {
		if (map.get(i) == null) {
			List<Integer> l = new ArrayList<Integer>();
			l.add(j);
			map.put(i, l);
			booleanMap.put(i, false);
		} else {
			map.get(i).add(j);
		}
		
		if(map.get(j)==null)
		{
			List<Integer> listJ  = new ArrayList<Integer>();
			map.put(j, listJ);
			booleanMap.put(j, false);
		}
		
		if (!actualList.contains(i)) {
			actualList.add(i);
		}
		if (!actualList.contains(j)) {
			actualList.add(j);
		}
	}

	public void public_SortMethod() {

		Iterator<Integer> iterator = actualList.iterator();
		int temp;
		while (iterator.hasNext()) {
			temp = iterator.next();
			if(booleanMap.get(temp)!=true)
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

	public void private_SortMethod(int temp) {
		booleanMap.put(temp, true); 


		List<Integer> innerList = map.get(temp);
		if (innerList != null) {
			for (int i = 0; i < innerList.size(); i++) {
				if (booleanMap.get(innerList.get(i)) != true) {
					private_SortMethod(innerList.get(i));
				}
			}
		}
		
		
		if (!stack.contains(temp))
			stack.add(temp);


	}

}

// 5 4 2 3 1 0 // [1, 3, 2, 0, 5, 4] // [1, 3, 2, 0, 5, 4] // [1, 3, 2, 0, 5,4]



//    -> 2  0  1  3  
//    -> Second TopSort List
//    -> 2  3  4  5  
