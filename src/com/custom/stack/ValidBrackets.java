package com.custom.stack;

import java.util.Stack;

public class ValidBrackets {

    static boolean isValid(String input){
        if(input==null)
            return true;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <input.length() ; i++) {
            char c = input.charAt(i);
            if(c=='('){
                stack.push(')');
            }else if (c==')'){
                if(stack.isEmpty())
                    return false;
                else
                    stack.pop();
            }
        }
        //if stack is empty at this point, return true
        if(stack.isEmpty())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        String input = "()()(()(()))()";
        System.out.println("is input " + input + " valid: " + isValid(input));
        input = ")()()(";
        System.out.println("is input " + input + " valid: " + isValid(input));
        input = "()())";
        System.out.println("is input " + input + " valid: " + isValid(input));
    }

}