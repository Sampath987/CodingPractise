package com.custom.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// Not A Topological order

public class A_BFS_ShartestPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		FindShartestPathUsingDFS findTopologicalSort_ShartestPath = new FindShartestPathUsingDFS();
		//findTopologicalSort_ShartestPath.addVerticesToList(0, 0, 0);
		
        findTopologicalSort_ShartestPath.addVerticesToList(10, 1, 5);
        findTopologicalSort_ShartestPath.addVerticesToList(10, 2, 3);
        findTopologicalSort_ShartestPath.addVerticesToList(1, 3, 6);
        findTopologicalSort_ShartestPath.addVerticesToList(1, 2, 2);
        findTopologicalSort_ShartestPath.addVerticesToList(2, 4, 4);
        findTopologicalSort_ShartestPath.addVerticesToList(2, 5, 2);
        findTopologicalSort_ShartestPath.addVerticesToList(2, 3, 7);
        findTopologicalSort_ShartestPath.addVerticesToList(3, 4, -1);
        findTopologicalSort_ShartestPath.addVerticesToList(4, 5, -2);
        
        
        findTopologicalSort_ShartestPath.pub_shortestPathMethod(1);
	}

}


class FindTopologicalSort_ShartestPath
{
	Map<Integer, Integer> distMap = new HashMap<Integer, Integer>();
	
	Queue<Integer> queue = new LinkedList<Integer>();
	
	Map<Integer, Node> outerNodesMap = new HashMap<Integer, Node>();

	
	
	
	
	public void addVerticesToList(int l, int m, int o)
	{
		if(!outerNodesMap.containsKey(l))
		{
			Node temp = new Node();
			temp.data = l;
			temp.map.put(m, o);
			outerNodesMap.put(l, temp);
		}
		else
		{
			outerNodesMap.get(l).map.put(m, o);

			/*
			 * if(!outerNodesMap.get(l).map.containsKey(m)) {
			 * outerNodesMap.get(l).map.put(m, 0); }
			 */
		}
	}
	public void pub_shortestPathMethod(int k)
	{
		queue.add(k);
		distMap.put(k, 0);
		while(!queue.isEmpty())
		{
			int temp = queue.poll();
			System.out.println("polling element " + temp);
			if(outerNodesMap.get(temp)!=null)
			{
				outerNodesMap.get(temp).map.keySet().stream().forEach(i ->
				{
					queue.add(i);
					if(distMap.get(i)!=null)
					{
						if(distMap.get(i)> distMap.get(temp) + outerNodesMap.get(temp).map.get(i))
						{
							distMap.put(i, distMap.get(temp) + outerNodesMap.get(temp).map.get(i));
						}
						
						System.out.println("from --- if(distMap.get(i)!=null)" + temp + " -- " + i);
					}
					else
					{
						distMap.put(i, distMap.get(temp) + outerNodesMap.get(temp).map.get(i));
						System.out.println("from --- else" + temp + " -- " + i);
	
					}
				});
			}
		}
		
		distMap.entrySet().forEach(i -> System.out.println(i.getKey() + " "+ i.getValue()));
		
	}
}

class Node
{
	public Node()
	{
		
	}
	int data ;
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
}