package secondtime.com.string;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class StringReverse {

	public static void main(String[] ars)
	{
		StringReverse sr = new StringReverse();
		String string = "Sampath";
	//	System.out.println(sr.revrseString(string));
		
		
		char[] ar = string.toCharArray();
		
		int k = ar.length;
		
		List<Integer> li = string.chars().collect(null, null, null)
	
		string.chars().forEach(i -> System.out.println(i+ " " + (char)i));
		
		
		
		
	}
	
	public String revrseString(String s)
	{
		if(s.length()<2)
			return s;
		
		System.out.println(s.charAt(s.length()-1));
		
		return s.substring(s.length()-1) + revrseString(s.substring(0, s.length()-1));
	}
}
