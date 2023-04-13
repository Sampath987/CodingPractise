package sorting.secondtime;

import java.util.Arrays;

import sorting.MergeSort;

public class MergeSortThirdTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = 
				//	{ 4,2,44,33,22,100,101,102,103,105,1,5,3,99,23,103,500,200,11,88,77,66,55 };

					 {3, 5, 4, 2, 1,8,9,6,7,99,109,119,129,139};

				MergeSortThirdTime mergeSortThird = new MergeSortThirdTime();
				mergeSortThird.mergeSortMethodThird(arr,0,arr.length-1 );
				
				Arrays.stream(arr).forEach(i -> System.out.print(i + " "));

	}
	int mid;
	private int[] mergeSortMethodThird(int[] arr, int start, int end) {
		// TODO Auto-generated method stub

		if(end>start)
		{
			mid = start + (end-start)/2 ;
			
			int[] leftArray = Arrays.copyOfRange(arr, start, mid+1);
			int[] rightArray = Arrays.copyOfRange(arr,mid+1, end+1);
			
			mergeThird(arr, mergeSortMethodThird(leftArray, 0, leftArray.length-1), mergeSortMethodThird(rightArray, 0, rightArray.length-1));
		}
		
		return arr;
	}
	private void mergeThird(int[] arr, int[] leftArray, int[] rightArray) {
		// TODO Auto-generated method stub
		
		int indexOfArr = 0;
		int length = arr.length;
		
		int leftIterator = 0;
		int rightIterator = 0;
		
		if(leftArray!= null && rightArray!= null)
		{
			while(leftIterator < leftArray.length && rightIterator < rightArray.length)
			{
				if(leftArray[leftIterator] > rightArray[rightIterator])
				{
					arr[indexOfArr] = rightArray[rightIterator];
					rightIterator++;
					indexOfArr++;
				}
				else
				{
					arr[indexOfArr] = leftArray[leftIterator];
					leftIterator++;
					indexOfArr++;
				}
			}
		}
		
		if(leftArray!= null && leftIterator < leftArray.length)
		{
			while(leftIterator < leftArray.length)
			{
			arr[indexOfArr] = leftArray[leftIterator];
			leftIterator++;
			indexOfArr++;
			}
		}
		
		if(rightArray!= null && rightIterator < rightArray.length)
		{
			while(rightIterator < rightArray.length)
			{
			arr[indexOfArr] = rightArray[rightIterator];
			rightIterator++;
			indexOfArr++;
			}
		}
	}

}
