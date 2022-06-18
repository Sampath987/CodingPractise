package com.custom.graphs.bridgesAndArticulationPoints;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FindNumberOfBridges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        System.out.println("Bridges in first graph ");
        CustomBridge g1 = new CustomBridge();
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        g1.bridge();
		
	}

}

class CustomBridge
{
	Map<Integer, List<Integer>> graph = new HashMap<>();
	List<Integer> bridges = new ArrayList<Integer>();
	Map<Integer, Boolean> isVisited = new HashMap<>();
	Map<Integer, Integer> idMap = new HashMap<>();
	Map<Integer, Integer> lowMap = new HashMap<>();


	
	int id=-1;

	
	public CustomBridge()
	{
		
	}

	public void bridge()
	{
		Iterator<Integer> iterator = graph.keySet().iterator();
		
		while(iterator.hasNext())
		{
			DFS(iterator.next());
		}

	}
	public void DFS(int i)
	{
		id =id+1;
		idMap.put(i, id);
		lowMap.put(i, id);
		
		isVisited.put(i, true);
		List<Integer> innerList = graph.get(i);
		
		for(int k=0; k<innerList.size();k++)
		{
			if(isVisited.get(innerList.get(k))!=true)
			{
				DFS(innerList.get(k));
			}
			lowMap.put(null, null)= min(lowMap.get(innerList.get(k)), lowMap.get(innerList)
		}
	}
	
	public void addEdge(int i, int j)
	{
		if(graph.get(i)!=null)
		{
			graph.get(i).add(j);
			if(graph.get(j)==null)
			{
				
				List<Integer> li = new ArrayList<Integer>();
				graph.put(j, li);
			}
			
			/*
			 * if(graph.get(j)!=null) { graph.get(j).add(i); } else { List<Integer> li = new
			 * ArrayList<Integer>(); li.add(i); graph.put(j, li); }
			 */
		}
		else
		{
			List<Integer> lj = new ArrayList<Integer>();
			lj.add(j);
			graph.put(i, lj);
			
			if(graph.get(j)==null)
			{
				List<Integer> li = new ArrayList<Integer>();
				graph.put(j, li);
			}
		}
	}
	
}
