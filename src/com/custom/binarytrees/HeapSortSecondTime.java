package com.custom.binarytrees;

import java.util.Arrays;

public class HeapSortSecondTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HeapSortSecondTime customBinaryHeap = new HeapSortSecondTime();
		customBinaryHeap.addInsert(100);
		customBinaryHeap.addInsert(90);
		customBinaryHeap.addInsert(10);
		customBinaryHeap.addInsert(102);
		customBinaryHeap.addInsert(97);
		customBinaryHeap.addInsert(96);
		customBinaryHeap.addInsert(95);
		customBinaryHeap.addInsert(959);
		customBinaryHeap.addInsert(959);
		customBinaryHeap.addInsert(23);
		customBinaryHeap.addInsert(53);
		customBinaryHeap.addInsert(203);
		customBinaryHeap.addInsert(239);
		customBinaryHeap.addInsert(23);
		
		System.out.println("Give some gap \n \n");

		customBinaryHeap.heapSortSecondTime();


		customBinaryHeap.iterarte();
		/*
		 * customBinaryHeap.pollDelete(); customBinaryHeap.pollDelete();
		 * customBinaryHeap.pollDelete(); customBinaryHeap.pollDelete();
		 * customBinaryHeap.pollDelete(); customBinaryHeap.pollDelete();
		 * customBinaryHeap.pollDelete(); customBinaryHeap.pollDelete();
		 * customBinaryHeap.pollDelete(); customBinaryHeap.pollDelete();
		 */



		
	}
	
	
	public void iterarte() {
		Arrays.stream(heapArray)
		.sequential()
		.forEach(i -> System.out.print(i + " "));
	}
	public void iterarteFor() {
		for(int num: heapArray)
			System.out.println("The Value of each i is " + num);
	}
	

	private void addInsert(int i) {
		// TODO Auto-generated method stub
			heapArray[currentActiveSize] = i;
			heapifyUp(currentActiveSize);
			currentActiveSize++;
	}
	public void heapSortSecondTime()
	{
		activecurrentActiveSize = currentActiveSize;
		int sortingActivecurrentActiveSize = activecurrentActiveSize-1;
		int internalParent = 0;
		for(int i=0; i < activecurrentActiveSize-1; i++)
		{
			 
			int temp = heapArray[sortingActivecurrentActiveSize];
			heapArray[sortingActivecurrentActiveSize] = heapArray[0];
			heapArray[0] = temp;
			sortingActivecurrentActiveSize--;
			internalParent = 0;
			int leftChild = 2*internalParent+1, 
				rightChild = 2*internalParent+2, 
				internalVariable=internalParent;
			
			while((leftChild <= sortingActivecurrentActiveSize
					|| rightChild <= sortingActivecurrentActiveSize)
					&& (heapArray[internalParent]>=heapArray[rightChild]
					|| heapArray[internalParent]>=heapArray[leftChild]
					))
			{
	
						internalVariable=internalParent;

				if(heapArray[internalVariable] >= heapArray[leftChild])
				{
					internalVariable = leftChild;
				}
				if(heapArray[internalVariable] >= heapArray[rightChild])
				{
					internalVariable = rightChild;
				}
				if(internalVariable!=internalParent)
				{
					
					int tempSwap = heapArray[internalVariable];
					heapArray[internalVariable] = heapArray[internalParent];
					heapArray[internalParent] = tempSwap;
					
					internalParent = internalVariable;
					leftChild = 2*internalParent+1; 
					rightChild = 2*internalParent+2;

				}
				else
				{
					break;
				}
			}
			
		}
	}
	int[] heapArray = new  int[20];
	int currentActiveSize = 0, parent=0;
	int activecurrentActiveSize = currentActiveSize;
	int lengthOfHeapifyDown = currentActiveSize-1;
	
	private void heapSort() {
		
		int heapSortTemp = 0;
		for(int i=0; i<activecurrentActiveSize; i++)
		{
			heapSortTemp = heapArray[lengthOfHeapifyDown];
			heapArray[lengthOfHeapifyDown] = heapArray[0];
			heapArray[0] = heapSortTemp;
			lengthOfHeapifyDown--;
			heapiFyDown();

		}
		
	}
	
	public void heapiFyDown()
	{
		int leftChild= 1,  rightChild = 2;
		int swapVariant=0, parent =0;
		while(parent<(lengthOfHeapifyDown-1)/2
				&& ( (heapArray[parent] > heapArray[leftChild]) 
				|| (heapArray[parent] > heapArray[rightChild])))
		{
			leftChild = 2*parent+1;
			rightChild = 2*parent+2;
			swapVariant = parent;

			if(heapArray[swapVariant] >= heapArray[leftChild])
			{
				swapVariant = leftChild;
			}
			if(heapArray[swapVariant] > heapArray[rightChild])
			{
				swapVariant = rightChild;
			}
			if(swapVariant!=parent)
			{
				
				int tempSwap = heapArray[swapVariant];
				heapArray[swapVariant] = heapArray[parent];
				heapArray[parent] = tempSwap;
				
				parent = swapVariant;

			}
			else
			{
				break;
			}
			
		}
		

	}

	private void heapifyUp(int child) {
		// TODO Auto-generated method stub
		if(child>0)
		{
			parent = (child-1)/2;
			int temp = parent;

			while(parent>=0 && heapArray[parent] > heapArray[child])
				{
				
					int swapVariable = heapArray[child];
					heapArray[child] = heapArray[parent];
					heapArray[parent] = swapVariable;
					
					
					child = parent;
					parent = (parent-1)/2;

				}
	
			
			}		
		
	}

}
