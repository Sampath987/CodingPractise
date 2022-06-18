package com.custom.stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StackByUs {
	
	char variable;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	// {}
	// []
	// ()
		CustomStack customStack = new CustomStack();
		String l =  "{}{{{{}";
		System.out.println(new StackByUs().validateMethod(l, customStack));
		

		
	}
		

	public boolean validateMethod(String l, CustomStack customStack)
	{
		for(int i=0;i<l.length();i++)
		{
			variable=l.charAt(i);
			if(customStack.list.size()==0 && (variable=='}' || variable == ']' || variable == ')'))
				return false;
			if(variable=='}')
			{
				if(customStack.pop()!='{')
				return false;
			}
			else if(variable==']')
			{
				if(customStack.pop()!='[')
				return false;
			}
			else if(variable==')')
			{
				if(customStack.pop()!='(')
				return false;
			}
			else
			{
				customStack.push(variable);
			}
		}
		if(customStack.list.size()!=0)
			return false;
		
		return true;
		
	}

	}
	
	
	class CustomStack
	{
		String value;
		LinkedList<Character> list = new LinkedList();
		
		public void push(char value)
		{
			list.add(value);
		}
		public char pop()
		{
			char temp = list.get(list.size()-1);
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
				return pop()=='{';
			}
			// STACK, push POP
			return false;
			
		}
		
	}

