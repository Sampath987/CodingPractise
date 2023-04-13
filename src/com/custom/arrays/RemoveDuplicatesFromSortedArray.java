package com.custom.arrays;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.DirectoryStream.Filter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		

		/*
		 * ModelDemo modelDemo ; // = new ModelDemo(5);
		 * 
		 * System.out.println(Integer.compare(10, 11));
		 * System.out.println(Integer.valueOf(10).compareTo(11));
		 * 
		 * // PriorityQueue<ModelDemo> pq = new PriorityQueue();
		 * 
		 * List<ModelDemo> pq = new ArrayList(); pq.add(new ModelDemo(54)); pq.add(new
		 * ModelDemo(15)); pq.add(new ModelDemo(52)); pq.add(new ModelDemo(25));
		 * 
		 * pq.stream().forEach(System.out::println);
		 */
	}
		/*
		 * 
		 * int[][] arr = {{1, 2}, {3, 4}, {5, 6}}; IntStream stream =
		 * Arrays.stream(arr).flatMapToInt(Arrays::stream);
		 * 
		 * int sum = stream.sum(); System.out.println(sum); // Output: 21
		 * 
		 * 
		 * int[][] twoDimArray = new int[][] {{5, 7}, {11,13}, {2,4,6}};
		 * 
		 * String[][] StringArray = new String[][] {{"Sampath7", "Sampath6"},
		 * {"Sampath5","Sampath4"}, {"Sampath1","Sampath2","Sampath3"}};
		 * 
		 * 
		 * Arrays.stream(StringArray)
		 * 
		 * .flatMap(Arrays::stream) .forEach(I -> System.out.println(" I " + I));
		 * 
		 * 
		 * Arrays.stream(twoDimArray).map(i -> Arrays.stream(i).boxed())
		 * .flatMap(Arrays::stream) .forEach(I -> System.out.println(" I " + I)) ;
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * int[] PrimeNumbers = new int[] {5, 7, 11,13};
		 * 
		 * 
		 * // Creating a list of Odd Numbers int[] OddNumbers = new int[] {1, 3, 5};
		 * 
		 * 
		 * // Creating a list of Even Numbers int[] EvenNumbers = new int[] {2, 4, 6,
		 * 8};
		 * 
		 * // int[][] twoDimArray = new int[][] {PrimeNumbers,OddNumbers,EvenNumbers};
		 * 
		 * System.out.println("The Structure before flattening is : " + twoDimArray);
		 * 
		 * 
		 * 
		 * 
		 * 
		 * System.out.println("The Structure after flattening is : " + twoDimArray);
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * int[] arrMap = new int[] {0,0,1,1,1,1,2,3,3,4,6,6,6,8,8,9};
		 * 
		 * List<Integer> list = Arrays.asList(0,0,1,1,1,1,2,3,3,4,6,6,6,8,8,9);
		 * 
		 * 
		 * int total = (int) Arrays.stream(arrMap).boxed()
		 * .collect(Collectors.groupingBy(i-> i)) .size(); System.out.println("total " +
		 * total);
		 * 
		 * Arrays.stream(arrMap) .filter(i -> Collections.frequency(list, i) > 2)
		 * .forEach(i -> System.out.println("From filter" + i));
		 * 
		 * System.out.println("total " );
		 * 
		 * 
		 * Integer[] intArray = new Integer[arrMap.length]; int k= 0;
		 * 
		 * for(int element:arrMap) { intArray[k] = element; k++; }
		 * 
		 * 
		 * 
		 * Map<Integer, List<Integer>> mapList = Arrays.stream(intArray)
		 * .collect(Collectors.groupingBy(i -> i));
		 * 
		 * // .filter(i -> i.getValue().size() int count = 0; for(int
		 * element:mapList.keySet()) { if(mapList.containsKey(element)) {
		 * if(mapList.get(element).size()>=2) count = count + 2; else count = count + 1;
		 * } }
		 * 
		 * System.out.println("The value of count is--- : " + count);
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * // result should -- [0, 0, 1, 1, 2, 3, 3, 4, 6, 6, 8, 8, 9, 8, 9, 9]
		 * 
		 * // int[] arr = new int[] {1,1,1,2,2,3};
		 * 
		 * 
		 * 
		 * RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();
		 * System.out.println(Arrays.toString(obj.removeDuplicatesAndReturnArray(arrMap)
		 * ));
		 * 
		 * int[] arrremoveDuplicates = new int[] {1,1,1,2,2,3};
		 * 
		 * System.out.println(obj.removeDuplicates(arrremoveDuplicates));
		 * 
		 * 
		 * 
		 * int[] removeDuplicatesShortestWayArray = new int[]
		 * {0,0,1,1,1,1,2,3,3,4,6,6,6,8,8,9};
		 * 
		 * System.out.println("removeDuplicatesShortestWay " +
		 * obj.removeDuplicatesShortestWay(removeDuplicatesShortestWayArray ));
		 * 
		 * 
		 */

	/*
	 * public int removeDuplicatesShortestWay(int[] nums) { int i=0; for(int
	 * element:nums) { if(i<2 || nums[i-2] < element) { nums[i] = element; i++; } }
	 * 
	 * return i;
	 * 
	 * }
	 */

	// 0,0,1,1,1,1,2,3,3,4,6,6,6,8,8,9
	public int removeDuplicatesShortestWay(int[] nums) {
		int i = 0;
		for (int n : nums)
			if (i < 2 || n > nums[i - 2]) {
				nums[i] = n;
				i++;
			}
		return i;
	}

	public int removeDuplicates(int[] nums) {

		int i = 2;

		for (int j = i; j < nums.length; j++) {
			if (nums[i - 2] != nums[j]) {
				nums[i] = nums[j];
				i++;
			}
		}

		return i;

	}

	public int[] removeDuplicatesAndReturnArray(int[] nums) {
		int j = 0;

		for (int i = 2; i < nums.length; i++) {
			if (nums[i - 1] == nums[i] && nums[i] == nums[i - 2]) {
				j = i;
				while (j < nums.length && nums[i] == nums[j]) {
					j++;
				}
				if (j < nums.length) {
					System.arraycopy(nums, j, nums, i, nums.length - j);

				} else {
					j = i - 1;
					break;
				}

			}

			if (i < nums.length - 1 && nums[i] > nums[i + 1]) {
				break;
			}

		}

		System.out.println(j);
		return nums;

	}
	
	class ModelDemo implements Comparable<ModelDemo>
	{
		int k;

	
		public ModelDemo(int k)
		{
			this.k = k;
		}

		public int getK() {
			return k;
		}



		@Override
		public int compareTo(ModelDemo o) {
			// TODO Auto-generated method stub
			return k>=o.getK()?1:-1;
		}
	}
	

}
