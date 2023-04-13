package sorting.secondtime;
import java.util.Arrays;

public class InsertionSortBySampath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		int[] arr = new int[] { -2, 7, 15, -14, 0, 15 };
		

		Arrays.stream(arr).forEach(System.out::println);
		
		InsertionSortBySampath insertionSort2 = new InsertionSortBySampath();
	//	insertionSort2.insertionSort(arr);
		insertionSort2.insertionSortWithIntVariable(arr, 0);

		System.out.println();
		System.out.println();
		System.out.println();

		Arrays.stream(arr).forEach(System.out::println);

	}
	
	
	public void insertionSortWithIntVariable(int[] arr, int i)
	{
		while(i < arr.length-1 && arr[i] < arr[i+1])
		{
			i++;
		}
			int t =i+1;

			while(t>0 && arr[t] < arr[t-1])
			{
				
					int temp = arr[t-1];
					arr[t-1] = arr[t];
					arr[t] = temp;
				t--;
			}
			if(i == arr.length-2)
				return ;
			i++;
			insertionSortWithIntVariable(arr, i);
			
	}
	
	public void insertionSort(int[] arr)
	{
		int i=0;
		while(i < arr.length-1 && arr[i] < arr[i+1])
		{
			i++;
		}
			int t =i+1;

			while(t>0)
			{
				if(arr[t] < arr[t-1])
				{
					int temp = arr[t-1];
					arr[t-1] = arr[t];
					arr[t] = temp;
				}
				
				t--;
			}
			if(i == arr.length-2)
				return ;
			insertionSort(arr);
			
	}

}
