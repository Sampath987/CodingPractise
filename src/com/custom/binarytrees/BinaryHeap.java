package com.custom.binarytrees;

import java.util.Arrays;

public class BinaryHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CustomBinaryHeap customBinaryHeap = new CustomBinaryHeap();
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

		customBinaryHeap.iterarte();
		System.out.println("Give some gap \n \n");

		/*
		 * customBinaryHeap.pollDelete(); customBinaryHeap.pollDelete();
		 * customBinaryHeap.pollDelete(); customBinaryHeap.pollDelete();
		 * customBinaryHeap.pollDelete(); customBinaryHeap.pollDelete();
		 * customBinaryHeap.pollDelete(); customBinaryHeap.pollDelete();
		 * customBinaryHeap.pollDelete(); customBinaryHeap.pollDelete();
		 */

		customBinaryHeap.heapSort();

		customBinaryHeap.iterarte();

	}

}
// how did we delete during poll

class CustomBinaryHeap {
	int[] heap = new int[20];;
	int currentHeapSize = 0;
	int actulaSizeOfTheHeap = heap.length;
	int heapSortCountElement = 0;

	public CustomBinaryHeap() {
	}

	public int get() {
		return 0;

	}

	public void addInsert(int k) {
		if (currentHeapSize == 0) {
			heap[currentHeapSize] = k;
			currentHeapSize++;
		} else {
			if (currentHeapSize < actulaSizeOfTheHeap) {
				heap[currentHeapSize] = k;
				heapifyUp(heap, currentHeapSize);
				currentHeapSize++;

			} else {
				throw new ArrayIndexOutOfBoundsException();
			}
		}

	}

	public void heapifyUp(int[] heap, int currentHeapSize) {
		int parentElement = (currentHeapSize - 1) / 2;
		if (parentElement >= 0) {
			int temp = heap[currentHeapSize];
			if (temp > heap[parentElement]) {
				heap[currentHeapSize] = heap[parentElement];
				heap[parentElement] = temp;
				heapifyUp(heap, parentElement);
			}
		}

	}

	public void heapifyDown(int[] heap, int parentElementindex) {
		int leftChild = 2 * parentElementindex + 1;
		int rightChild = 2 * parentElementindex + 2;
		int max = parentElementindex;
		int temp;
		if (parentElementindex <= (currentHeapSize - 1) / 2 - 1 && heap[max] < heap[leftChild]) {
			max = leftChild;
		}
		if (parentElementindex <= (currentHeapSize - 1) / 2 - 1 && heap[max] < heap[rightChild]) {
			max = rightChild;
		}
		if (max != parentElementindex) {
			temp = heap[max];
			heap[max] = heap[parentElementindex];
			heap[parentElementindex] = temp;
			heapifyDown(heap, max);
		}

	}
	
	public void heapifyDownForSorting(int[] heap, int iparentElement) {
		int leftSide = 2 * iparentElement + 1;
		int rightSide = 2 * iparentElement + 2;
		int max = iparentElement; //
		if (heap[leftSide] > heap[max] && leftSide <= heapSortCountElement) {
			max = leftSide;
		}
		if (heap[rightSide] > heap[max] && rightSide <= heapSortCountElement) {
			max = rightSide;
		}
		if (max != iparentElement) {
			int temp = heap[max];
			heap[max] = heap[iparentElement];
			heap[iparentElement] = temp;
			heapifyDownForSorting(heap, max);

		}

	}

	public void pollDelete() {
		System.out.println(heap[0]);

		heap[0] = heap[currentHeapSize - 1];
		heap[currentHeapSize - 1] = 0;
		currentHeapSize--;
		heapifyDown(heap, 0);
	}

	public void heapSort() {
		heapSortCountElement = currentHeapSize - 1;

		for (int i = 0; i < currentHeapSize; i++) {
			int temp = heap[0];
			heap[0] = heap[heapSortCountElement];
			heap[heapSortCountElement] = temp;
			heapSortCountElement--;
			heapifyDownForSorting(heap, 0);
		}

	}


	public void iterarte() {
		Arrays.stream(heap).forEach(i -> System.out.println("The Value of each i is " + i));
	}

}

// 