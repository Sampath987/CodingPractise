package sorting.secondtime;

import java.util.Arrays;

public class QuickSortSecondTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = 
				//	{ 4,2,44,33,22,100,101,102,103,105,1,5,3,99,23,103,500,200,11,88,77,66,55 };

					 {3, 5, 4, 2, 1,8,9,6,7,99,109,119,129,139};

		QuickSortSecondTime quickSortSecond = new QuickSortSecondTime();
		quickSortSecond.quickSorting(arr,0,arr.length-1 );
				
				Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
	}
	
	
	public void quickSorting(int[] arr, int start, int end)
	{
		if(end > start)
		{
		int pivot = findPivot(arr, start, end);
		
		quickSorting(arr,start,pivot-1);
		quickSorting(arr,pivot+1,end);
		}

	}

	public int findPivot(int[] arr,int start, int end) {
		// TODO Auto-generated method stub
		int pivotValue = arr[end];
		int pivotIndex=end;
		for(int i=start; i< end; i++)
		{
			int j =i;
			if(arr[j] > pivotValue)
			{
				while(arr[j] > pivotValue && j < end)
				{
					j++;
				}
				if(j <= end)
				{
					if(arr[j] == pivotValue)
					{
						pivotIndex = i;
					}
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				}
			}
			
		}
		return pivotIndex;
	}

}

