package com.custom.rangeandpointqueries.fenwicktrees;

public class CustomFenwickTreeSecondTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int[] FenwickTree = {00,10,20,30,60,50,90,70};
//	int[] FenwickTree = new int[intArray.length];
	int size=FenwickTree.length;
	int j=0;
	
	public void constructFenwickTree()
	{
		for(int k=0; k < FenwickTree.length; k++)
		{
			int fenwickId = k;
			fenwickId = fenwickId + lsb(fenwickId);
			if(fenwickId < FenwickTree.length)
			{
				FenwickTree[fenwickId] = FenwickTree[fenwickId] + FenwickTree[k];
			}
		}
	}
	
	public int lsb(int i)
	{
		return i & -i;
	}
	
	public int range(int l, int m)
	{
		System.out.println(FenwickTree[l]+"---" +FenwickTree[m]);
		
		return FenwickTree[l]-FenwickTree[m];
	}
	
	public String updateValueInFenwickTree(int i, int newValue)
	{
		while(i < FenwickTree.length)
		{
			FenwickTree[i] = FenwickTree[i] + newValue;

			i = i + lsb(i);
			if(i < FenwickTree.length)
			{
				FenwickTree[i] = FenwickTree[i] + newValue;
			}
		}
		
		return " ";
		
	}

}
