package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
	       List<String>  mylist = new ArrayList<String>();
	        mylist.add("practice");
	        mylist.add("code");
	        mylist.add("code");
	        mylist.add("quiz");
	        mylist.add("geeksforgeeks");
	   
	        // Here we are using frequency() method
	        // to get  frequency of element "code"
	        int freq = Collections.frequency(mylist, "code");
	   
	        System.out.println("code " +freq);
		
		
		  // System.out.println(97-a);
		  
		  List<Integer> l = new ArrayList<Integer>();
		  l.addAll(Arrays.asList(1,2,5,6,8,9));
		  
		  Iterator it =l.iterator();
			/*
			 * while(it.hasNext()) { if((int)it.next()==5) { System.out.println("Yes " +
			 * it.next()+ "---"+it.next()+ "---"+it.next()); break; } }
			 */
		  it.forEachRemaining(i -> System.out.println("newMethod " +i));
		  
		  
		  for(int i=0;i<l.size();i++)
		  {
			  System.out.println(l.size()+ "  "+i+" "+l.get(i));
			  if(i==2)
			  {
				  
				  l.add(i+1,99);
				  l.add(i+2,200);
				  l.add(i+3,300);
				  
			  }
		  }
		  
	
	//	  Iterator<Integer> it = l.
		 
				  List<Integer> numbers = Arrays.asList(2,3,4,5,2);
				  
			       int sum = numbers.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);
		//	       System.out.println(sum);
			       
			/*       
			       String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
			      // boolean b = 
			       System.out.println(Stream.of(array).map(i-> Stream.of(i).reduce((s,k)-> s.concat(k))).collect(Collectors.toList()).
			    		   stream().map(w->w).reduce((t,w)-> t.	*/	    	//	   reduce(0, (ans, y=Stream.of(i).reduce(0,(x,py) -> x+py)) -> ans+y));
			    		   //flatMap(i-> 
			 //      System.out.println(b);


			    				   int[][] k = {{1,2,3},{2,4,5},{7,8,0}};
			    		   
			 //   		   Stream.of(k).map(i -> Stream.of(i).map(m-> m).reduce((a,b)-> a+b));


		
			    				
			    				   
		/*
		 * String s = "Hey How are you";
		 * 
		 * String s2[] = s.split(" "); List<String> ls = new
		 * ArrayList(Arrays.asList(s2));
		 * 
		 * SelectionSort ss = new SelectionSort(); System.out.println(ss.recursion(ls));
		 * 
		 * }
		 * 
		 * public String recursion(List<String> yes) { if(yes.size()>1) {
		 * 
		 * return recursion(yes.subList(0, yes.size()-2)) + yes.get(yes.size()-1); }
		 * else return yes.get(0);
		 * 
		 */


	}
	

}
