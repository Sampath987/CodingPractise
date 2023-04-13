package com.custom.binarytrees;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTreeCustom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CustomBinarySearTree customBinarySearTree = new CustomBinarySearTree();
		
		customBinarySearTree.addBST(10);
		customBinarySearTree.addBST(20);
		customBinarySearTree.addBST(15);
		customBinarySearTree.addBST(16);
		customBinarySearTree.addBST(19);

		customBinarySearTree.addBST(18);
		customBinarySearTree.addBST(17);
		customBinarySearTree.addBST(5);
		customBinarySearTree.addBST(100);
		customBinarySearTree.addBST(1000);
		customBinarySearTree.addBST(200);

		customBinarySearTree.getBST_INORDER(customBinarySearTree.headNode);
		System.out.println("---");
		customBinarySearTree.getBST_BFS_LEVELORDER(customBinarySearTree.headNode);
		System.out.println("---");
		System.out.println("---remove starts");
		customBinarySearTree.remove(customBinarySearTree.bstArr[0], 20);
		System.out.println("--- remove ends");
		System.out.println("---Climax---");
		System.out.println("---Climax---");
		System.out.println("---Climax---");
		System.out.println(customBinarySearTree.height(customBinarySearTree.bstArr[0]));



	}

}

class Node
{
	int data;
	Node left;
	Node right;
	
	// This field is used for only BalancedBinarySearchtree
    int height;

	// This field is used for only BalancedBinarySearchtree
    // BalanceFactor
    public int bf;
    
    
	Node(int data)
	{
		this.data= data;
	}
}
class CustomBinarySearTree
{
	public Node removeSecondTime(Node headNode, int k)
	{
		Node returningNode = null;
	 if(headNode!=null)
	 {
		if(headNode.data>k)
		{
			removeSecondTime(headNode.left, k);
		}
		else if(headNode.data<k)
		{
			removeSecondTime(headNode.right, k);
		}
		else if(headNode.data==k)
		{
			if(headNode.left==null && headNode.right==null)
			{
				returningNode = headNode;
				headNode=null;
				return returningNode;
			}
			// 
			else if(headNode.left==null)
			{
				headNode.data = headNode.right.data;
				removeSecondTime(headNode.right,headNode.right.data);
				
			}
			else if(headNode.right==null)
			{
				headNode.data = headNode.left.data;
				removeSecondTime(headNode.left,headNode.left.data);
				
			}
			else
			{

				Node temp = headNode.left;
				while(temp.right!=null)
				{
					temp = temp.right;
				}
				headNode.data = temp.data;
				removeSecondTime(temp,temp.data);

				
			}
			
		}
	 }
	 return returningNode;
	}
	
	public Node removeThirdTime(Node headNode, int k)
	{
		if(headNode!=null)
		 {
			if(headNode.data>k)
			{
				headNode.left = removeThirdTime(headNode.left, k);
			}
			else if(headNode.data<k)
			{
				headNode.right = removeThirdTime(headNode.right, k);
			}
			else if(headNode.data==k)
			{
				if(headNode.left==null)
					return headNode.right;
				else if(headNode.right==null)
					return headNode.left;
				else
				{
					Node temp = headNode.left;
					while(temp.right!=null)
					{
						temp = temp.right;
					}
					headNode.data = temp.data;
					headNode.left = removeThirdTime(headNode.left, temp.data);
					
				}
				
			}
			return headNode;

		}
		
		return null;
	}

	
	Node[] bstArr = new Node[20];
	int bstArrActualSize=bstArr.length;
	int currentBSTSize=0;
	
	Node headNode ;
	public int height(Node headNode)
	{
	    if (headNode == null) return 0;
		return Math.max(height(headNode.left), height(headNode.right)) +1;
		
		
	}
	
	public void remove(Node headNode, int k)
	{
		if(headNode.data>k)
		{
			remove(headNode.left, k);
		}
		else if(headNode.data<k)
		{
			remove(headNode.right, k);
		}
		if(headNode.data==k)
		{
			Node temp = headNode.left;
			
			while(temp.right!=null && temp.right.right!=null)
			{
				temp=temp.right;
			}
			Node removableNode = temp.right;
			headNode.data=removableNode.data;
			temp.right=removableNode.left;
			removableNode=null;
		}
		}
	public void addBST(int data)
	{
		Node newNode = new Node(data);
		if(currentBSTSize==0)
		{
			bstArr[0]=newNode;
			headNode=newNode;
			currentBSTSize++;
		}
		else
		bstHeapVariantify(headNode,newNode);
	}
	public void bstHeapVariantify(Node headNode, Node newNode)
	{
		if(headNode.data>newNode.data)
		{
			if(headNode.left!=null)
			{
					bstHeapVariantify(headNode.left,newNode);
			}
			else
			{
				headNode.left=newNode;
				bstArr[currentBSTSize]=newNode;
				currentBSTSize++;

			}		
		}
		else
		{
			if(headNode.right!=null)
			{
					bstHeapVariantify(headNode.right,newNode);
			}
			else
			{
				headNode.right=newNode;
				bstArr[currentBSTSize]=newNode;
				currentBSTSize++;
			}
		}

	}
	public void getBST_INORDER(Node headNode)
	{
		//headNode.
		// in order
		if(headNode==null)
			return ;
		getBST_INORDER(headNode.left);
		System.out.println(headNode.data);
		getBST_INORDER(headNode.right);

	//	return getBST(headNode.left)+ headNode.data +  getBST(headNode.right);
	} 
	public void getBST_PREORDER(Node headNode)
	{
		if(headNode==null)
			return ;
		System.out.println(headNode.data);
		getBST_PREORDER(headNode.left);
		getBST_PREORDER(headNode.left);

	}
	Queue<Node> l = new LinkedList();
//	l.offer(headNode);
	
	public void getBST_BFS_LEVELORDER(Node headNode)
	{
		
		java.util.Iterator<Node> iterator = iteratorMethod();
		
		for(int i=0;i<currentBSTSize;i++)
		
			{
			System.out.print(" --- Break");
			iterator.next();

			}

	}
	

	public java.util.Iterator<Node> iteratorMethod()
	{
		Queue<Node> queue = new LinkedList();
		queue.offer(bstArr[0]);
		return new java.util.Iterator<Node>()
		{
			Node temp=null;
			public boolean hasNext()
			{
				
				return !queue.isEmpty();
			}
			public Node next()
			{
				temp=queue.poll();
				System.out.println(temp.data);

				if(temp.left!=null)
					queue.offer(temp.left);
				if(temp.right!=null)
					queue.offer(temp.right);
				
				return temp;
			}
		};
		
	}
}