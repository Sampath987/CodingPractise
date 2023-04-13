package com.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class IsTopologicalUsingCoursePrerequisite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		
		int[][] arr = {{1,0},{0,2},{2,1}};
		
		IsTopologicalUsingCoursePrerequisite obj = new IsTopologicalUsingCoursePrerequisite();
		
		System.out.println(" ---" + obj.canFinish(3,arr));

	}
	 Map<Integer, List<Integer>> prerequisireMap = new HashMap();
     Map<Integer, List<Integer>> succesorMap = new HashMap();
     Set<Integer> setOfCourses = new HashSet();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	
       
    	for(int[] firstArray: prerequisites)
        {

                setOfCourses.add(firstArray[0]);
                setOfCourses.add(firstArray[1]);

				/*
				 * if(!prerequisireMap.containsKey(firstArray[0])) { List<Integer> list = new
				 * ArrayList(); list.add(firstArray[1]); prerequisireMap.put(firstArray[0],
				 * list); } else { prerequisireMap.get(firstArray[0]).add(firstArray[1]); }
				 */
                if(!succesorMap.containsKey(firstArray[1]))
                {
                    List<Integer> listSu = new ArrayList();
                    listSu.add(firstArray[0]);
                    succesorMap.put(firstArray[1], listSu);
                }
                else
                {
                	succesorMap.get(firstArray[1]).add(firstArray[0]);
                }

        }
    	
    	List<Integer> listOfCourses = new ArrayList(setOfCourses);
    	listOfCourses.stream()
    	.filter(i -> !succesorMap.containsKey(i))
    	.forEach(i -> succesorMap.put(i, new ArrayList<Integer>()));
    	
    	for(int course: listOfCourses)
    	{
    		List<Integer> listOfSuccessors = succesorMap.get(course);
    		
        	for(int sucCourse: listOfSuccessors)
        	{
        		if(succesorMap.get(sucCourse).contains(course))
        			return false;
        	}

    	}
    	
    	
    	return true;
    }

}
