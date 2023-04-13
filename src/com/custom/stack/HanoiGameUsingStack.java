package com.custom.stack;

import java.util.Stack;

public class HanoiGameUsingStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<String> st1 = new Stack<String>();
		Stack<String> st2 = new Stack<String>();
		Stack<String> st3 = new Stack<String>();
		
		st1.push("String1");
		st1.push("String2");
		st1.push("String3");
		st1.push("String4");
		st1.push("String5");
		
		System.out.println("Size of st1.size() " + st1.size() );
		System.out.println("Size of st2.size() " + st2.size() );
		System.out.println("Size of st3.size() " + st3.size() );
		
		st1.forEach(i -> System.out.println(i));

		new HanoiGameUsingStack().recursionForHanoiGame(5,st1,st3,st2);
		
		System.out.println("Size of st1.size() " + st1.size() );
		System.out.println("Size of st2.size() " + st2.size() );
		System.out.println("Size of st3.size() " + st3.size() );

		st3.forEach(i -> System.out.println(i));

	}
	public void recursionForHanoiGame(int n, Stack st1, Stack st3, Stack st2)
	{
		if(n==1)
		{
			System.out.println("Move directly to st3");
			st3.push(st1.pop());
			return ;
		}
		else
		{
			recursionForHanoiGame(n-1, st1,  st2,  st3);
			st3.push(st1.pop());
			recursionForHanoiGame(n-1, st2,  st3,  st1);

		}

	}
}
