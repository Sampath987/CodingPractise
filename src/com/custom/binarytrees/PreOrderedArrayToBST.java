package com.custom.binarytrees;

import java.util.Stack;

public class PreOrderedArrayToBST {
	
	
	PreNode head;
	PreNode curr;


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int[] arr = {10, 5, 1, 7, 40, 50};
		
		PreOrderedArrayToBST preOrderedArrayToBST = new PreOrderedArrayToBST();
		System.out.println(preOrderedArrayToBST.convertToBST(arr).data);
		
		preOrderedArrayToBST.inOrder(preOrderedArrayToBST.convertToBST(arr));
		
	}

	
	public void inOrder(PreNode header)
	{
		if(header != null)
		{
			inOrder(header.left);
			System.out.print(header.data + " ");
			inOrder(header.right);

		}
		/*
		 * while(!stack.isEmpty()) { PreNode temp = stack.pop(); PreNode header = temp;
		 * while(header.left!= null) { stack.push(header.left); header.left =
		 * header.left.left;
		 * 
		 * }
		 * 
		 * System.out.print(header.data + " ");
		 * 
		 * if(header.right!=null) stack.push(header.right); }
		 */
		
	}
	
	public PreNode convertToBST(int[] arr)
	{
		return privateconvertToBST(arr, 0, arr.length-1);
		
	}
		
	public PreNode privateconvertToBST(int[] arr, int currLeft, int currRight)
	{
		PreNode newNode = null;
		if(arr != null && currRight>currLeft)
		{
			int i = currLeft + 1;
			newNode = new PreNode(arr[currLeft]);
			while(arr[currLeft] > arr[i] && i < currRight)
			{
				i++;
			}		
			// {10, 5, 1, 7, 40, 50};
			if(currLeft == i-2)
			{
				newNode.left = new PreNode(arr[i-1]);
			}
			else
			newNode.left = privateconvertToBST(arr, currLeft+1, i-1);
			if(currRight == i)
				newNode.right = new PreNode(arr[i]);
			else
			newNode.right = privateconvertToBST(arr, i, currRight);

			
			
			return newNode;
		}
		return newNode;
		
		
	}
}

class PreNode
{
	int data;
	PreNode left;
	PreNode right;
	
	PreNode()
	{
	}
	
	PreNode(int data)
	{
		this.data = data;
	}
}
