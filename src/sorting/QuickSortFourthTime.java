package sorting;

import java.util.Arrays;
import java.util.Optional;

public class QuickSortFourthTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = 
			 { 4,2,44,33,22,100,101,102,103,105,1,5,3,99,23,103,500,200,11,88,77,66,55 };

		QuickSortFourthTime quickSort =new QuickSortFourthTime();
		quickSort.sortMethod(arr, 0, arr.length-1);

		Arrays.stream(arr).forEach(i -> System.out.print(i + " "));

	}
	
	public void sortMethod(int[] arr, int start, int end)
	{
		if(start<end)
		{
			int pivot = partition(arr, start, end);
			sortMethod(arr, start, pivot-1);
			sortMethod(arr, pivot+1, end);

			
		}
	}
	
	public int partition(int[] arr, int start, int end)
	{
		int pivot = end;
		int j = start;
		int temp=0;
		
		for(int i =start; i<=end; i++)
		{
			if(arr[i] <= arr[pivot])
			{
				temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				j++;
			}
			
		}
		return j-1;
	}

}
