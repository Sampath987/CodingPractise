package com.custom.unionfind.disjoint;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UnionFindDisjointClass {

	Map<Integer, Integer> map = new HashMap();
	Map<Integer, Integer> rankMap = new HashMap();

	
	static int[] a = new int[] {0,1,2,3,4,5,6};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 0  1 2 3 4 5 6
		
		// find union iterarteAllwithItsFind
		
		UnionFindDisjointClass unionFindDisjointClass = new UnionFindDisjointClass();
		
		unionFindDisjointClass.find(6);
		unionFindDisjointClass.iterate();
		
		System.out.println();
		System.out.println();
		System.out.println();
		unionFindDisjointClass.find(6);

		System.out.println();

		unionFindDisjointClass.union(0, 6);
		unionFindDisjointClass.union(2, 6);
		unionFindDisjointClass.union(3, 2);
		unionFindDisjointClass.union(1, 6);
		unionFindDisjointClass.union(2, 1);


		unionFindDisjointClass.iterate();


	}
	
	public UnionFindDisjointClass()
	{
		Arrays.stream(a).forEach(i -> 
		{
			map.put(i, i);
			rankMap.put(i, 1);

		
		});
		


	}



	
//	map.put()
	
	public void iterate()
	{
		Arrays.stream(a).forEach(i -> 
		{
			System.out.println("map.get(i) " + i + "  "+ map.get(i) + "   rankMap.get(i) " + rankMap.get(i));

		});

	}
	public int find( int i)
	{
		// System.out.println("map.get(i) " + i + "  "+  map.get(i) + "   rankMap.get(i) " + rankMap.get(i));

			return map.get(i);
	}
	
	public void union(int l, int m)
	{
		if(find(l) != find(m))
		{
			if(rankMap.get(l)>rankMap.get(m))
			{
				map.put(m, map.get(l));
				rankMap.put(l,rankMap.get(l)+1);
				rankMap.put(m,rankMap.get(l));

			}
			else
			{
				map.put(l, map.get(m));
				rankMap.put(m,rankMap.get(m)+1);
				rankMap.put(l,rankMap.get(m));



			}
		}
	}

}
