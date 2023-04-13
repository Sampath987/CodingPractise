package com.custom.unionfind.disjoint;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UnionFindSecondTime {
	
	Map<Integer, Integer> map = new HashMap();
	boolean isUnionFind = false;

	
	static int[] a = new int[] {0,1,2,3,4,5,6};

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UnionFindSecondTime unionFindDisjointClass = new UnionFindSecondTime();

		
		unionFindDisjointClass.union(0, 6);
		unionFindDisjointClass.union(2, 6);
		unionFindDisjointClass.union(3, 2);
		unionFindDisjointClass.union(1, 6);
		unionFindDisjointClass.union(8, 9);
		unionFindDisjointClass.union(7, 8);
		unionFindDisjointClass.union(5, 7);
		unionFindDisjointClass.union(9, 1);


	//	unionFindDisjointClass.union(2, 1);

		unionFindDisjointClass.find(1);

		unionFindDisjointClass.iterate();
	}
	
	public void union(int child, int parent)
	{
		
			map.put(child, parent);
			isUnionFind=false;
	}
	
	public int find(int child)
	{
		if(!isUnionFind)
		{
			map.values().forEach(i ->
			{
				map.keySet()
				.stream()
				.filter(k -> map.get(k)==i)
				.forEach(l -> map.put(l, map.get(i)));
			});
		}
		isUnionFind = true;
		return map.get(child);
	}
	
	public void iterate()
	{
		map.keySet().forEach(i -> 
		{
			System.out.println("map.get(i) " + i + "  "+ map.get(i));

		});

	}
	
	public UnionFindSecondTime()
	{
		Arrays.stream(a).forEach(i -> 
		{
			map.put(i, i);

		
		});
		


	}
	
}
/*
map.get(i) 0  6   rankMap.get(i) 2
map.get(i) 1  6   rankMap.get(i) 4
map.get(i) 2  6   rankMap.get(i) 4
map.get(i) 3  6   rankMap.get(i) 4
map.get(i) 4  4   rankMap.get(i) 1
map.get(i) 5  5   rankMap.get(i) 1
map.get(i) 6  6   rankMap.get(i) 4  */
