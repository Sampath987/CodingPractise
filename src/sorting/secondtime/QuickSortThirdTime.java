package sorting.secondtime;

import java.util.Arrays;

public class QuickSortThirdTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = 
				//	{ 4,2,44,33,22,100,101,102,103,105,1,5,3,99,23,103,500,200,11,88,77,66,55 };

					 {3, 5, 4, 2, 1,8,9,6,7,99,109,119,129,139};

		QuickSortThirdTime quickSortThirdTime = new QuickSortThirdTime();
		quickSortThirdTime.quickSortingMethod(arr,0,arr.length-1 );
				
				Arrays.stream(arr).forEach(i -> System.out.print(i + " "));

	}
	
	public void quickSortingMethod(int[] arr, int start, int end)
	{
		if(end > start)
		{
			int pivot = pivotfindingMethof(arr, start, end);
			
			quickSortingMethod(arr, start, pivot-1);
			quickSortingMethod(arr, pivot+1, end);
		}
	}

	private int pivotfindingMethof(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		
		int pivotalValue = arr[end];
		int pivotalIndex = end;
		for(int i=start; i < end; i++)
		{
			int j = i;
			if(arr[j]> pivotalValue)
			{
				while(arr[j]>pivotalValue && j < end)
				{
					j++;
				}
				if(j <= end)
				{
					int temp = arr[j];
					if(arr[j] == pivotalValue)
					{
						pivotalIndex = i;
					}
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		return pivotalIndex;
	}
 
}
