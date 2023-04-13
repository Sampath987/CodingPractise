package com.custom.graphs.secondtime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopologicalSortExist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
// int[][] arr = {{1,0},{0,2},{2,1}};  // {parent, child}
int[][] arr = {{1,4},{2,4},{3,1},{3,2}} ;

		
TopologicalSortExist obj = new TopologicalSortExist();
		
		
		System.out.println("Is Topology possible: " + obj.isTopologyPossible(arr));
		


	}

public boolean isTopologyPossible(int[][] arr)
{
	boolean topologyPossible = true;
	for(int[] outerArr: arr)
	{
		if(!ListOfCourses.contains(outerArr[0]))
			ListOfCourses.add(outerArr[0]);
		if(!ListOfCourses.contains(outerArr[1]))
			ListOfCourses.add(outerArr[1]);
	}
	for(int course: ListOfCourses)
	{
		NodeTopo n = new NodeTopo();
		n.data = course;
		n.listOfParents = new ArrayList();
		n.listOfChild = new ArrayList();
		map.put(course, n);
		
	}
	for(int[] outerArr: arr)
	{
		map.get(outerArr[1]).listOfParents.add(map.get(outerArr[0]));
		map.get(outerArr[0]).listOfChild.add(map.get(outerArr[1]));

	}
	for(int i=0;i<ListOfCourses.size();i++)
	{
		NodeTopo tempNode = map.get(ListOfCourses.get(i));
		topologyPossible = privateTopologicalMethod(arr, null,tempNode);
		if(!topologyPossible)
		{
			break;
		}
	}
	
	return topologyPossible;
}

private boolean privateTopologicalMethod(int[][] arr, NodeTopo parent, NodeTopo child) {
	// TODO Auto-generated method stub
	if(parent!=null && !child.isVisited)
	{
		child.isVisited=true;
		map.get(child.data).listOfParents.add(parent);
	}
	else if(parent==null && !child.isVisited)
	{
		child.isVisited=true;
	}

	else if(child.isVisited && !map.get(child.data).listOfParents.contains(parent))
	{
		map.get(child.data).listOfParents.add(parent);
	}
	else if(child.isVisited && map.get(child.data).listOfParents.contains(parent))
	{
		return false;
	}
	List<NodeTopo> childNodeTopo = child.listOfChild;
	// if(childNodeTopo.size()==0)
	label:
	for(int i=0;i<childNodeTopo.size();i++)
	{
		boolean innerBoolean = privateTopologicalMethod(arr,child,childNodeTopo.get(i));
		if(!innerBoolean)
			return false;
	}


	
	
	return true;
}

List<Integer> ListOfCourses = new ArrayList();
Map<Integer, NodeTopo> map = new HashMap();

}
class NodeTopo
{
	int data;
	boolean isVisited;
	List<NodeTopo> listOfParents;
	List<NodeTopo> listOfChild;

}
