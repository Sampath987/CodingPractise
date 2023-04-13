package sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 35421
		
		System.out.println(9/2 + "--" + "--" + 9%2);
		
		int[] arr = 
		//	{ 4,2,44,33,22,100,101,102,103,105,1,5,3,99,23,103,500,200,11,88,77,66,55 };

			 {3, 5, 4, 2, 1,8,9,6,7,99,109,119,129,139};
		Arrays.stream(arr).forEach(i -> System.out.print(i + " "));

		System.out.println();
		MergeSort mergeSort = new MergeSort();
		mergeSort.mergeSortMethod(arr);
		
		System.out.println();
		Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
	}
	
	int start ;
	
	public void mergeSortMethod(int[] arr)
	{
		
		divideMethod(arr,  0, arr.length-1);
		
	//	return arr;

	}
	
	public int[] divideMethod(int[] arr, int start, int end)
	{
		if(start<end)
			{
				int mid = (start+ end)/2 ;		
				int[] arrLeft = Arrays.copyOfRange(arr, start, mid+1); // new int[mid+1-start];
				int[] arrRight = Arrays.copyOfRange(arr, mid+1, end+1); // new int[end-mid];
				mergeMethod(arr, 
						divideMethod(arrLeft, 0, arrLeft.length-1), 
						divideMethod(arrRight, 0, arrRight.length-1));
			}
		
		return arr;
	}
	public int[] mergeMethod(int[] arr, int[] arrLeft, int[] arrRight)
	{
		int leftLength=arrLeft.length;
		int rightLength=arrRight.length;
		
		int left =0;
		int right =0;
		
		for(int i=0;i<arr.length;i++)
		{
			if(leftLength< arr.length && rightLength < arr.length && left < leftLength && right < rightLength)
			{
				if(arrLeft[left]>arrRight[right])
				{
					arr[i] = arrRight[right];
					right++;
				}
				else
				{
					arr[i] = arrLeft[left];
					left++;
				}
			}
			else if(leftLength< arr.length && left < leftLength)
			{
				System.arraycopy(arrLeft, left, arr, i, leftLength-left);
				break;
			//	arr[i] = arrLeft[left];
			//	left++;
			}
			else if(rightLength < arr.length && right < rightLength)
			{
				System.arraycopy(arrRight, right, arr, i, rightLength-right);
				break;
				
			//	arr[i] = arrRight[right];
			//	right++;
			}
		}
		return arr;
	}

}

// 	int[] sort = new int[]{4, 2, 1, 5, 3 };

