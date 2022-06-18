package com.custom.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
 
public class TopologicalSort
{ 
    Stack<Node> stack;
 
    public TopologicalSort() {
        stack=new Stack<>();
    }
    static class Node
    {
        int data;
        boolean visited;
        List<Node> neighbours;
 
        Node(int data)
        {
            this.data=data;
            this.neighbours=new ArrayList<>();

 
        }
        public void addneighbours(Node neighbourNode)
        {
            this.neighbours.add(neighbourNode);
        }
        public List<Node> getNeighbours() {
            return neighbours;
        }
        public void setNeighbours(List<Node> neighbours) {
            this.neighbours = neighbours;
        }
        public String toString()
        {
            return ""+data;
        }
    }
 
    // Recursive toplogical Sort
    public  void toplogicalSort(Node node)
    {
        List<Node> neighbours=node.getNeighbours();
        for (int i = 0; i < neighbours.size(); i++) {
            Node n=neighbours.get(i);
            if(n!=null && !n.visited)
            {
                toplogicalSort(n);
             //   n.visited=true;
            }
        }
        stack.push(node);
    	node.visited=true;
    }
 
    public static void main(String arg[])
    {
 
        TopologicalSort topological = new TopologicalSort();
		/*
		 * Node node40 =new Node(40); Node node10 =new Node(10); Node node20 =new
		 * Node(20); Node node30 =new Node(30); Node node60 =new Node(60); Node node50
		 * =new Node(50); Node node70 =new Node(70);
		 * 
		 * node40.addneighbours(node10); node40.addneighbours(node20);
		 * node10.addneighbours(node30); node20.addneighbours(node10);
		 * node20.addneighbours(node30); node20.addneighbours(node60);
		 * node20.addneighbours(node50); node30.addneighbours(node60);
		 * node60.addneighbours(node70); node50.addneighbours(node70);
		 */
 
        
        
        Node node5 =new Node(5);
        Node node4 =new Node(4);
        Node node3 =new Node(3);
        Node node2 =new Node(2);
        Node node1 =new Node(1);
        Node node0 =new Node(0);
 
        node5.addneighbours(node2);
        node5.addneighbours(node0);
        node4.addneighbours(node0);
        node4.addneighbours(node1);
        node2.addneighbours(node3);
        node3.addneighbours(node1);
 // results - [4, 5, 0, 2, 3, 1]
        
        
        System.out.println("Topological Sorting Order:");
        topological.toplogicalSort(node5);
 
        // Print contents of stack
        Stack<Node> resultStack=topological.stack;
        while (resultStack.empty()==false)
            System.out.print(resultStack.pop() + " ");
    }
 
}