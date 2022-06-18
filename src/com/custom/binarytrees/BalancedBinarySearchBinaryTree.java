package com.custom.binarytrees;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class BalancedBinarySearchBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		CustomBalancedBinarySearchBinaryTree bBST = new CustomBalancedBinarySearchBinaryTree();
		bBST.addToBBST_public(5);
		bBST.addToBBST_public(2);
		bBST.addToBBST_public(8);
		bBST.addToBBST_public(1);
		bBST.addToBBST_public(3);
		bBST.addToBBST_public(7);
		bBST.addToBBST_public(9);
		bBST.addToBBST_public(6);
		bBST.addToBBST_public(12);

		Iterator<Node> temp = bBST.iterateInOrder(bBST.head);
		
		for(int i=0; i<9;i++)
		{
			System.out.println(temp.next().data);
		}
		
		System.out.println("Check Height Balance" + bBST.isBalanced(bBST.head.left));
		System.out.println("Check Height Balance" + bBST.isBalanced(bBST.head.right));
		System.out.println("Check Height Balance" + bBST.isBalanced(bBST.head.left.right));
		System.out.println("Check Height Balance" + bBST.isBalanced(bBST.head.left.left));
		System.out.println("Check Height Balance" + bBST.isBalanced(bBST.head.left.left.left));


	}

}

class CustomBalancedBinarySearchBinaryTree
{
	Node head=null;

	Node[] bBST = new Node[15];
	int currentPoint =0;
	
	public CustomBalancedBinarySearchBinaryTree()
	{
		
	}
	
	public void addToBBST_public(int k)
	{
		
		Node temp = new Node(k);
		if(currentPoint==0)
		{
			bBST[currentPoint]=temp;
			currentPoint++;
		}
		else
		{
			head=bBST[0];
			addToBBST_private(head, temp);
			
		}
	}
	
	public Node addToBBST_private(Node head, Node n)
	{
		
		if(head.data>n.data)
		{
			if(head.left==null)
			{
				head.left=n;
				currentPoint++;
				return n;
			}
			else
			{
				addToBBST_private(head.left,n);
				
			}
		}
		else //head.data<=n.data
		{
			if(head.right==null)
			{
				head.right=n;
				currentPoint++;
				return n;

			}
			else
			{
			addToBBST_private(head.right,n);
			}
		}
		balanceFactor(head);
		return heightBalance(head);
	}
	
	public void balanceFactor(Node head)
	{
		head.bf=height(head.right)-height(head.left);

	}
	public Node heightBalance(Node head)
	{
		while(!isBalanced(head) )
		{
			if(head.bf==-2)
			{
				balanceFactor(head.left);
				if(head.left.bf==-1)
				{
					Node newNode = new Node(head.data);
					head.right = newNode;
					head.data=head.left.data;
					head.left.data=head.left.left.data;
					head.left.left=null;
					
				}
				else
				{
					Node newNode = new Node(head.data);
					head.right = newNode;
					head.data=head.left.right.data;
					head.left.right=null;
				}
			}
			else if(head.bf==2)
			{
				balanceFactor(head.right);
				if(head.right.bf==1)
				{
					Node newNode = new Node(head.data);
					head.data=head.right.data;
					head.left = newNode;
					head.right.data=head.right.right.data;
					head.right.right=null;
				}
				else
				{
					Node newNode = new Node(head.data);
					head.data = head.right.left.data;
					head.left=newNode;
					head.right.left=null;
				}
			}
				
			
		}
		
		return head;
	}
	
	public boolean isBalanced(Node head)
	{
		if(head.bf>1 || head.bf <-1)
		{
			return false;
		}
		return true;
	}
	public int height(Node head)
	{
		if(head==null)
		return 0;
		return 1+ Math.max(height(head.left), height(head.right));
	}
	
	// GET -InOrder
	public void inOrder(Node head)
	{
		if(head==null)
			return ;
		inOrder(head.left);
		System.out.println(head.data);
		inOrder(head.right);
	}
	
	
	public void firstMethod(Stack st, Node head)
	{
		while(head!=null)
		{
			st.push(head);
			head = head.left;
		}
	}
	
	
	// may be preOrder-or something else 
		public Iterator<Node> iterateInOrder(Node head)
		{
			Stack<Node> st = new Stack();
			firstMethod(st, head);
			return new Iterator<Node>() {
				Node temp =head;

				@Override
				public boolean hasNext() {
					// TODO Auto-generated method stub
					return head==null;
				}

				@Override
				public Node next() {
					// TODO Auto-generated method stub
					
					Node stackHead= st.pop();
					
					System.out.println("from Iterator" + stackHead.data);
					
					
					firstMethod(st, stackHead.right);
				
					return stackHead;

			

				}
				
			};
			
	}	
	
	// may be preOrder-or something else 
	public Iterator<Node> iterate(Node head)
	{
		Queue<Node> st = new LinkedList();
		st.offer(head);
		return new Iterator<Node>() {
			Node temp =head;

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return head==null;
			}

			@Override
			public Node next() {
				// TODO Auto-generated method stub
				
				Node queueHead= st.poll();
				
				System.out.println("from Iterator" + queueHead.data);
				
				st.offer(queueHead.left);
				st.offer(queueHead.right);
				return queueHead;

		

			}
			
		};
		
	}

}

