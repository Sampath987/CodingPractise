package sorting;

import java.util.LinkedList;
import java.util.List;

public class TestingOn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedListNode linkedListNode = new LinkedListNode();
		linkedListNode.insertNode(1);
		linkedListNode.insertNode(10);
		linkedListNode.insertNode(111);
		linkedListNode.insertNode(11);
		linkedListNode.insertNode(9);
		linkedListNode.insertNode(12);
		linkedListNode.insertNode(2);
		linkedListNode.insertNode(122);
		
		Node temp = linkedListNode.head;
		while(temp!=null)
		{
			System.out.println("Head data" + temp.data);
			temp=temp.next;
		}


		
		

		
	}
}

class Node
{
	int data;
	Node next;

	public Node(int current)
	{
		this.data = current;
		this.next = null;
	}
}

class LinkedListNode
{
	Node head;
	public LinkedListNode() {
        this.head = null;
    }
	public void insertNode(int nodeData)
	{
        Node node = new Node(nodeData);
        
		if(this.head==null)
		{
			this.head=node;
		}
		else
		{
			node.next=head;
		}
		this.head=node;
	}
	public Node recursion(Node head)
	{

		// (head)1 -> 3 -> 5 -> 9|| 1 <- 3 5 <- 9
		// 1 <- 3 <- 5

		Node temp = head.next;
		head.next=null;
		
   
		return this.head=node;
	}
}

