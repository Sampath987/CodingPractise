package com.custom.binarytrees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BalancedBinarySearchTreeCustomSecondTime {



	Node head;
	
	public static void main(String[] args) {
		
		
		BalancedBinarySearchTreeCustomSecondTime bBST = new BalancedBinarySearchTreeCustomSecondTime();
		bBST.addToBBST_public(5);
		bBST.addToBBST_public(2);
		bBST.addToBBST_public(8);
		bBST.addToBBST_public(1);
		bBST.addToBBST_public(3);
		bBST.addToBBST_public(7);
		bBST.addToBBST_public(9);
		bBST.addToBBST_public(6);
		bBST.addToBBST_public(12);

		// Inorder
		System.out.println("InOrder");
		List<Node> inOrderList = new ArrayList();
		for(Node node: bBST.inOrderIterator(inOrderList, bBST.head))
				System.out.print( node.data + " ");
		
		System.out.println();
		
		// preOrder
		System.out.println("PreOrder");
		List<Node> preOrderList = new ArrayList();
		for(Node node: bBST.preOrderIterator(preOrderList, bBST.head))
				System.out.print( node.data + " ");
		
		System.out.println();
		
		
		  // postOrder 
		System.out.println("postOrder");
		List<Node> postOrderList = new ArrayList(); 
		for(Node node: bBST.postOrderIterator(postOrderList, bBST.head)) 
			System.out.print( node.data + " ");
		  
		  System.out.println();
		  
		  // levelOrder 
		System.out.println("levelOrder");
		  List<Node> levelOrderList = new ArrayList(); 
		  for(Node node: bBST.levelOrderIterator(levelOrderList, bBST.head)) 
			 System.out.print( node.data + " ");
		  
		  System.out.println();
	
	}
	public List<Node> levelOrderIterator(List<Node> list, Node head)
	{
		Queue<Node> queue = new LinkedList();
		queue.offer(head);
		while(!queue.isEmpty())
		{
			Node nodeToBeAddedToList = queue.poll();
			list.add(nodeToBeAddedToList);
			if(nodeToBeAddedToList.left!=null)
			queue.offer(nodeToBeAddedToList.left);
			if(nodeToBeAddedToList.right!=null)
			queue.offer(nodeToBeAddedToList.right);

		}
	
		return list;
	}
	
	public List<Node> postOrderIterator(List<Node> list, Node head)
	{
		if(head!=null)
		{
			postOrderIterator(list, head.left);
			postOrderIterator(list, head.right);
			list.add(head);

		}
	
		return list;
	}
	
	public List<Node> preOrderIterator(List<Node> list, Node head)
	{
		if(head!=null)
		{
			list.add(head);
			preOrderIterator(list, head.left);
			preOrderIterator(list, head.right);
		}
	
		return list;
	}
	
	public List<Node> inOrderIterator(List<Node> list, Node head)
	{
		if(head!=null)
		{
			inOrderIterator(list, head.left);
			list.add(head);
			inOrderIterator(list, head.right);
		}
	
		return list;
	}

	public void addToBBST_public(int k)
	{
		Node newNode = new Node(k);
		if(head==null)
		{
			head = newNode;
		}
		else
		{
			
			addToBBST_private(head, newNode);
			
		}
	}
	public Node addToBBST_private(Node head, Node n)
	{
		if(head.data>n.data)
		{
			if(head.left==null)
				head.left=n;
			else
				addToBBST_private(head.left, n);
		}else
		{
			if(head.right==null)
				head.right=n;
			else
				addToBBST_private(head.right, n);
		}

		height(head);
		balnceFactor(head);
		if(!isBalncedMethod(head))
		{
			heightBalance(head);
		}
		return head;
		
	}
	
	public int height(Node head)
	{
		if(head==null)
			return 0;
		return 1 + Math.max(height(head.left), height(head.right));
	}
	
	public int balnceFactor(Node head)
	{
		head.bf = height(head.left)-height(head.right);
		return 1;
	}
	public boolean isBalncedMethod(Node head)
	{
		
		return head.bf > 1 || head.bf < -1 ? false:true;
	}
	public void heightBalance(Node head)
	{
		if(head.bf>1)
		{
			if(head.left.bf==1)
			{
				Node temp = new Node(head.data);
				head.data = head.left.data;
				head.right = temp;
				head.left.data = head.left.left.data;
				head.left.left = null;
				
			}
			else {
				Node temp = new Node(head.data);
				head.data = head.left.right.data;
				head.right = temp;
				head.left.right = null;

			}
		}
		else if(head.bf<-1)
		{
			if(head.right.bf==-1)
			{
				Node temp = new Node(head.data);
				head.data = head.right.data;
				head.left = temp;
				head.right.data = head.right.right.data;
				head.right.right = null;
				
			}
			else {
				Node temp = new Node(head.data);
				head.data = head.right.left.data;
				head.left = temp;
				head.right.left = null;

			}

		}
	}

}


