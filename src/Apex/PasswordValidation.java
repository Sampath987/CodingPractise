package Apex;

import java.util.regex.Matcher; 

public class PasswordValidation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String pwd = "Turkey1234~";
	//	String pwd = "appleM7";
	//	String pwd = "1234567890123456789012345678901";


		
		PasswordValidation passwordValidation = new PasswordValidation();
		
		System.out.println(passwordValidation.validate(pwd));
		
		
	}
	
	public boolean validate(String s)
	{
		if(s.length() < 8 || s.length() > 31)
			return false;
		
		if(s.toLowerCase().contains("password"))
			return false;
			
		boolean Capital = false, Number = false, Symbol = false ;

		for(int i = 0; i < s.length(); i++) {

			if((int)s.charAt(i) > 64 && (int)s.charAt(i) < 91 && !Capital)
				Capital = true;
			
			else if(Character.isDigit(s.charAt(i)) && !Number)
				Number = true;
			
			else if(!Character.isLetterOrDigit(s.charAt(i)) && !Symbol)
				Symbol = true;
			
			if(Symbol && Number && Capital )
			{
				System.out.println("---");
				return true;
			}

				System.out.println(Symbol + "--Symbol--" + Number + "--Number--" + Capital + "--Capital--");
		}
		
		return Symbol && Number && Capital;
	}

}



/*

import java.util.regex.Pattern;

public class SimplePassword {
    public static String simplePassword(String str) {
        // Check length
        if (str.length() < 8 || str.length() > 30) {
            return "false";
        }

        // Check for capital letter
        if (!Pattern.compile("[A-Z]").matcher(str).find()) {
            return "false";
        }

        // Check for number
        if (!Pattern.compile("\\d").matcher(str).find()) {
            return "false";
        }

        // Check for punctuation or symbol
        if (!Pattern.compile("[\\p{P}\\p{S}]").matcher(str).find()) {
            return "false";
        }

        // Check for "password" substring
        if (str.toLowerCase().contains("password")) {
            return "false";
        }

        return "true";
    }

    public static void main(String[] args) {
        System.out.println(simplePassword("apple!M7")); // should return "true"
        System.out.println(simplePassword("appleM7")); // should return "false" (no punctuation)
        System.out.println(simplePassword("Password123")); // should return "false" (capitalization)
        System.out.println(simplePassword("mypassword1")); // should return "false" (contains "password")
        System.out.println(simplePassword("1234567aB!")); // should return "false" (too short)
        System.out.println(simplePassword("1234567890123456789012345678901")); // should return "false" (too long)
    }
}

*/


