package sorting.secondtime;

import java.util.Arrays;

import sorting.MergeSort;

public class MergeSortSecondTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = 
			{ 4,2,44,33,22,100,101,102,103,105,1,5,3,99,23,103,500,200,11,88,77,66,55 };
				
		//	 {3, 5, 4, 2, 1,8,9,6,7};

		MergeSortSecondTime mergeSortSecondTime = new MergeSortSecondTime();
		mergeSortSecondTime.publicSort(arr);

		Arrays.stream(arr).forEach(i -> System.out.print(i + " "));


	}
	
	public void publicSort(int[] arr)
	{
		 devide(arr,0,arr.length-1);
	}
	

	public int[] devide(int[] arr, int start, int end)
	{
		if(end>start)
		{
			
		int mid = start + (end-start)/2 ; // (start+ end)/2 ; // same as start + (end-start)/2
		
		int[] leftArray = Arrays.copyOfRange(arr, start, mid+1);
		int[] rightArray = Arrays.copyOfRange(arr, mid+1, end+1);
		
		merge(arr, devide(leftArray, 0, leftArray.length-1), devide(rightArray, 0, rightArray.length-1));
		
		}
		
		return arr;
		
	}
	
	public void merge(int[] arr, int[] leftArray, int[] rightArray)
	{
		int length = arr.length;
		int indexOfArr = 0;

		int leftIterator = 0;
		int rightIterator = 0;
		
		if(leftArray!= null && rightArray!=null)
		{
			while(length > indexOfArr && leftIterator < leftArray.length && rightIterator < rightArray.length)
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
			while(length > indexOfArr && leftIterator < leftArray.length)
			{
				arr[indexOfArr] = leftArray[leftIterator];
				leftIterator++;
				indexOfArr++;

			}
		}
		if(rightArray!= null && rightIterator < rightArray.length)
		{
			while(length > indexOfArr && rightIterator < rightArray.length)
			{
				arr[indexOfArr] = rightArray[rightIterator];
				rightIterator++;
				indexOfArr++;

			}
		}
	}
	
	

}
