package com.custom.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}



class LinkedListTestttttt
{
	List<Node> reverseList = new ArrayList();
	
	public List<Node> reverseMethod(LinkedList<Node> list)
	{
		if(list==null)
			return null;
		else
		{
			Node tail = list.getLast();
			Node temp = tail;
			while(temp!=null)
			{
				 reverseList.add(temp);
				// System.out.println(temp);
			}
		}
		
		return reverseList;
	}
}