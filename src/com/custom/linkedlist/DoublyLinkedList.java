package com.custom.linkedlist;

public class DoublyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CustomDoublyLinkedList CustomDoublyLinkedList = new CustomDoublyLinkedList();
		CustomDoublyLinkedList.addToDoublyLinkedList(1);
		CustomDoublyLinkedList.addToDoublyLinkedList(10);
		CustomDoublyLinkedList.addToDoublyLinkedList(11);
		CustomDoublyLinkedList.addToDoublyLinkedList(100);
		CustomDoublyLinkedList.addToDoublyLinkedList(19);
		
		// 1, 10, 11, 100, 19
		System.out.println("printing");
		CustomDoublyLinkedList.getDoublyLinkedListFromTailtoHead();
		
		System.out.println("Deleting");

		CustomDoublyLinkedList.deleteElementFromDoublyLinkedList(11);
		CustomDoublyLinkedList.deleteElementFromDoublyLinkedList(1);


		CustomDoublyLinkedList.getDoublyLinkedListFromTailtoHead();

	}
}
	
	class Node 
	{
		int value;
		Node nextNode;
		Node prevNode;
		
		Node()
		{
			
		}
		Node(int value)
		{
			this.value=value;
			this.nextNode=null;
			this.prevNode=null;

		}
		public String toString()
		{
			return "The value of current Node =" + value+ " \n";
			
		}
	}
	
	class CustomDoublyLinkedList
	{
		Node head;
		Node tail;
		
		public void getDoublyLinkedListFromTailtoHead()
		{
			Node temp = tail;
			while(temp!=null)
			{
				System.out.println(temp.toString());
				temp=temp.prevNode;
			}
		}
		public void addToDoublyLinkedList(int value)
		{
			
			Node newNode = new Node(value);
			if(head==null)
			{
				newNode.nextNode=null;
				newNode.prevNode=null;
				head=newNode;
				tail=newNode;
			}
			else
			{
				tail.nextNode = newNode;
				newNode.prevNode=tail;
				tail=newNode;
			}
		}

		public Node deleteElementFromDoublyLinkedList(int value)
		{
			Node temp = tail;
			while(temp!=null && temp.prevNode!=null && temp.prevNode.value!=value)
			{
				temp=temp.prevNode;
			}
			
	//		1 5 9
			if(temp!=null && temp.prevNode!=null && temp.prevNode.prevNode!=null)
			{
				// 1, 10, 11, 100, 19
				// 11, 1
				temp.prevNode=temp.prevNode.prevNode;
				System.out.println("value of temp.prevNode " + temp.prevNode.value);
				System.out.println("value of temp.nextNode " + temp.nextNode.value);
				System.out.println("value of temp.prevNode.nextNode " + temp.prevNode.nextNode.value);


				temp.prevNode.nextNode=temp;
			}
			return null;
	
		}

	}
