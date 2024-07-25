package com.graymatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DemoOnStreams {

	public static void main(String[] args) {

		Integer arr[] = new Integer[] {10,45,73,36,81,68,11,92,62,74,54,23,47};
		//Arrays.stream(arr);
		//Arrays.stream(arr).forEach(i->System.out.println(i));
		
		List<Integer> list = Arrays.stream(arr) // Stream generation
		
		.limit(10)
		.filter(i->i%2==0) //Filter and map are intermediate operations
		.map(i->i+10)
//		.forEach(i->System.out.println(i));
		.collect(Collectors.toList());
	

// Take an array list. Make the word capital that has ending from E.
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("Hello");
		al.add("World");
		al.add("How");
		al.add("Are");
		al.add("You");	
		al.add("How");
		al.add("Service");
		al.add("Divyanshu");
		
		System.out.println(al);
		
		al.stream()
		.filter(s-> s.endsWith("e"))
		.map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));

		
//Perform addition in arr.
		System.out.println(Arrays.stream(arr).skip(10).reduce(0, (a,b)->a+b));
		
		
// Perform factorial on first 5 numbers		
		Integer ar[] = new Integer[]{14, 21, 13, 52, 3};
		
		Arrays.stream(ar).limit(5).map(i->{
			int fact = 1;
			for(int num = 1; num<=i; num++)
				fact = fact*num;
			return fact;
		}).forEach(i->System.out.println(i));
		
		
// List of strings and then calculate the length of each string
// Whose length s more than 5, convert to upper case

		al.stream().filter(s->s.length()>5)
		.map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		System.out.println(Arrays.stream(ar).mapToInt(i->i).sum());
		System.out.println(Arrays.stream(ar).mapToInt(i->i).max());
		System.out.println(Arrays.stream(ar).mapToInt(i->i).min());
		Arrays.stream(ar).mapToInt(i->i).sorted().forEach(i->System.out.println(i));
		
		System.out.println("\nMax element: ");
		System.out.println(Arrays.asList(ar).stream().mapToInt(i->i).max().getAsInt());
		
		System.out.println("\nMin element: ");
		System.out.println(Arrays.asList(ar).stream().mapToInt(i->i).max().getAsInt());
		
		System.out.println("\nSecond smallest element: ");
		System.out.println(Arrays.stream(ar)
		.sorted()
		.skip(1)
		.findFirst());
		
		
		System.out.println("\nSecond highest element: ");
		System.out.println(Arrays.stream(ar)
		.sorted(Comparator.reverseOrder())
		.skip(1)
		.findFirst());

	
// WAP to implement a lambda expression to sort a list of strings in alphabetical order.
// WAP to implement a lambda expression to find the average of list of doubles.
// WAP to implement a lambda expression to check if a number is prime.
// WAP to implement a lambda expression to concatenate 2 strings.
// WAP to implement a lambda expression to count the words in a paragraph.
		
		
		
		
		
	
	
	}

}
