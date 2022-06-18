package com.custom.rangeandpointqueries.fenwicktrees;

import java.util.Arrays;
import java.util.Random;

public class CustomFenwickTree {

	public static void main(String[] args) {

		

		CustomFenwickBySampath customFenwickBySampath = new CustomFenwickBySampath();
		customFenwickBySampath.generateFenwickTree();
		
		
		System.out.println(customFenwickBySampath.range(4,2));
		System.out.println(customFenwickBySampath.updateValueInFenwickTree(4, 10));
	}
}

/*

1). Generate array consists of FenwickTree
2). find LSB 
3). range method
4). Update particular value

*/
class CustomFenwickBySampath
{
	int[] FenwickTree = {00,10,20,30,60,50,90,70};
//	int[] FenwickTree = new int[intArray.length];
	int size=FenwickTree.length;
	int j=0;
	
	/*
	
	
		
		
		*/
	public void generateFenwickTree()
	{
		
		for(int i=1;i<=size;i++)
		{
			j=methodToFindLSB(i)+i;
			if(j<size)
			{
			FenwickTree[j] = FenwickTree[j] + FenwickTree[i];
//			System.out.println("j    " + (j) + "--" + i+"---"+FenwickTree[i] +"-----"+FenwickTree[j]);
			}
		}
		
		for(int i=1;i<size;i++)
		{
			
			System.out.println("---"+i +"-----"+FenwickTree[i]);
			
			}
		
		
	}
	
	public int methodToFindLSB(int i)
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
		FenwickTree[i] = FenwickTree[i] + newValue;
		while(i<=size)
		{
			i= methodToFindLSB(i)+i;
			if(i<size)
			{
				FenwickTree[i] = FenwickTree[i] + newValue;
				System.out.println();
			}
			
		}
		return  " ---" + i;
	}
}
