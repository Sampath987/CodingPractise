package com.custom.hashmapimpl;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class HashMapImplMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CustomHashMap customHashMap = new CustomHashMap();

		customHashMap.put(0, "String0");
		customHashMap.put(1, "String1");
		customHashMap.put(2, "String2");
		customHashMap.put(3, "String3");
		customHashMap.put(4, "String4");
		customHashMap.put(5, "String5");
		customHashMap.put(6, "String6");
		customHashMap.put(7, "String7");
		customHashMap.put(8, "String8");
		customHashMap.put(9, "String9");
		customHashMap.put(10, "String10");
		customHashMap.put(11, "String11");
		customHashMap.put(12, "String12");
		customHashMap.put(13, "String13");
		customHashMap.put(14, "String14");
		customHashMap.put(15, "String15");

		System.out.println(customHashMap.get(9));
		System.out.println(customHashMap.get(10));
		System.out.println(customHashMap.get(11));
		System.out.println(customHashMap.get(12));
		System.out.println(customHashMap.get(13));
		System.out.println(customHashMap.get(14));
		System.out.println(customHashMap.get(15));

	}

	
	// Object (Key, Value);
	// put(key, value) -> generates hashCode and set(hashCode, object 2)
	//						object2 (hashCode, key, value)
}

class CustomHashMap
{
	
	int hashCode;
	Set<ObjectModelClass> set = new HashSet();
	public void put(int key, String value)
	{
		hashCode = hash(key);
		
		boolean b = contanis(hashCode);
		
		if(b)
		{
			
			set.stream().filter(i -> i.hashCode==hashCode).findFirst().get().put(key, value);
		}
		else
		{
			ObjectModelClass objectModelClass = new ObjectModelClass();
			objectModelClass.hashCode= hashCode;
			objectModelClass.put(key, value);
			set.add(objectModelClass);

		}	
		
	}
	
	public String get(int key)
	{
		hashCode = hash(key);
		
		if(!contanis(hashCode))
			return null;
		
		return set.stream().filter(i -> i.hashCode==hashCode).findFirst().get().get(key);

		
	}

	
	public boolean contanis(int hashCode)
	{
		return set.stream().filter( i -> i.hashCode==hashCode).count()>0;
	}
	
	public int hash(int key)
	{
		if(key==15)
		{
			return 10;
		}
		
		return key +1;
	}
}

class ObjectModelClass
{
	int hashCode;
	LinkedList<Model> l = new LinkedList();
	
	
	public void put(int key, String value)
	{
		Model model = new Model(key, value);
		l.add(model);
	
		
		
	}
	
	public String get(int key)
	{
		return l.stream().filter(i -> (i.key == key)).findFirst().get().value;
	}
	

	
	
	
}

class Model
{
	int key;
	String value;
	
	public Model()
	{
		
	}
	
	public Model( int key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}