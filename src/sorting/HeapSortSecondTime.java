package sorting;

import java.util.Arrays;

public class HeapSortSecondTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HeapSortSecondTime heapSortSecondTime = new HeapSortSecondTime();

		// 4,2,44,33,22,100,101,102,103,105,1,5,3,99,23,103,500,200,11,88,77,66,55
		heapSortSecondTime.addHeapSort(4);
		heapSortSecondTime.addHeapSort(2);
		heapSortSecondTime.addHeapSort(44);
		heapSortSecondTime.addHeapSort(33);
		heapSortSecondTime.addHeapSort(22);
		heapSortSecondTime.addHeapSort(100);
		heapSortSecondTime.addHeapSort(101);
		heapSortSecondTime.addHeapSort(102);
		heapSortSecondTime.addHeapSort(103);
		heapSortSecondTime.addHeapSort(105);
		heapSortSecondTime.addHeapSort(1);
		heapSortSecondTime.addHeapSort(199);

		System.out.println();
		heapSortSecondTime.printSortedArray();
		System.out.println("\n");

		System.out.println("\n" + "---");

		heapSortSecondTime.heapSort();
		heapSortSecondTime.printSortedArray();

	}

	int[] heapSort = new int[12];
	int currentSize = 0;
	int parent;
	int temp = 0;
	int swapIndex;
	int child;

	public void printSortedArray() {

		Arrays.stream(heapSort).forEach(i -> System.out.print(i + "  "));

	}

	public void addHeapSort(int i) {
		System.out.print(i + "  ");
		heapSort[currentSize] = i;
		if (currentSize > 0) {
			child = currentSize;
			parent = (child - 1) / 2;
			while (parent >= 0 && heapSort[parent] > heapSort[child]) {
				temp = heapSort[child];
				heapSort[child] = heapSort[parent];
				heapSort[parent] = temp;
				child = parent;
				parent = (child - 1) / 2;
			}
		}

		currentSize++;

	}

	public void heapSort() {


		
		int lastIndex = heapSort.length - 1;
		parent = 0;

		// for
		for (int i = 0; i < heapSort.length; i++) {
			temp = heapSort[parent];
			int Leftchild = 2*parent+1, rightChild = 2*parent+2;
			heapSort[parent] = heapSort[lastIndex];
			heapSort[lastIndex] = temp;
			lastIndex--;
			// heapifyDown
			while (((2*parent)+1) < lastIndex
					&& (heapSort[parent] > heapSort[Leftchild] || heapSort[parent] > heapSort[rightChild])) {
				if (heapSort[parent] > heapSort[Leftchild] && heapSort[Leftchild] < heapSort[rightChild]) {
					temp = heapSort[parent];
					heapSort[parent] = heapSort[Leftchild];
					heapSort[Leftchild] = temp;

					parent = Leftchild;
					Leftchild = (2 * parent) + 1;
					rightChild = (2 * parent) + 2;

				} else if (heapSort[parent] > heapSort[rightChild] && heapSort[Leftchild] > heapSort[rightChild]) {
					temp = heapSort[parent];
					heapSort[parent] = heapSort[rightChild];
					heapSort[rightChild] = temp;

					parent = rightChild;
					Leftchild = (2 * parent) + 1;
					rightChild = (2 * parent) + 2;
					// 199 105 103 102 101 100 44 33 22 4 2 1

				}
			}
			parent = 0;
		}

	}
}
