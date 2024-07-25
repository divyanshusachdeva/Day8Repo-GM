package com.graymatter;

import java.util.ArrayList;
import java.util.Collection;

public class DemoOnGenerics<T> {
	
	T a;
	T b;
	
//	public int add(int a, int b)
//	{
//		return a + b;
//	}
//
//	public double add(double d1, double d2)
//	{
//		return d1 + d2;
//	}
//	
//	public String add(String s1, String s2)
//	{
//		return s1 + s2;
//	}
	
//	public T add(T a, T b) {
//		if(a instanceof Integer)
//			return (T)(Integer)((Integer)a + (Integer)b);
//		else if (a instanceof String)
//			return (T)(String)((String)a + (String)b);
//		else if (a instanceof Double)
//			return (T)(Double)((Double)a + (Double)b);
//		else
//			return null;
//	}
	
	
	public static <T> void printDetails (Collection<T> collection) {
		
		for (T t:collection) {
			System.out.println(t);
		}
		
	}
	
	
	public static void main(String[] args) {

//		DemoOnGenerics<Integer> dgInt = new DemoOnGenerics();
//		System.out.println(dgInt.add(45,67));//		
//		DemoOnGenerics<Double> dgDouble = new DemoOnGenerics();
//		System.out.println(dgDouble.add(35.76,12.23));//		
//		DemoOnGenerics<String> dgStr = new DemoOnGenerics();
//		System.out.println(dgStr.add("Hello ","Divyanshu"));
		
		ArrayList<String> alist = new ArrayList<String>();
		alist.add("Orange");
		alist.add("Mango");
		alist.add("Guava");
		alist.add("Papaya");
		alist.add("Banana");
		alist.add("Apple");
		
		System.out.println(alist);
		
		printDetails(alist);
		
		
		ArrayList<Integer> intList = new ArrayList<Integer>();
		intList.add(34);
		intList.add(62);
		intList.add(19);
		intList.add(94);
		intList.add(29);
		
		printDetails(intList);
		
		
	}

}
