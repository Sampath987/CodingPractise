package Apex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FoodDistributionFP {
	 
	 


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//	Integer[] arr =  new Integer[]{5,3,1,2,1}; 0
	//	Integer[] arr =  new Integer[]{4, 5, 2, 3, 1, 0}; // 2
	//	Integer[] arr =  new Integer[]{5, 2, 3, 4, 5}; // 1
	//	Integer[] arr =  new Integer[]{3, 2, 1, 0, 4, 1, 0}; // 4
		Integer[] arr =  new Integer[]{3, 2, 1, 0, 4, 1, 0}; // 4 2 1 1 0 0 -> 3 2 1 1 0 0 -> 2 2 1 1 -> 
//		Integer[] arr =  new Integer[]{5, 2, 3, 4, 5}; // 1  -> 3 3 2 2 

		
		FoodDistributionFP foodDistributionFP = new FoodDistributionFP();
		System.out.println(foodDistributionFP.minDifference(Arrays.copyOfRange(arr, 1,arr.length),arr[0])) ;
				
		// 3 2 1 1 ->  2 2 1 1 (1) -> 2 1 1 1 (1) -> 1 1 1 1 (0)
		// 1 0 0 0 = 1 1 1 1
		

	}

	int min = 5;
	public int minDifference(Integer[] arr, int foodQuantity)
	{
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		for(int i=0; i<foodQuantity; i++)
		{
			for(int j=0; j<arr.length-1; j++)
			{
				if(arr[j] > arr[j+1])
				{
					arr[j] = arr[j]-1;
					break;
				}
			}
			if(arr[0]-arr[arr.length-1] < min)
			{
				min = arr[0]-arr[arr.length-1];
				
				if(min==0)
					return min;
			}
		}
		
		return min;
	}
	
}





