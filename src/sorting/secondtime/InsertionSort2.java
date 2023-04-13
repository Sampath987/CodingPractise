package sorting.secondtime;
import java.util.Arrays;

public class InsertionSort2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		int[] arr = new int[] { -2, 7, 15, -14, 0, 15 };
		

		Arrays.stream(arr).forEach(System.out::println);
		
		InsertionSortBySampath insertionSort2 = new InsertionSortBySampath();
		insertionSort2.insertionSort(arr);
		System.out.println();
		System.out.println();
		System.out.println();

		Arrays.stream(arr).forEach(System.out::println);

	}
	
	public void insertionSort(int[] arr)
	{
		int i=0;
		while(arr[i] < arr[i+1] && i < arr.length-1)
		{
			i++;
		}
		for(int k =i; k < arr.length-1;k++)
		{
			int t =k+1;

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
			
		}
	}

}
