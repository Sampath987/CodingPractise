package sorting.secondtime;

import java.util.Arrays;


public class HeapSortSecondTime {

	int[] arr = new int[14];
	int currentHeapSize = 0;
	int actulaSizeOfTheHeap = arr.length;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		HeapSortSecondTime heapSortSecondTime = new HeapSortSecondTime();
		heapSortSecondTime.addMethod(100);
		heapSortSecondTime.addMethod(90);
		heapSortSecondTime.addMethod(10);
		heapSortSecondTime.addMethod(102);
		heapSortSecondTime.addMethod(97);
		heapSortSecondTime.addMethod(96);
		heapSortSecondTime.addMethod(95);
		heapSortSecondTime.addMethod(959);
		heapSortSecondTime.addMethod(959);
		heapSortSecondTime.addMethod(23);
		heapSortSecondTime.addMethod(53);
		heapSortSecondTime.addMethod(203);
		heapSortSecondTime.addMethod(239);
		heapSortSecondTime.addMethod(23);

		heapSortSecondTime.iterarte();
		System.out.println("Give some gap \n \n");

	

		heapSortSecondTime.heapSort();

		heapSortSecondTime.iterarte();

	}
	public void iterarte() {
		for(int i= actulaSizeOfTheHeap-1; i>=0;i--)
			System.out.println(arr[i]);
		//Arrays.stream(arr).forEach(i -> System.out.println("The Value of each i is " + i));
	}
	public void heapSort()
	{
		currentHeapSize--;
		while(currentHeapSize > 0)
		{
			swapMethod(0, currentHeapSize);
			currentHeapSize--;
			
			heapifyDownMethod(0);
			
		}
		
	}
	
	
	public void heapifyDownMethod(int k) {
		
		int leftChild = 2*k+1;
		int rightChild = 2*k+2;
		
		int min = k;
		if(leftChild <=currentHeapSize && arr[min] > arr[leftChild])
			min = leftChild;
		if( rightChild <=currentHeapSize && arr[min] > arr[rightChild])
			min = rightChild;
		swapMethod(min, k);
		if(min!=k)
		heapifyDownMethod(min);
		
		
	}

	public void addMethod(int i)
	{
		if(currentHeapSize==0)
		{
			arr[currentHeapSize] = i;
			currentHeapSize++;
		}
		else
		{
			arr[currentHeapSize] = i;
			heapifyUpMethod(currentHeapSize);
			currentHeapSize++;

		}
	}

	public void heapifyUpMethod(int currentHeapSize) {
		
		int parent = (currentHeapSize-1)/2;
		
		while(arr[parent] > arr[currentHeapSize] && parent >=0)
		{
			swapMethod(parent, currentHeapSize);
			/*
			 * int temp = arr[parent]; arr[parent] = arr[currentHeapSize];
			 * arr[currentHeapSize] = temp;
			 */
			currentHeapSize = parent;
			parent = (currentHeapSize-1)/2;
		}

		
	}
	
	public void swapMethod(int j, int k)
	{
		int temp = arr[j];
		arr[j] = arr[k];
		arr[k]=temp;
	}

}
