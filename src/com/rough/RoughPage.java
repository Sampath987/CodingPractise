package com.rough;

public class RoughPage {

}


package com.custom.stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Stack {
	
	String variable;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	// {}
	// []
	// ()
		CustomStack customStack = new CustomStack();
		String l =  "{}([{}]))";
		System.out.println(new Stack().validateMethod(l, customStack));
	
		
	}
		

	public boolean validateMethod(String l, CustomStack customStack)
	{
		for(int i=0;i<l.size()-1;i++)
		{
			variable=l.get(i);
			if(variable.equals("}"))
			{
				if(!customStack.pop().equals("{"))
				return false;
			}
			else if(variable.equals("]"))
			{
				 if(!customStack.pop().equals("["))
				return false;
			}
			else if(variable.equals(")"))
			{
				if(!customStack.pop().equals("("))
				return false;
			}
			else
			{
				customStack.push(variable);
			}
			
			
		}
		return false;
		
	}

	}
	
	
	class CustomStack
	{
		String value;
		LinkedList<String> list = new LinkedList();
		
		public void push(String value)
		{
			list.add(value);
		}
		public String pop()
		{
			String temp = list.get(list.size()-1);
			list.remove(list.size()-1);
			return temp;
		}
		public void get()
		{
			list.stream().forEach(i -> System.out.println(i));
		}

		public boolean test(String test) {

			if(test.equals("}"))
			{
				return pop().equals("{");
			}
			// STACK, push POP
			return false;
			
		}
		
	}

