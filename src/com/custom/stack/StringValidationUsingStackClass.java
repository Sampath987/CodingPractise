package com.custom.stack;

import java.util.Stack;

public class StringValidationUsingStackClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringValidationUsingStackClass customStack = new StringValidationUsingStackClass();
		String l1 =  "{}[{()}]";
		String l2 = "[]}}}";
		String l3 = "{}[({})]{{{";
		System.out.println(customStack.validateString(l1));
		System.out.println(customStack.validateString(l2));
		System.out.println(customStack.validateString(l3));

	}

	public boolean validateString(String s)
	{
		// {}[{()}]
		// }] or []}}} -> stack becomes empty  & it should return false
		//{}[({})]{{{ -> at the end all open brackets are added & no close brackets are there to validate this
						// this can be validated by checking stack size
		// actual string validation
		Stack<Character> stack = new Stack();
		char ch;
		char peek;
		for(int i=0;i<s.length();i++)
		{
			 ch = s.charAt(i);
			 if(ch == '{' || ch=='[' || ch=='(')
				{
					stack.push(ch);
				}
			 else 
			 {
				 if(stack.size()==0 && (ch == '}' || ch==']' || ch==')'))
				return false;
				else
				{
						peek=stack.peek();
	
						if((ch == '}' && peek=='{' )|| (ch==']' && peek=='[') || (ch==')' && peek=='('))
						{
							stack.pop();
						}
						else
							return false;
				}
				
			 }
		}
		if(stack.size()!=0)
			return false;
		return true;
		
	}
}
