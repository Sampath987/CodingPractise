package sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[] arr = 
			// {3, 5, 4, 2, 1};
			 { 4,2,44,33,22,100,101,102,103,105,1,5,3,99,23,103,500,200,11,88,77,66,55 };
		
		Arrays.stream(arr).forEach(i -> System.out.print(i + " "));

		QuickSort quickSort =new QuickSort();
		quickSort.sortMethod(arr, 0, arr.length-1);

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

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
		int cursor = start;
		for(int i=start; i<end; i++)
		{
			if(arr[i]<=arr[pivot])
			{
				int temp = arr[i];
				arr[i] = arr[cursor]; 
				arr[cursor] = temp;
				cursor++;
			}
		}
		if(arr[cursor]>=arr[pivot])
		{
			int temp = arr[cursor];
			arr[cursor] = arr[pivot]; 
			arr[pivot] = temp;
			pivot = cursor;
		}
		return pivot;
	}

}
