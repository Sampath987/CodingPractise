package com.custom.graphs.secondtime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class isTopologicalSortExist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] arr = {{1,0},{0,2},{2,1}};  // {parent, child}
		
		isTopologicalSortExist obj = new isTopologicalSortExist();
		
		
		System.out.println("Is Topology possible: " + obj.isTopologyPossible(arr));
		




	}
	
	
	Map<Integer, Node> map = new HashMap();
	
	public boolean isTopologyPossible(int[][] arr)
	{
		List<Integer> ListOfCourses = new ArrayList();
		for(int[] outerArr: arr)
		{
			if(!ListOfCourses.contains(outerArr[0]))
				ListOfCourses.add(outerArr[0]);
			if(!ListOfCourses.contains(outerArr[1]))
				ListOfCourses.add(outerArr[1]);
		}
		for(int course: ListOfCourses)
		{
			Node n = new Node();
			n.data = course;
			n.prereqsMap = new HashMap();
			map.put(course, n);
		}
		for(int[] outerArr: arr)
		{
			map.get(outerArr[1]).prereqsMap.put(outerArr[0], false);
			
			map.get(outerArr[1]).next = map.get(outerArr[0]);
		}
		
		Node temp = map.get(arr[0][1]);
		
		while(temp.next!=null)
		{
			
		}

		
		int i =0;
		int temp = arr[i][1];
		while(temp>0)
		{
			if(map.containsKey(arr[i][1]))
			{
				if(map.get(arr[i][1]).contains(arr[i][0]))
				{
					return false;
				}
				else
				{
					map.get(arr[i][1]).add(arr[i][0]);
				}
			}
			else
			{
				List<Integer> innerList = new ArrayList();
				innerList.add(arr[i][0]);
				map.put(arr[i][1], innerList);
			}
			
			

		}
		
		
		return true;
	}

}

class Node
{
	int data;
	Map<Integer, Boolean> prereqsMap  ;
	Node next;
}


