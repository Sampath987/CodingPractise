package com.custom.arrays;

public class ArraysConcurrentModificationCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[] = { 2, 6, 9, 3, 5, 7, 10, 55, 34 };
		
		int i=a.length-1;
		while(i>=0)
		{
			System.out.println(" the value of i "+ a[i]);
			if(i==4)
			{
				System.out.println(" the removed value of i "+ i + " is " + a[i] );
				a.rem
			}

			i--;
		}
		
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		
		
		int j=a.length-1;
		while(j>=0)
		{
			System.out.println(" the value of j "+ a[j]);
			if(j==4)
				System.out.println(" the removed value of i "+ j + " is " + a[j] );

			j--;
		}
		
	}

}
