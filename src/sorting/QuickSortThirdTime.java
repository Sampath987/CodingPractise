package sorting;

import java.util.Arrays;

public class QuickSortThirdTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = 
				// {3, 5, 4, 2, 1};
				 { 4,2,44,33,22,100,101,102,103,105,1,5,3,99,23,103,500,200,11,88,77,66,55 };
			
			Arrays.stream(arr).forEach(i -> System.out.print(i + " "));

			QuickSortThirdTime quickSort = new QuickSortThirdTime();
			quickSort.sort(arr, 0, arr.length-1);

			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();

			Arrays.stream(arr).forEach(i -> System.out.print(i + " "));

	}
	
	
	public void sort(int[] arr,int start, int end)
	{
		if(start < end)
		{
		int pivot = partition(arr, start, end);
		sort(arr,start,pivot-1);
		sort(arr,pivot+1,end);
		}
		
	}
	
	public int partition(int[] arr, int start, int end)
	{
		int pivot = end;
		int current=start;
		int temp = 0;
		for(int i=start; i<end ; i++)
		{
			if( arr[i]<=arr[pivot])
			{
				temp = arr[i];
				arr[i] = arr[current];
				arr[current]=temp;
				current++;
			}
			
		}
		if(arr[current]>=arr[pivot])
		{
			 temp = arr[current];
			arr[current] = arr[pivot]; 
			arr[pivot] = temp;
			pivot = current;
		}
		return pivot;
	}

}
