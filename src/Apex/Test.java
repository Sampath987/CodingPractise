package Apex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
public class Test {

public static void main(String args[])
{
	
//	System.out.println((int)"g");
 BufferedReader rd;
 OutputStreamWriter wr;
 int k = 0;

try
{
    URL url = new URL("https://coderbyte.com/api/challenges/json/age-counting");
    URLConnection conn = url.openConnection();
    conn.setDoOutput(true);
    wr = new OutputStreamWriter(conn.getOutputStream());
    wr.flush();

    // Get the response
    rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    String line;
    while ((line = rd.readLine()) != null) {
    	System.out.println(line);
    	System.out.println();

    
    	Label:
       for (String part : line.split(",")) {
    	    String[] subparts = part.split("=", 2);
    	    if (" age".equals(subparts[0]) && Integer.valueOf(subparts[1]) > 50) {    	 
    	    	if(k<Integer.MAX_VALUE)
    	    		k++;
    	    	else
    	    		break Label;
    	    }
    	}
    	System.out.println();
    	System.out.println();

    	System.out.println( "The value of K" + k);
    	System.out.println("---");


    }
}
catch (Exception e) {
        System.out.println(k + "  " + e.toString() + "---" + e.getMessage());
    }

  }
}

// Select max(salary) from Employee where salary < (Select max(salary) from Employee) ;