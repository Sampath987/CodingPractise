	package sorting;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		HeapSort heapSort = new HeapSort();
		
		// 4,2,44,33,22,100,101,102,103,105,1,5,3,99,23,103,500,200,11,88,77,66,55
		heapSort.addingElements(4);
		heapSort.addingElements(2);
		heapSort.addingElements(44);
		heapSort.addingElements(33);
		heapSort.addingElements(22);
		heapSort.addingElements(100);
		heapSort.addingElements(101);
		heapSort.addingElements(102);
		heapSort.addingElements(103);
		heapSort.addingElements(105);
		heapSort.addingElements(1);
		heapSort.addingElements(199);
		

		

		heapSort.printSortedArray();
		System.out.println("\n");
		
		for (int i = 0; i < heapSort.heapSort.length; i++) {

			heapSort.poll_DELETE();

		}
		
		System.out.println("\n");

		heapSort.printSortedArray();


	}

	int[] heapSort = new int[12];
	int currentSize = 0;
	int parent;
	int temp=0;
	int swapIndex;
	
	
	public void addingElements(int i)
	{
		heapSort[currentSize] = i;
		/*
		 * if(currentSize==1 && heapSort[0] > heapSort[1]) { temp = heapSort[0];
		 * heapSort[0] = heapSort[1]; heapSort[1] = temp; }
		 */
		if(currentSize>0)
		{
			heapifyUpMethod(currentSize);
		}
		
		currentSize = currentSize + 1 ;

	}
	
	public void heapifyUpMethod(int index)
	{
	// 	currentSize = 2*parent + 1 ;
		
		
		parent = (index-1)/2;
		
		while(parent>=0 && heapSort[parent]>heapSort[index])		
		{
			temp = heapSort[parent];
			heapSort[parent] = heapSort[index];
			heapSort[index] = temp;
			
			index = parent;
			parent = (index-1)/2;
	

		}
	}
	
	public void printSortedArray()
	{
		
		Arrays.stream(heapSort).forEach(i -> System.out.print(i + "  "));
		
	}
	
	public int poll_DELETE()
	{
		int k = heapSort[0];
		temp = heapSort[0] ;
		heapSort[0]=heapSort[currentSize-1];
		heapSort[currentSize-1] = temp;
		currentSize--;
		private_POLL_DELETE(0);
		
		System.out.println(" the value of k is :"+k);
		return k;
	}
	
	private void private_POLL_DELETE(int p)
	{
		while(p < (currentSize-1)/2 && 
				(heapSort[p] > heapSort[2*p +1] || heapSort[p] > heapSort[2*p +2]))
		{
			swapIndex = p;
			if(heapSort[swapIndex] > heapSort[2*p +1])
				swapIndex=2*p+1;
			if(heapSort[swapIndex] > heapSort[2*p +2])
				swapIndex=2*p +2;
			
			if(swapIndex!=p)
			{
				temp = heapSort[swapIndex];
				heapSort[swapIndex] = heapSort[p];
				heapSort[p] = temp;
			}
			
			p = swapIndex;
				
		}
	}
}
