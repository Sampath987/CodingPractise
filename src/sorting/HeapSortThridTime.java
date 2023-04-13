package sorting;

import java.util.Arrays;

public class HeapSortThridTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HeapSortThridTime heapSortThridTime = new HeapSortThridTime();

		// 4,2,44,33,22,100,101,102,103,105,1,5,3,99,23,103,500,200,11,88,77,66,55
		// 1  2  44  33  4  100  101  102  103  105  22  199  

		heapSortThridTime.addElement(4);
		heapSortThridTime.addElement(2);
		heapSortThridTime.addElement(44);
		heapSortThridTime.addElement(33);
		heapSortThridTime.addElement(22);
		heapSortThridTime.addElement(100);
		heapSortThridTime.addElement(101);
		heapSortThridTime.addElement(102);
		heapSortThridTime.addElement(103);
		heapSortThridTime.addElement(105);
		heapSortThridTime.addElement(1);
		heapSortThridTime.addElement(199);

		System.out.println();
		heapSortThridTime.printSortedArray();
		System.out.println("\n");

		System.out.println("\n" + "---");

		heapSortThridTime.sortElements();
		heapSortThridTime.printSortedArray();

	}
	
	int[] arr = new int[12];
	int current = 0;
	int temp;
	int parent;
	int child;
	public void addElement(int i)
	{
		arr[current] = i;
		parent = (current-1)/2;
		child = current;
		if(child>0)
		{
			// 1  2  44  33  4  100  101  102  103  105  22  199  

			while(parent>=0 && arr[child] < arr[parent])
			{
				temp = arr[child];
				arr[child] = arr[parent];
				arr[parent] = temp;
				child = parent;
				parent = (child-1)/2;
			}
		}
		current++;
	}
	
	public void sortElements()
	{
		System.out.println("Value of current " + current);
		parent = 0;
		int swap; 
		for(int i=0; i<arr.length;i++)
		{
			temp = arr[0];
			arr[0] = arr[current-1];
			arr[current-1] = temp;
			current--;
			while(parent < (current-1)/2 && (arr[parent] > arr[(2*parent)+1] || arr[parent] > arr[(2*parent)+2]))
			{
				swap = parent;
				if(arr[swap] > arr[(2*parent)+1])
				{
					swap = (2*parent)+1;
				}
				if(arr[swap] > arr[(2*parent)+2])
				{
					swap = (2*parent)+2;

				}
				
				if(swap!=parent)
				{
					temp = arr[swap];
					arr[swap] = arr[parent];
					arr[parent] = temp;

				}
				parent = swap;

			}
			
			parent = 0;
		}
	}
	
	public void printSortedArray() {

		Arrays.stream(arr).forEach(i -> System.out.print(i + "  "));

	}

}
