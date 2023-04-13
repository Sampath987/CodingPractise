package com.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ChaseCoding {
// Interval - List<Integer> li = 1 3 3 5 7
// Duration - List<Integer> ld = 2 2 1 4 2

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * // Interval - List<Integer> li = new ArrayList(Arrays.asList(1, 3, 3, 5, 7));
		 * // Duration - List<Integer> ld = new ArrayList(Arrays.asList(2, 2, 1, 4, 2));
		 * Answer - 3
		 */
		
		
		/*
		 * List<Integer> li = new ArrayList(Arrays.asList(1, 5, 7, 18, 22)); // Duration
		 * - List<Integer> ld = new ArrayList(Arrays.asList(2, 5, 8, 12, 3)); 
		 * Answer - 3
		 */
		

		/*
		 * List<Integer> li = new ArrayList(Arrays.asList(1, 2, 8, 15)); // Duration -
		 * List<Integer> ld = new ArrayList(Arrays.asList(2, 4, 2, 3)); // * Answer - 3
		 */
		
		List<Integer> li = new ArrayList(Arrays.asList(1,2,5,5,9));
		// Duration - 
		List<Integer> ld = new ArrayList(Arrays.asList(4,5,9,12,12));
		//  * Answer - 2

		
		ChaseCoding chaseCoding = new ChaseCoding();
		chaseCoding.noOfCompaniesToBeAttended(li,ld,0);
		System.out.println(li.size());

	}

	int i = 0;

	public void noOfCompaniesToBeAttended(List<Integer> lCompaniesTimings, List<Integer> lHours, int i) {

		while ((i < lCompaniesTimings.size() - 1)
				&& (lCompaniesTimings.get(i) + lHours.get(i) <= lCompaniesTimings.get(i + 1))) {
			i = i + 1;
		}

		if((i < lCompaniesTimings.size()-1)
			&& ((lCompaniesTimings.get(i) + lHours.get(i)) <= (lCompaniesTimings.get(i + 1) + lHours.get(i + 1))))
		{
			lCompaniesTimings.remove(i + 1);
			lHours.remove(i + 1);
			noOfCompaniesToBeAttended(lCompaniesTimings, lHours, i);

		}else if((i < lCompaniesTimings.size()-1)
				&& ((lCompaniesTimings.get(i) + lHours.get(i)) > (lCompaniesTimings.get(i + 1) + lHours.get(i + 1))))
			{
				lCompaniesTimings.remove(i);
				lHours.remove(i);
				noOfCompaniesToBeAttended(lCompaniesTimings, lHours, i);

			}
		
			/*
			 * else if ((i < lCompaniesTimings.size() - 2) && ((lCompaniesTimings.get(i) +
			 * lHours.get(i)) <= (lCompaniesTimings.get(i + 2))) &&
			 * ((lCompaniesTimings.get(i) + lHours.get(i)) <= (lCompaniesTimings.get(i + 1)
			 * + lHours.get(i + 1)))) { lCompaniesTimings.remove(i + 1); lHours.remove(i +
			 * 1); noOfCompaniesToBeAttended(lCompaniesTimings, lHours, i + 1);
			 * 
			 * } else if ((i < lCompaniesTimings.size() - 2) && ((lCompaniesTimings.get(i+1)
			 * + lHours.get(i+1)) <= (lCompaniesTimings.get(i + 2))) &&
			 * ((lCompaniesTimings.get(i) + lHours.get(i)) > (lCompaniesTimings.get(i + 1) +
			 * lHours.get(i + 1)))) { lCompaniesTimings.remove(i); lHours.remove(i);
			 * noOfCompaniesToBeAttended(lCompaniesTimings, lHours, i + 1);
			 * 
			 * }else if ((i < lCompaniesTimings.size() - 2) && ((lCompaniesTimings.get(i) +
			 * lHours.get(i)) > (lCompaniesTimings.get(i + 1) + lHours.get(i + 1))) &&
			 * ((lCompaniesTimings.get(i+1) + lHours.get(i+1)) >= ((lCompaniesTimings.get(i
			 * + 2))+ lHours.get(i+2)))) // ) { lCompaniesTimings.remove(i);
			 * lHours.remove(i); noOfCompaniesToBeAttended(lCompaniesTimings, lHours, i +
			 * 1);
			 * 
			 * }
			 */

	}

}
