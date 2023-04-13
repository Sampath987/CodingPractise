package com.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
		 
		 int[][] intervals2 = new int[][] {{1,4},{1,4}};
		 
		 Arrays.stream(intervals2).forEach(i -> System.out.println(Arrays.toString(i)));
		
		MergeIntervals mergeIntervals = new MergeIntervals();
		
		
		int[][] arrayAfter = mergeIntervals.merge(intervals2);
		
		System.out.println("arrayAfter.length  --- " + arrayAfter.length);
		
		 Arrays.stream(arrayAfter).forEach(i -> System.out.println(Arrays.toString(i)));

		
		
				
	}
	
	int i =0;
	int k =0;
	int[][] newArray = new int[5][2];
	
    public int[][] merge(int[][] intervals) {
    	List<Integer> lstart = new ArrayList();
    	Map<Integer,Integer> lend = new HashMap();

    			Arrays.stream(intervals).forEach(i -> 
    			{
    				if(lstart.contains(i[0]))
    				{
    					if((null!=lend.get(i[0])) 
    						&& (lend.get(i[0]) < i[1]))
	    				{
	    					lend.put(i[0], i[1]);
	    				}
    				}else
    				{
    					lstart.add(i[0]);
    					lend.put(i[0], i[1]);
    				}
    			});
    			
    			Collections.sort(lstart);
    			
    			return privateMerge(lstart,lend,intervals);
    			
    }
    	
    public int[][] privateMerge(List<Integer> lstart, Map<Integer,Integer> lend, int[][] intervals)
    {
    while(i < lstart.size()-1 && lend.get(lstart.get(i))
    		 < lstart.get(i+1))
    	{
    		
    		newArray[k][0]= lstart.get(i);
    		newArray[k][1]= lend.get(lstart.get(i));
    		i++;k++;

    	}
    	if(i < lstart.size()-1 && lend.get(lstart.get(i)) <= lend.get(lstart.get(i+1)))
    	{
    		lend.put(lstart.get(i), lend.get(lstart.get(i+1)));
    		lend.remove(lstart.get(i+1));
    		lstart.remove(i+1);
    		privateMerge(lstart,lend,intervals);
    	}
    	else if(i < lstart.size()-1 && lend.get(lstart.get(i)) > lend.get(lstart.get(i+1)))
    	{
			/*
			 * intervals[i+1][0]= intervals[i][0]; intervals[i+1][1]= intervals[i][1];
			 * i=i+1;
			 */
    		lend.remove(lstart.get(i+1));
    		lstart.remove(i+1);
    		privateMerge(lstart,lend,intervals);
    	}
    	else if(i == lstart.size()-1)
    	{
    		newArray[k][0] = lstart.get(i); // [i][0];
    		newArray[k][1] = lend.get(lstart.get(i));			// intervals[i][1];
    		i++;k++;
    	}    	
    	return Arrays.copyOf(newArray, k);
	//	return intervals;
    
    }

}
