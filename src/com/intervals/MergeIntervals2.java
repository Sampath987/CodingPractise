package com.intervals;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		
		System.out.println(Math.max(5, Integer.parseInt("5")));
	//	 int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
		 
		 int[][] intervals = new int[][]{{1,4},{0,4}};

		 MergeIntervals2 mergeIntervals = new MergeIntervals2();
		 
		 int[][] arrayAfter = mergeIntervals.merge(intervals);
		 
			System.out.println("arrayAfter.length  --- " + arrayAfter.length);
			
			 Arrays.stream(arrayAfter).forEach(i -> System.out.println(Arrays.toString(i)));

	}
	
	
/*	public int[][] merge(int[][] intervals)
	{
		
		Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));
		
		LinkedList<int[]> list = new LinkedList();
		
		for(int[] idividualInterval:intervals)
		{
			if(list.isEmpty() || list.getLast()[1] < idividualInterval[0])
			{
				list.add(idividualInterval);
			}
			else
			{
				list.getLast()[1] = Math.max(list.getLast()[1], idividualInterval[1]);
			}
			
		}
		return list.toArray(new int[list.size()][]);
	}
*/
	
	
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
