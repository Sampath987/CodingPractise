package com.custom.hashmapimpl;

public class CustomHashMapWithNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		NodeCustomHashMap nodeCustomHashMap = new NodeCustomHashMap();
		
		nodeCustomHashMap.put(0, "String0");
		nodeCustomHashMap.put(1, "String1");
		nodeCustomHashMap.put(2, "String2");
		nodeCustomHashMap.put(3, "String3");
		nodeCustomHashMap.put(4, "String4");
		nodeCustomHashMap.put(5, "String5");
		nodeCustomHashMap.put(6, "String6");
		nodeCustomHashMap.put(7, "String7");
		nodeCustomHashMap.put(8, "String8");
		nodeCustomHashMap.put(9, "String9");
		nodeCustomHashMap.put(10, "String10");
		nodeCustomHashMap.put(11, "String11");
		nodeCustomHashMap.put(12, "String12");
		nodeCustomHashMap.put(13, "String13");
		nodeCustomHashMap.put(14, "String14");
		nodeCustomHashMap.put(15, "String15");

		System.out.println(nodeCustomHashMap.getValue(12));
		System.out.println(nodeCustomHashMap.getValue(9));
		System.out.println(nodeCustomHashMap.getValue(10));
		System.out.println(nodeCustomHashMap.getValue(11));
		System.out.println(nodeCustomHashMap.getValue(13));
		System.out.println(nodeCustomHashMap.getValue(14));
		System.out.println(nodeCustomHashMap.getValue(15));

		
	}

}

class NodeCustomHashMap
{	
	int capacity = 16;
	int hashCode;
	Node<Integer , String>[] node = new Node[capacity];
	
	
	public NodeCustomHashMap()
	{
		
	}
	
	public String getValue(int key)
	{
		hashCode = hashCode(key);
		Node currentNode = node[hashCode];


		boolean containsKeyAlready = false;
		
		while(currentNode!=null)
		{
			if(currentNode.key==key)
			{
				containsKeyAlready=true;
				break;
			}
			
			currentNode= currentNode.next;
			
		}
		
		if(containsKeyAlready)
		{
			
			currentNode = node[hashCode];
			while(currentNode!=null)
			{
				if(currentNode.key==key)
				{
					return (java.lang.String) currentNode.value;
					
				}
				
				currentNode= currentNode.next;
				
			}
			
			
		}

		
		return null;
	}
	
	public void put(int key, String value)
	{

		hashCode = hashCode(key);
		
		Node currentNode = node[hashCode];
//		Node temp = node[hashCode];

		
		boolean containsKeyAlready = false;
		
		while(currentNode!=null)
		{
			if(currentNode.key==key)
			{
				containsKeyAlready=true;
				break;
			}
			
			currentNode= currentNode.next;
			
		}
		
		
		if(node[hashCode]==null)
		{
			node[hashCode]= new Node(key, value);
		}
		else if(containsKeyAlready)
		{
			currentNode = node[hashCode];
			while(currentNode!=null)
			{
				if(currentNode.key==key)
				{
					currentNode.value =value;
					break;
				}
				
				currentNode= currentNode.next;
				
			}
		//	
		}
		else
		{
			currentNode=new Node(key, value);
		}
	}
	
	public int hashCode(int key)
	{
		if(key==15)
		{
			return 10;
		}
		
		return key +1;
	}
	
	

}

class Node<Integer , String>
{
	int key;
	String value;
	Node<Integer , String > next;
	
	public Node()
	{
		
	}

	public Node(int key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
}
