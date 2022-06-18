package sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InsertionSort insertionSort = new InsertionSort();
		insertionSort.publicSort();
		

	}
	
	
	int[] a = new int[]{4, 2,44,33,22,100,101,102,103,105,1, 5, 3,99,23,103,500,200,11,88,77,66,55 };
	
	int i=0;
	int temp;
	
	public void publicSort()
	{
		System.out.println("Before sorting");
		
		Arrays.stream(a).forEach(i -> System.out.println(i));
		
		sort(i);
		
		System.out.println("After sorting");
		
		Arrays.stream(a).forEach(i -> System.out.println(i));
	}
	public void sort(int i)
	{
		while(i<a.length-1 && a[i]<a[i+1] )
		{
			i++;
		}
		swapDown(i);
		i++;
		if(i<a.length-1)
		{
			sort(i);
		}
		
	}
	
	public void swapDown(int i)
	{
		if( i<a.length-1 && a[i]>a[i+1])
		{
			temp = a[i];
			a[i] = a[i+1];
			a[i+1]=temp;
			if(i>0 && a[i]<a[i-1])
			{
				i--;
			swapDown(i);
			}
		}
	}

}
