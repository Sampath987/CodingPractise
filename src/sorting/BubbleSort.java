package sorting;

import java.util.Arrays;

public class BubbleSort {
	
	int[] sort = new int[]{4, 2, 1, 5, 3 };
	
	int temp;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		BubbleSort bubbleSort = new BubbleSort();
		

		
		bubbleSort.BubbleSortMethod();

		
	}
	
	public void BubbleSortMethod()
	{
		System.out.println("Before sorting");
		
		Arrays.stream(sort).forEach(i -> System.out.println(i));
		

		for(int i=0;i<sort.length-1;i++)
		{
			for(int j=0;j<sort.length-1;j++)
			{
				if(sort[j]>sort[j+1])
				{
					temp = sort[j];
					sort[j]= sort[j+1];
					sort[j+1]=temp;
				}
			}

		}
		
		System.out.println("After sorting");
		
		Arrays.stream(sort).forEach(i -> System.out.println(i));
		
		

	}

}
