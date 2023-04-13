package Apex;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AgeCounter {

	
	    public static void main(String[] args) {
	        try {
	            URL url = new URL("https://coderbyte.com/api/challenges/json/age-counting");
	            HttpURLConnection con = (HttpURLConnection) url.openConnection();
	            con.setRequestMethod("GET");

	            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	            String response = in.readLine();

	            Pattern pattern = Pattern.compile("age=(\\d+)");
	            Matcher matcher = pattern.matcher(response);

	            int count = 0;
	            while (matcher.find()) {
	                int age = Integer.parseInt(matcher.group(1));
	                if (age >= 50) {
	                    count++;
	                }
	            }

	            System.out.println(count);

	            in.close();
	            con.disconnect();

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

