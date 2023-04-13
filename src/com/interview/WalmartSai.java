
/* A subarray of an array is a consecutive sequence of zero or more values taken out of that array. 
For example, the array [1, 3, 7] has seven subarrays: [ ] [1]  [3]  [7]  [1, 3]  [3, 7] [1, 3, 7] 
Notice that [1, 7] is not a subarray of [1, 3, 7], because even though the values 1 and 7 
appear in the array, they're not consecutive in the array. Similarly, the array [7, 3] 
isn't a subarray of the original array, because these values are in the wrong order. 
		The sum of an array is the sum of all the values in that array. Your task is to write 
		a function that takes as input an array and outputs the sum of all of its subarrays. 
		For example, given [1, 3, 7], you'd output 36, because [ ] + [1] + [3] + [7] + [1, 3] 
		+ [3, 7] + [1, 3, 7] = 0 + 1 + 3 + 7 + 4 + 10 + 11 = 36
*/

// a,b,c

package com.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WalmartSai {

	public static void main(String[] args) {
		int[] intArrr = new int[] { 2, 3, 7, 8 };  // 4 2 
		
		// 2 3 7 8 = 20
		// 2 3 7   = 12
		// 2 3     = 5
		// 2
		
		//  3 7 8 = 18
		//  3 7   = 10
		//  3     = 3
		// 
		
		// 7 8 = 15
		// 7   = 7
		
		// 8
		
		// a[i]*(length-i)*(i+1) 
	
		int[] newArray = new int[intArrr.length];
		
		int mathFormula = 0;
		for(int i =0 ; i < intArrr.length;i++)
		{
			mathFormula = mathFormula + (intArrr[i]*(intArrr.length-i)*(i+1));
		}
		System.out.println("mathFormula : "+ mathFormula);
		System.arraycopy(intArrr, 0, newArray, 0, intArrr.length);
		
		int sum = 0;
		for(int j =0; j<intArrr.length;j++)
		{
		for(int i =j; i<intArrr.length;i++)
		{
			sum = sum + intArrr[i]*(intArrr.length-i);

		}
		System.out.println(sum + " ---");
		}
		
		
		
		int[] newArrayFromChatGPT = {2, 3, 7, 8};
		int outSum = 0;

		for (int i = 0; i < newArrayFromChatGPT.length; i++) {
		    int innerSum = 0;

		    for (int j = i; j < newArrayFromChatGPT.length; j++) {
		    	System.out.println("j : "+ newArrayFromChatGPT[j]);
		    	innerSum += newArrayFromChatGPT[j];
		    	outSum += innerSum;
		    }
	    	System.out.println("innerSum= "+innerSum);

		}

		System.out.println(" outSum : "+ outSum);

		
		

		
		

		
		
		int[][] matrix = {
			    {1, 2, 3},
			    {4, 5, 6},
			    {7, 8, 9}
			};


		WalmartSai obj = new WalmartSai();

		int[][] intMultiDimensional = {{1, 2}, {2,3, 4, 5}, {6, 7, 8, 9}};
		
 // Output: [2, 4]

		

	//	int[] flatMapArray =
		List<Integer> list = Arrays.stream(intMultiDimensional)
		                           .flatMapToInt(Arrays::stream)
		                           .boxed()
		                           .collect(Collectors.toList());
		
		
		list.stream().forEach(System.out::print);
		
		int finalK = list.stream().reduce(0, (a,b) -> a+b);
 

		System.out.println(finalK);

		                           
//		System.out.println("flatMapArray " + Arrays.toString(flatMapArray));
		
		
		
		String[][] StringArray = new String[][] {{"Sampath7", "Sampath6","Sampath1"},
			  {"Sampath5","Sampath4"}, {"Sampath1","Sampath2","Sampath3"}};
			 
			  String[] StringArray2 =  Arrays.stream(StringArray)
					  					.flatMap(Arrays::stream)
					  					.toArray(String[]::new);
		
			  Arrays.stream(StringArray2).forEach(i -> System.out.println(i));
			  
			  // forEach(System.out::println);
		
		
		
		Model model1 = new Model(1,"sampath1");
		Model model2 = new Model(2,"sampath2");
		Model model3 = new Model(3,"sampath3");
		Model model4 = new Model(4,"sampath4");
		Model model5 = new Model(5,"sampath5");
		Model model6 = new Model(6,"sampath6");
		Model model7 = new Model(7,"sampath7");
		
		Model[][] modelArray = new Model[][]
				{{model1, model3}, {model4,model2,model5},{model1,model6,model7}};
		
//		Model[] modelArray2 =  
		Model[] modelArray2 = Arrays.stream(modelArray).flatMap(Arrays::stream).toArray(Model[]::new);
		
		Arrays.stream(modelArray2).forEach(i -> System.out.println(i.getId() + " " + i.getName()));

		int[][] intMultiDimensional2 = new int[4][4];
				
		for(int i=0; i<intArrr.length;i++)
		{
		for(int j=0; j<intArrr.length-i;j++)
		{
			intMultiDimensional2[i][j] = obj.sum(Arrays.copyOfRange(intArrr, i, intArrr.length-j));
		}
		}
		
	


		int result = 0;
/*		int[] flatMapArray = Arrays.stream(intMultiDimensional2)
			  .flatMap(Arrays::stream)
			  . collection.toArray(new type[collection.size()]);  */
			  
		
		System.out.println("\n \n \n");	
		int finalSum = 0;
		

		for(int i=0; i<intArrr.length; i++)
		{
			for(int j=0; j<intArrr.length-i;j++)
			{
				System.out.println(Arrays.toString(Arrays.copyOfRange(intArrr, i, intArrr.length-j)));
			}
		}

		System.out.println(finalSum);
		
	}

	public int sum(int[] array) {

		int sum = 0;
		for (int element : array) {
			sum = sum + element;

		}
		return sum;
	}
	
}

class Model
{
	int Id;
	String name;
	
	public Model(int Id, String name)
	{
		this.Id = Id;
		this.name = name;
	}
	public int getId() {
		return Id;
	}
	public String getName() {
		return name;
	}
	
}

